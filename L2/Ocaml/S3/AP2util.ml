(* listes *)

let len(l) = List.length l;;

let fst(l) =
  match l with
    [] -> failwith "error fst : list is empty"
  | hd::_ -> hd
;;

let rec lst(l) =
  match l with
    [] -> failwith "error lst : list is empty"
    | hd::[] -> hd
    | _::tail -> lst(tail)
;;

let nth(l, k) = 
let rec nth1(l,k) =
  match l with
    []->  failwith "error nth : index must be in [0..len(l)-1]"
  | hd::tail -> if k = 0 then hd else nth1(tail,k-1)
in
if k < 0
then failwith "error  nth : index must be positive"
else nth1(l,k)
;;


let add_fst(l,e) = e::l ;;

let rec add_lst(l,e) =
  match l with
    [] -> [e]
  | hd::tail -> hd::add_lst(tail,e);;

let add_nth(l, e, k) =
let rec add_nth1(l, e, k) =
  match l with
    [] -> [e]
    | hd ::tail -> if k = 0 then e::l else hd::add_nth1(tail, e, k-1)
in 
if k < 0
then failwith "error add_nth : index k must be positive"
else
  if k > len(l)
  then failwith "error add_nth : index must be in [0..len(l)]"
  else add_nth1(l,e,k)
;;

let rem_fst(l) = 
  match l with
  [] -> failwith "error rem_fst : list is empty"
  | _::tail -> tail
;;

let rec rem_lst(l) =
  match l with
  [] -> failwith "error rem_lst : list is empty"
  | [x] -> []
  | x::tail -> x::rem_lst(tail)
 ;;

let rem_nth(l,k) =
let rec rem_nth1(l,k) =
  match l with
  | [] -> failwith "error rem_nth : index must be in [0..len(l)-1]"
  | hd:: tail -> if k = 0 then tail else hd::rem_nth1(tail, k-1)
in
if k < 0 
then failwith "error rem_nth :index k must be positive"
else rem_nth1(l,k)
;;

let concat(l1, l2) = l1 @ l2 ;;


(* tableaux *)

let arr_len(t) = Array.length t ;;

let arr_make(n, v) = Array.make n v ;;

type 'a matrix = 'a array array ;;

let mat_make(n, m, v) : 'a matrix = Array.make_matrix n m v ;;


(* aleatoire *)

let rand_init() = Random.self_init() ;;

let rand_init_expl(n) = Random.init(n) ;;

let rand_int_0(n) = Random.int(n+1) ;;

let rand_int(n, p) = Random.int(p-n + 1) + n ;;



(* lecture controlee d un caractere *)

let read_char() : char =
  let s : string ref = ref "" and fin : bool ref = ref false in
    (
    while not(!fin) 
    do
      s:= read_line() ; 
      if String.length(!s) = 0
      then (print_string("erreur de saisie : vous n'avez saisi aucun caractère") ; print_newline() ;)
      else fin := true;
    done ;
    (!s).[0] ;
    )
;;


(* piles *)

type 'a t_pile = 'a list ;;

