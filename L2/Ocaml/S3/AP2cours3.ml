(* --------------------------------- *)
(* --------------------------------- *)
(* fonctions de base *)
let rec bt_nbnode(t : 'a t_btree) : int =
  if bt_isempty(t)
  then 0
  else 1 + bt_nbnode(bt_leftst(t)) + bt_nbnode(bt_rightst(t))
;;

let max2int(x, y : int * int) : int =
  if x > y
  then x
  else y
;;
let rec bt_height(t : 'a t_btree) : int =
  if bt_isempty(t)
  then 0
  else 1 + max2int(bt_height(bt_leftst(t)), bt_height(bt_rightst(t)))
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
    if bt_isleaf(t)
    then 1
    else bt_nbleaf(bt_leftst(t)) + bt_nbleaf(bt_rightst(t))
;;
let rec bt_nbinnode(t : 'a t_btree) : int = 
  if bt_isempty(t)
  then 0
  else 
    if bt_isleaf(t)
    then 0
    else 1 + bt_nbinnode(bt_leftst(t)) + bt_nbinnode(bt_rightst(t))
;;


(* manipulation d'arbres d'expressions *)
(* representation d'une expression sous forme d'arbre d'expression *)

type t_treexpr = char t_btree ;;

(* definition de t1, correspondant a l'expression *)
(* 4 + ((6 + 7) * (9 + 1)) *)

let t1 : t_treexpr = Bnode ('+', Bnode ('4', Bnil, Bnil),
   Bnode ('*', Bnode ('+', Bnode ('6', Bnil, Bnil), Bnode ('7', Bnil, Bnil)),
    Bnode ('+', Bnode ('9', Bnil, Bnil), Bnode ('1', Bnil, Bnil)))) ;;

(* --------------------------------- *)
(* --------------------------------- *)
(* Evaluation d'un arbre d'expression *)

(* fonctions utilitaires vérifiant si un caractere est un operateur *)
(* ou un operande, et si un noeud est bien forme *)

let isoper(c : char) : bool = 
  (c = '+') || (c = '-') || (c = '*') || (c = '/')
;;

let isdigit(c : char) : bool = 
  ('0' <= c) && (c <= '9')
;;

(* verification des valeurs d'un noeud d'un arbre d'expression *)

let chk_nodexpr(c, l, r : char * t_treexpr * t_treexpr) : bool = 
  if isdigit(c)
  then bt_isempty(l) && bt_isempty(r)
  else
    if isoper(c)
    then not(bt_isempty(l)) && not(bt_isempty(r))
    else false
;;

(* fonction calculant la valeur entiere d'un operande *)

let valdigit(c : char) : int =
  int_of_char(c) - int_of_char('0')
;;

(* fonction appliquant un operateur a deux entiers *)

let oper(c, v1, v2 : char * int * int) : int = 
  if c = '+'
  then v1 + v2
  else 
    if c = '-'
    then v1 - v2
    else
      if c = '*'
      then v1 * v2
      else
        if v2 = 0
        then failwith "erreur eval_treexpr : division par 0"
        else v1 / v2
;;

(* fonction evaluant une expression, tout en verifiant la *)
(* correction de l'expression *)

let rec eval_treexpr(t : t_treexpr) : int = 
  if bt_isempty(t)
  then failwith "erreur eval_treexpr : arbre vide"
  else
    let (c, l, r) : char * t_treexpr * t_treexpr = 
    		(bt_rootval(t), bt_leftst(t), bt_rightst(t)) in
      if chk_nodexpr(c, l, r)
      then
        if isoper(c)
        then 
          let v1 : int = eval_treexpr(l) in
          let v2 : int = eval_treexpr(r) in
            oper(c, v1, v2)
        else  valdigit(c)
      else failwith "erreur eval_treexpr : arbre mal forme"
;;

(* --------------------------------- *)
(* --------------------------------- *)
(* conversion d'un arbre d'expression en expression prefixee *)

(* representation d'une expression sous forme de suite de caracteres *)

type t_expr = char list ;;

(* calcul d'une expression préfixée correspondant a un arbre d'expression *)

let rec comp_prefexpr(t : t_treexpr) : t_expr = 
  if bt_isempty(t)
  then failwith "erreur comp_prefexpr : arbre vide"
  else 
    let (c, lst, rst) : char * t_treexpr * t_treexpr = 
    		(bt_rootval(t), bt_leftst(t), bt_rightst(t)) in
      if chk_nodexpr(c, lst, rst)
      then
        if isoper(c)
        then
          let e1 : t_expr = comp_prefexpr(lst) in
          let e2 : t_expr = comp_prefexpr(rst) in
            concat(add_fst(e1, c), e2)
        else [c]
      else failwith "erreur comp_prefexpr : arbre mal forme"
;;

(*variante  de comp_prefexpr pour eviter concat *)

let rec comp_prefexpr_aux(t, l : t_treexpr * t_expr) : t_expr = 
  if bt_isempty(t)
  then failwith "erreur comp_prefexpr : arbre vide"
  else 
    let (c, lst, rst) : char * t_treexpr * t_treexpr = 
    		(bt_rootval(t), bt_leftst(t), bt_rightst(t)) in
      if chk_nodexpr(c, lst, rst)
      then
        if isoper(c)
        then
          let e1 : t_expr = comp_prefexpr_aux(lst, add_lst(l, c)) in
            comp_prefexpr_aux(rst, e1)
        else add_lst(l, c)
      else failwith "erreur comp_prefexpr : arbre mal forme"
;;

let comp_prefexpr(t : t_treexpr) : t_expr = 
  comp_prefexpr_aux(t, [])
;;


(* --------------------------------- *)
(* --------------------------------- *)
(* calcul d'un arbre d'expression a partir d'une expression prefixee *)

let rec exprtree_create_aux(e : t_expr) : t_treexpr * t_expr =
  if e = []
  then failwith "erreur exprtree_create_aux : l'expression est vide"
  else
    let (c, e_rem) : char * t_expr = (fst(e), rem_fst(e)) in
      if not(isoper(c) || isdigit(c))
      then failwith "erreur exprtree_create_aux : un caractere n'est pas correct"
      else
        if isoper(c)
        then 
          let (t1, e1) : t_treexpr * t_expr = exprtree_create_aux(e_rem) in
          let (t2, e2) : t_treexpr * t_expr = exprtree_create_aux(e1) in
            (bt_create(c, t1, t2), e2)
        else
          (bt_create(c, bt_empty(), bt_empty()), e_rem)
;;

let exprtree_create(e : t_expr) : t_treexpr = 
  let (t, rem_expr) : t_treexpr * t_expr = exprtree_create_aux(e) in
    if not(rem_expr = [])
    then failwith "erreur exprtree_create : expression mal formee"
    else t
;;


(* --------------------------------- *)
(* --------------------------------- *)
 (* calcul d'une expression parenthesee correspondant a un arbre d'expression *)

 let rec comp_expr(t : t_treexpr) : t_expr = 
  if bt_isempty(t)
  then failwith "erreur comp_expr : arbre vide"
  else
    let (c, lst, rst) : char * t_treexpr * t_treexpr = 
    		(bt_rootval(t), bt_leftst(t), bt_rightst(t)) in
      if chk_nodexpr(c, lst, rst)
      then
        if isoper(c)
        then 
          let e1 : t_expr = comp_expr(lst) in
          let e2 : t_expr = comp_expr(rst) in
            concat(add_fst(add_lst(e1, c), '('), add_lst(e2, ')'))
        else  [c]
      else failwith "erreur comp_expr : arbre mal forme"
;;

(* variante pour éviter la fonction concat *)

let rec comp_expr_aux(t, l: t_treexpr * t_expr) : t_expr = 
  if bt_isempty(t)
  then failwith "erreur comp_expr : arbre vide"
  else
    let (c, lst, rst) : char * t_treexpr * t_treexpr = 
    		(bt_rootval(t), bt_leftst(t), bt_rightst(t)) in
      if chk_nodexpr(c, lst, rst)
      then
        if isoper(c)
        then 
          let e1 : t_expr = add_lst(comp_expr_aux(lst, add_lst(l, '(')), c) in
            add_lst(comp_expr_aux(rst, e1), ')')
        else  add_lst(l, c)
      else failwith "erreur comp_expr : arbre mal forme"
;;

let comp_expr(t : t_treexpr) : t_expr = 
  comp_expr_aux(t, [])
;;


(* --------------------------------- *)
(* --------------------------------- *)
(* --------------------------------- *)
(* --------------------------------- *)
(* manipulation d'arbres binaires geometriques *)

(* definition des types : point, arbre *)

type t_point = float * float ;;

type t_tree = t_point t_btree ;;


(* --------------------------------- *)
(* --------------------------------- *)
(* dessin d'un arbre geometrique *)

(* conversion d'un point "flottant" en point "entier" *)

let point_floatoint((x, y) : t_point) : int * int = 
  (int_of_float(x), int_of_float(y))
;;

(* dessin d'un arbre *)

let rec draw_tree_aux(t : t_tree) : unit = 
  if not(bt_isempty(t))
  then
    let (p, lst, rst) : t_point * t_tree * t_tree =
    		 (bt_rootval(t), bt_leftst(t), bt_rightst(t)) in
      (
      lineto(point_floatoint(p)) ;
      draw_tree_aux(lst) ; 
      moveto(point_floatoint(p)) ;
      draw_tree_aux(rst) ;
      )
;;

let draw_tree(t : t_tree) : unit =
  if not(bt_isempty(t))
  then 
    (
    moveto(point_floatoint(bt_rootval(t))) ;
    draw_tree_aux(t)
    )
;;

(* --------------------------------- *)
(* --------------------------------- *)
(* calcul d'un arbre geometrique *)

(* definition du type pour representer les parametres d'un arbre *)

type t_paramtree = {anglinit : float ; size : float ; ratio : float ; angle : float} ;;

let pi : float = 3.141592653589793 ;;

(* calcul d'un point a partir d'un point origine, d'une taille et d'un angle *)

let comp_newpoint((orx, ory), size, angle : t_point * float * float) : t_point =
  (orx +. size *. cos(angle), ory +. size *. sin(angle))
;;

(* calcul d'un arbre *)

let rec comp_tree(p, par, depth : t_point * t_paramtree * int) : t_tree = 
  if depth = 0
  then bt_create(p, bt_empty(), bt_empty())
  else 
    let anglelst : float = (par.anglinit +. par.angle) and 
    		anglerst : float = (par.anglinit -. par.angle) in
    let pleft : t_point = comp_newpoint(p, par.size, anglelst) 
                 and pright : t_point = comp_newpoint(p, par.size, anglerst) in
    let sizebis : float = par.ratio *. par.size in
    let parlst = {anglinit = anglelst ; size = sizebis ; 
    		ratio = par.ratio ; angle = par.angle} and
    			parrst = {anglinit = anglerst ; size = sizebis ; 
				ratio = par.ratio ; angle = par.angle} in
    let lst : t_tree = comp_tree(pleft, parlst, depth - 1) 
                 and rst : t_tree = comp_tree(pright, parrst, depth - 1) in
      bt_create(p, lst, rst)
;;

(* variante pour avoir un tronc *)

let comp_tree_trunk(p, par, depth : t_point * t_paramtree * int) : t_tree = 
  let par1 : t_paramtree = {anglinit = par.anglinit ; 
  		size = par.size *. par. ratio ; ratio = par.ratio ; angle = par.angle} in
  bt_create(p, comp_tree(comp_newpoint(p, par.size, par.anglinit), par1, depth), bt_empty())
;;


