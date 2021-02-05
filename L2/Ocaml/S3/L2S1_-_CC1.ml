(* CC1 S2 Algo prog | le 6/11/19 *)

#load "graphics.cma";;
#use "AP2util.ml";;
#use "AP2TP1etu.ml";;
#use "graphique.ml";;
#use "AP2TP1draw.ml";;
#use "ap1_array.ml";;

(* Exercice 1 *)

let rec heronV1 (x, n : float * int ): int =
	if n = 0
	then 1
	else int_of_float(((float_of_int(heronV1(x, n-1)) +. x) /. float_of_int(heronV1(x, n-1))) /. 2.)
;;


heronV1(125.,10);

let rec heronV2 (x,n : float * int) :int = 
	if n = 0
	then 1
	else 
	(
		let temp : float = float_of_int(heronV2(x, n-1)) in
		int_of_float(((temp +. x) /. temp) /. 2.)  (* Ne compile pas pour une raison inconnue, mais osef*)
	)
;;

(* Exercice 2 *)

let rec concfile ( f1, f2 : 'a t_file * 'a t_file ): 'a t_file = 
	if len(f2) = 0
	then f1
	else 
	(
		let fst_f2 = fstf(f2) and new_f2 = rem_fstf(f2) in
		concfile(add_lstf(f1, fst_f2), new_f2)
	)
;;

let rec flatten ( flis : ('a t_file) list ) : 'a t_file = 
	if len(flis) = 0
	then fst(flis)
	else 
		(
		 if len(nth(flis, 1)) = 0
		 then flatten(rem_nth(flis, 1))
		 else 
			(
			let conc = concfile(fst(flis), nth(flis, 1)) 
			and new_flis = rem_fst(rem_fst(flis)) in
			flatten(add_fst(new_flis, conc))
			)
		)
;;		

type t_cust = {name : string ; prob : int};;


let init(n: int) : (t_cust t_file) list =
	ignore()
	;;

let rec add_cust (c , flis : t_cust * (t_cust t_file) list ) : (t_cust t_file) list = 
	let file : t_cust t_file = nth(flis, c.prob-1) in
	let new_file : t_cust t_file = add_lstf(file, c) in
	let temp_flis = rem_nth(flis, c.prob -1) in 
	add_nth(temp_flis, new_file, c.prob-1)
;;

let repart_cust(f, n : t_cust t_file * int): (t_cust t_file) list = 
	repart_cust_aux(f, init(n))
;;

let rec repart_cust_aux (file, flis : t_cust t_file * (t_cust t_file) list ) : (t_cust t_file) list =
	let max_prob : int = len(flis) - 1 in
	if len(file) = 0
	then flis
	else 
		(
		 if (fstf(file)).prob > max_prob
		 then repart_cust_aux(rem_fstf(file), flis)
		 else repart_cust_aux(rem_fstf(file), add_cust(fstf(file), flis))
		)
;;

let schmurtz (f, nb : t_cust t_file * int): t_cust t_file =
	flatten(repart_cust(f, nb))
;;

(* Exercice 3 *)

let max2int(a,b:int*int):int=1;;
let max3int(a,b,c:int*int*int):int=1;;

let rec valmax (t : int t_btree): int =
	if bt_isempty(t)
	then -1
	else
		(
			let (r, g, d) = (bt_rootval(t), bt_leftst(t), bt_rightst(t)) in
			if bt_isempty(g) || bt_isempty(d)
			then 
				(
					if bt_isempty(g) && bt_isempty(d)
					then r
					else 
						(
							if bt_isempty(g)
							then max2int(r, valmax(d))
							else max2int(r, valmax(g))
						)
				)
			else max3int(r, valmax(g), valmax(d))
		)
;;

let rec maxvalabr(t : int t_btree): int =
	if bt_isempty(t)
	then bt_rootval(t)
	else maxvalabr(bt_rightst(t))
;;


