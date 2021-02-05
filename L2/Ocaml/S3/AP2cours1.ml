(* fusion de deux listes triees par ordre croissant *)
(* produisant la liste contenant toutes les valeurs *)
(* par ordre croissant *)

let rec fusion(stud_A1, stud_A2 : int list * int list) : int list =
  if stud_A1 = []
  then stud_A2
  else
    if stud_A2 = []
    then stud_A1
    else 
      let (s1, r1) : int * int list = (fst(stud_A1), rem_fst(stud_A1)) 
              and (s2, r2) : int * int list = (fst(stud_A2), rem_fst(stud_A2)) 
      in 
        if s1 < s2
        then add_fst(fusion(r1, stud_A2), s1)
        else add_fst(fusion(stud_A1, r2), s2)
;;

(* --------------------------------- *)
(* --------------------------------- *)
(* recherche de l'existence d'une valeur dans une liste *)

let rec seek_val(c, q : int * int list) : bool =
  if q = []
  then false
  else
    if c = fst(q)
    then true
    else seek_val(c, rem_fst(q))
;;

(* --------------------------------- *)
(* --------------------------------- *)
(* recherche de la valeur minimale dans une liste *)

let min(a, b : int * int) : int =
  if a < b
  then a
  else b
;;

let rec seek_min_aux(c, q : int * int list) : int =
  if q = []
  then c
  else
    let d = min(c, fst(q)) in
      seek_min_aux(d, rem_fst(q))
;;

let seek_min(q : int list) : int =
  if q = [] 
  then failwith "erreur seek_min : la liste est vide"
  else seek_min_aux(fst(q), rem_fst(q))
;;

(* --------------------------------- *)
(* --------------------------------- *)
(* differentes variantes du calcul de 2 puissance n *)

(* complexite (en temps) constante, mais resultat pouvant etre *)
(* faux, du fait de la conversion int <-> float *)

let rec pow2_V0(n : int) : int =
  let x : float = float_of_int(n) in
    int_of_float(2.0 ** x)
;;

(* complexite (en temps) exponentielle *)

let rec pow2_V1_aux(n : int) : int =
  if n = 0
  then 1
  else pow2_V1_aux(n-1) + pow2_V1_aux(n-1)
;;

let pow2_V1(n : int) : int = 
  if n < 0 
  then failwith "erreur : exposant négatif"
  else pow2_V1_aux(n)
;;


(* complexite (en temps) lineaire : version recursive *)

let rec pow2_V2_aux(n : int) : int =
  if n = 0
  then 1
  else 2 * pow2_V2_aux(n-1)
;;

let pow2_V2(n : int) : int = 
  if n < 0 
  then failwith "erreur : exposant négatif"
  else pow2_V2_aux(n)
;;


(* complexite (en temps) lineaire : version iterative *)

let pow2_V3(n : int) : int =
  if n < 0
  then failwith "erreur : exposant négatif"
  else
    (
    let v : int ref = ref 1 in
      for i = 1 to n
      do v := 2 * !v
      done ;
    !v ;
    )
;;

(* complexite (en temps) logarithmique *)

let rec pow2_V4_aux(n : int) : int =
  if n = 0
  then 1
  else 
    let x : int = pow2_V4_aux(n / 2) in
      if n mod 2 = 0
      then x * x
      else 2 * x * x 
;;

let pow2_V4(n : int) : int = 
  if n < 0 
  then failwith "erreur : exposant négatif"
  else pow2_V4_aux(n)
;;

(* --------------------------------- *)
(* --------------------------------- *)
(* estimation du temps d'execution d'une fonction *)

let st : float = Sys.time() in
  ignore(pow2_V1(30)) ;
  Sys.time() -. st
;;

