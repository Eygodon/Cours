#use "AP2util.ml" ;;

(* SUJET A *)

(* Mettre NOM et Prenom ici *)

(* exercice 1a *)

let rec mult2(li : int list) : int list =
  if len(li) = 0
  then []
  else add_fst(mult2(rem_fst(li)), fst(li)*2)
;;


   (* a completer. Voyez si vous avez besoin d'une fonction auxilliaire. A ce moment la vous aurez let mult2(...) et let rec mult2aux(...) 
*)

;;

(* exercice 1b *)

let rec unsurdeux_aux(li, temp, ind : 'a list * 'a list * int) : 'a list =
  if len(li) = 0
  then temp
  else
    (
      if ind mod 2 = 0
      then unsurdeux_aux(rem_fst(li), add_lst(temp, fst(li)), ind + 1)
      else unsurdeux_aux(rem_fst(li), temp, ind +1)
    )
;;

let rec unsurdeux (li : 'a list) : 'a list =
  unsurdeux_aux(li,[],1)
;;

           
   (* a completer. Meme remarque sur la fonction auxilliaire *)

;;

(* pour les tests *)

(* Test exercice 1 *)

let liste1=[1; 2 ; 3; 4; 5 ; 6];;
let liste2=[];;

mult2(liste1);;
mult2(liste2);;

unsurdeux(liste1);;
unsurdeux(liste2);;

*)

(* ________________________________________________________ *)


(* exercice 2 *)

let rec div2(t : int t_btree) : int t_btree =
  if bt_isempty(t) 
  then bt_empty()
  else
    (
      bt_create(bt_rootval(t)/2, div2(bt_leftst(t)), div2(bt_rightst(t)))
    )
;;



(* a completer. Meme remarque sur les fonctions auxiliaires que pour la question 1a *)




(* pour les tests *)


let arbre1 : int t_btree = Bnode(5, Bnode(3, Bnode(6, Bnil, Bnode(7, Bnode(1, Bnil, Bnil), Bnil)), 
  Bnode(2, Bnil, Bnil)), Bnode(0, Bnode(8, Bnil, Bnil), Bnode(4, Bnode(9, Bnil, Bnil), Bnil))) ;;
let arbre2: int t_btree = Bnode(10,Bnil,Bnil);;
let arbre3: int t_btree = Bnil;;

div2(arbre1);;
div2(arbre2);;
div2(arbre3);;



(* ________________________________________________________ *)


(* exercice 3 *)
let rec file2pile_aux ( f , p : 'a t_file * 'a t_pile): 'a t_pile =
  if f = []
  then p
  else
    (
      file2pile_aux(rem_fstf(f), add_fstp(p, fstf(f)))
    )
;;

let rec file2pile(f : 'a t_file) : 'a t_pile =
  file2pile_aux(f,[])
;;


(* a completer. Meme remarque sur les fonctions auxiliaires que pour la question 1a *)




(* pour les tests *)



let file1: int t_file =[];;
let file1: int t_file = add_lstf(file1,1);;
let file1: int t_file = add_lstf(file1,2);; 
let file1: int t_file = add_lstf(file1,3);;

let file2: int t_file = [];;
let pile1 : int t_pile= [1 ; 2; 4];;
file2pile(file1);;
file2pile(file2);;
fst(file1);;