let lenp(p : 'a t_pile) : int = len(p) ;;
let fstp(p : 'a t_pile) : 'a = fst(p) ;;
let add_fstp(p, x : 'a t_pile * 'a) : 'a t_pile = add_fst(p, x) ;;
let rem_fstp(p : 'a t_pile) : 'a t_pile = rem_fst(p) ;;


(* files *)

type 'a t_file = 'a list ;;

let lenf(f : 'a t_file) : int = len(f) ;;
let fstf(f : 'a t_file) : 'a = fst(f) ;;
let rem_fstf(f : 'a t_file) : 'a t_file = rem_fst(f) ;;
let add_lstf(f, x : 'a t_file * 'a) : 'a t_file = add_lst(f, x) ;;

(* arbres binaires *)

type 'a t_btree = Bnil | Bnode of 'a * 'a t_btree * 'a t_btree ;;

let bt_empty() = Bnil ;;
let bt_create(x, g, d) = Bnode(x, g, d) ;;
let bt_isempty(a) = (a = Bnil) ;;
let bt_rootval(a) = 
  match a with
    Bnil -> failwith "erreur bt_rootval : arbre vide"
  | Bnode(x, _, _) -> x
;;
let bt_leftst(a) = 
  match a with
    Bnil -> failwith "erreur bt_leftst : arbre vide"
  | Bnode(_, g, _) -> g
;;
let bt_rightst(a) = 
  match a with
    Bnil -> failwith "erreur bt_rightst : arbre vide"
  | Bnode(_, _, d) -> d
;;

let rec bt_nbnode(t : 'a t_btree) : int =
  if bt_isempty(t)
  then 0
  else 1 + bt_nbnode(bt_leftst(t)) + bt_nbnode(bt_rightst(t))
;;
let rec bt_height(t : 'a t_btree) : int =
  if bt_isempty(t)
  then 0
  else 
    let h1 : int = bt_height(bt_leftst(t))
          and h2 : int = bt_height(bt_rightst(t)) in
      if h1 > h2 then 1 + h1 else 1 + h2
;;
let bt_isleaf(t : 'a t_btree) : bool =
  if bt_isempty(t)
  then failwith "erreur bt_isleaf : l'arbre est vide"
  else bt_isempty(bt_leftst(t)) && bt_isempty(bt_rightst(t))
;;
let bt_isinnode(t : 'a t_btree) : bool =
  if bt_isempty(t)
  then failwith "erreur bt_isinnode : l'arbre est vide"
  else not(bt_isleaf(t))
;;
let rec bt_nbleaf(t : 'a t_btree) : int = 
  if bt_isempty(t)
  then 0
  else 
    let c : int = bt_nbleaf(bt_leftst(t)) + bt_nbleaf(bt_rightst(t)) in
       if bt_isleaf(t) 
       then 1 + c
       else c
;;
let rec bt_nbinnode(t : 'a t_btree) : int = 
  if bt_isempty(t)
  then 0
  else 
    let c : int = bt_nbinnode(bt_leftst(t)) + bt_nbinnode(bt_rightst(t)) in
      if bt_isinnode(t) 
      then 1 + c
      else c
;;

(* arbres ternaires *)
type 'a t_ttree = Tnil | Tnode of 'a * 'a t_ttree * 'a t_ttree * 'a t_ttree ;;

let tt_empty() = Tnil ;;
let tt_create(x, g, m, d) = Tnode(x, g, m, d) ;;
let tt_isempty(a) = (a = Tnil) ;;
let tt_rootval(a) = 
  match a with
    Tnil -> failwith "erreur bt_rootval : arbre vide"
  | Tnode(x, _, _, _) -> x
;;
let tt_leftst(a) = 
  match a with
    Tnil -> failwith "erreur bt_leftst : arbre vide"
  | Tnode(_, g, _, _) -> g
;;
let tt_midst(a) = 
  match a with
    Tnil -> failwith "erreur bt_midst : arbre vide"
  | Tnode(_, _, m, _) -> m
;;
let tt_rightst(a) = 
  match a with
    Tnil -> failwith "erreur bt_rightst : arbre vide"
  | Tnode(_, _, _, d) -> d
;;



(* graphique *)
#load "graphics.cma";;

let open_graph(dx, dy : int * int) : unit = 
  let s = ":0 "^string_of_int(dx)^"x"^string_of_int(dy) in
     Graphics.open_graph s ;;

let close_graph() : unit = Graphics.close_graph() ;;

let clear_graph() : unit = Graphics.clear_graph() ;;

let resize_window(x, y) = Graphics.resize_window x y ;;




let moveto(x,y : int * int) : unit = Graphics.moveto x y ;;

let lineto(x, y : int * int) = Graphics.lineto x y ;;

let plot(x, y : int * int) = Graphics.plot x y ;;

let current_point() = Graphics.current_point() ;;

let draw_poly_line(t) = Graphics.draw_poly_line t ;;

let draw_circle(x, y, r : int * int * int) = Graphics.draw_circle x y r ;;

let draw_rect(x,y,dx,dy : int * int * int * int) = Graphics.draw_rect x y dx dy ;;

let fill_rect(x,y,dx,dy : int * int * int * int) = Graphics.fill_rect x y dx dy ;;

let fill_poly(t) = Graphics.fill_poly t ;;

let fill_circle(x, y, r : int * int * int) = Graphics.fill_circle x y r ;;

let set_line_width(e) = Graphics.set_line_width e ;;

let draw_str(s : string) : unit = Graphics.draw_string s ;;



type t_color = Graphics.color ;;


let set_color(color : t_color) = Graphics.set_color color ;;

let black : t_color = Graphics.black ;;
let blue : t_color = Graphics.blue ;;
let red : t_color = Graphics.red ;;
let green : t_color = Graphics.green ;;
let white : t_color = Graphics.white ;;
let yellow : t_color = Graphics.yellow ;;
let cyan : t_color = Graphics.cyan ;;
let magenta : t_color = Graphics.magenta ;;






