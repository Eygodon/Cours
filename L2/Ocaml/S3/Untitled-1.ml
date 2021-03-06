#use "AP2util.ml";;



 *)
let i : 'a  t_file = [ 5 ; 2 ; 4]
and j : 'a  t_file = [ 3 ; 8 ; 9]
;;


let o : ('a t_file) list = [[1 ; 2 ; 3]; []; [5;2;7]]
;;
flatten(o);;
(*
type t_cust = {
         name : string ;
         prob : int
       }
;;

let init (n : init) : (t_cust t_file) list =
  ignore();;

let add_cust (c , flis : t_cust * (t_cust t_file) list) : (t_cust t_file) list =
  let file : t_cust t_file = nth(flis, c.prob-1) in
  let new_file : t_cust t_file = add_lstf(file, c)
  and temp_flis = rem_nth(flis, c.prob-1) in
  add_nth(temp_flis, new_file, c.prob-1)
;;
    


let rec repart_cust_aux (f, flis : t_cust t_file * (t_cust t_file) list) : (t_cust t_file) list =
  let max_prob : int = len(flis)-1 in 
  if len(f) = 0
  then flis
  else (
         if (fst(f)).prob > max_prob
         then repart_cust_aux(rem_fst(f),flis)
         else repart_cust_aux(rem_fst(f), add_cust(fstf(f),flis))
       )
;;

let rec maxval (t : int t_btree) : int =
  if bt_isempty(t)
  then -1
  else
    (
      let (r,g,g) : int * int t_btree * int t_btree = bt_rootval(t) , bt_leftst(t), bt_rightst(t) in
      if bt_isempty(g) && bt_isempty(d)
      then r
      else
        (
          if bt_isempty(d) && not bt_ismpty(g)
          then max2int(r, maxval(g))
          else
            (
              if  bt_isempty(g) && not bt_ismpty(d)
              then max2int(r , maxval(d))
              else max3int(r, maxval(d),maxval(g))
            )
        )
    )
;;

let rec maxvalabr (t : int t_btree) : int =
  if bt_isempty(t)
  then -1
  else maxvalabr(bt_rightst(t))
;;
 *)

(*ex1 TP piles*)
let lenp (p : 'a t_pile) : int =
  len(p)
;;

let rec mult_pile ( p, coeff : int t_pile * int ) : int t_pile =
  if lenp(p) = 0
  then []
  else
    add_fstp(mult_pile(rem_fstp(p), coeff), fstp(p) * coeff)
;;

let rec inverse_pile (p : int t_pile) : int t_pile =
  if len(p) = 0
  then []
  else
    add_fstp(inverse_pile(rem_lst(p)),lst(p))
;;
(* exo 2*)

let lenf (f : 'a t_file) : int =
  len(f)
;;

let rec mult_file (f , coeff : int t_file * int) : int t_file =
  if lenf(f) = 0
  then []
  else
    add_fst(mult_file(rem_fstf(f), coeff), fstf(f) * coeff)
;;

let rec inverse_file (f : int t_file) : int t_file =
  if lenf(f) = 0
  then []
  else
    add_fst(inverse_file(rem_lst(f)),lst(f))
;;

(* exo 3*)
type 'a t_mypile ={
    arval : 'a array;
    arrLen : int;
    pileLen : int ref
  }
;;

let mypile_len (p : 'a t_mypile) : int =
  !(p.pileLen)
;;

let mypile_make_empty(n, v : int * 'a) : 'a t_mypile =
  {arval = arr_make(n,v); arrLen = n; pileLen = ref 0}
;;

let mypile_is_empty(p : 'a t_mypile) : bool =
  !(p.pileLen) = 0
;;

let mypile_fstp(p : 'a t_mypile) : 'a =
    p.arval.(arr_len(p.arval)- !(p.pileLen))
;;

let mypile_add_fstp(p, v : 'a t_mypile * 'a) : unit =
  p.arval.((arr_len(p.arval)-1) - !(p.pileLen)) <- v;
  p.pileLen := !(p.pileLen) +1;
;;

let mypile_rem_fstp(p : 'a t_mypile) : unit =
  p.pileLen := !(p.pileLen) - 1;
;;


(*ex4*)
type t_mlbox = int t_pile ;;

type t_mlwork ={
    todo : t_mlbox;
    wip  : int
  }
;;

let init_ml(): t_mlwork =
  {todo = [];
   wip  = 0
  }
;;

let  add_work( p , fr : t_mlbox * int) : t_mlbox =
  let temp : int = rand_int(0,2*fr) in
  if temp = 0
  then p
  else    
  add_fstp(p, rand_int(0, 2 * fr))
;;

(**************Arbres***************)

let rec abr_is_locally_complete (bt : 'a t_btree) : bool =
  let(r, g, d : 'a * 'a t_btree * 'a t_btree) = bt_rootval(bt), bt_leftst(bt), bt_rightst(bt) in
  if bt_isempty(bt)
  then true
  else
    ( if bt_isempty(g) && not(bt_isempty(d)) || not(bt_isempty(g)) && bt_ isempty(d)
      then false
      else bt_is_locally_complete(d) && bt_is_locally_complete(g)
    )
;;

let is_complete (bt : 'a t_btree) : bool =
  abr_is_locally_complete(bt) && bt_nbnode(bt) = int_of_float((2. ** float_of_int(bt_height(bt)) -. 1.))
;;

let props ( bt : 'a t_btree ) : bool =
  bt_nbleaf(bt) = bt_nbnode(bt) + 1
;;

let rec  build_tree(v, h : int * int ): int t_btree =
  if h = 0
  then bt_create(v, Bnil, Bnil)
  else
    (
      bt_create(v, build_tree(v,h-1),build_tree(v,h-1))
    )
;;
let node() : bool =
  rand_int(0, 1) = 1
;;

let rec build (v, h : int * int ) : int t_btree =
  let node : bool = (rand_int(0,1) = 1) in
  if h = 0
  then bt_create (v, Bnil, Bnil)
  else
    (
      if node = true
      then bt_create(v, build_tree(v, h-1), build_tree(v, h-1))
      else bt_create(v, build_tree(v,0), build_tree(v, 0))
    )
;;

(**********CC1***********)

let rec  heronV1 (x, n : float * int ) : float =
  if n = 0
  then 1.0
  else ((heronV1(x, n-1) +. x)/. heronV1(x, n-1))/. 2.0
;;

let rec heronV2 (x, n : float * int) : float =
  let previous_heron : float = heronV2(x, n-1) in
  if n = 0
  then 1.0
  else ((previous_heron) +. x /. previous_heron) /. 2.
;;

let rec concfile (f1 , f2 : 'a t_file * 'a t_file ) : 'a t_file =
  if   f1 = []
  then f2
  else
    (
      if   f2 = []
      then f1
      else concfile(add_lst(f1, fst(f2)), rem_fst(f2))
    )
;;

let rec flatten (flis : ('a t_file) list) : 'a t_file   =
  if len(flis) = 0
  then fst(flis)
  else
    (
     
          if len(nth(flis, 1)) = 0
          then flatten(rem_nth(flis, 1))
          else
            (
              let conc  = concfile(fst(flis), nth(flis, 1)) in
              let new_file  = rem_fst(rem_fst(flis)) in
              flatten(add_fst(new_file, conc))
            )
        
    )
;;

(********************tableaux***************)

type t_point = {x : int ; y : int };;
type t_pointarr = { array : t_point array ; len : int};;
type t_Bsegm = { mat : t_mat

(* section test*)
let p : 'a t_pile = [12; 2; 3; 7; 8];;
lenp(p);;
mult_pile(p,2);;
inverse_pile(p);;
let f : int t_file = [5; 2; 8; 40];;
lenf(f);;
mult_file(f, 2);;
inverse_file(f);;
let mp : 'a t_mypile = mypile_make_empty(5,0);;
mypile_is_empty(mp);;
mypile_fstp(mp);;
mypile_add_fstp(mp, 5);;
mypile_rem_fstp(mp);;
mp;;
let mail : t_mlbox = [];;
let work : t_mlwork = init_ml();;
add_work(mail, 10);;

build_tree(2,3);;
node();;
build(2,3);;
heronV2(5., 2);;

concfile( [5;2;3] , [2;5;8]);;
