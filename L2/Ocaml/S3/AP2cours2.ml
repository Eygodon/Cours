
(* --------------------------------- *)
(* --------------------------------- *)
(* evaluation d'une expression postfixee avec une pile *)

(* representation d'une expression sous forme de suite de caracteres *)

type t_expr = string list ;;

(* fonctions utilitaires vérifiant si un caractere *)
(* est un operateur ou un operande *)

let isoper(c : string) : bool = 
  (c = "+") || (c = "-") || (c = "*") || (c = "/")
;;

let isdigit(c : string) : bool = 
  let len : int = (String.length(c) - 1) in
  let i : int ref = ref 0 and thend : bool ref = ref false 
             and ok : bool ref = ref true in
    (
    while not(!thend)
    do
      if (!i > len)
      then thend := true
      else
        if not(c.[!i] >= '0' && c.[!i] <= '9')
        then (ok := false ; thend := true)
        else i := !i + 1
    done ;
    !ok ;
    )
;;

(* verification du caractere contenu dans une expression *)

let chk_charexpr(c : string) : bool = 
  if isoper(c)
  then true
  else isdigit(c)
;;

(* fonction calculant la valeur entiere d'un operande *)

let valdigit(c : string) : int =
  int_of_string(c) - int_of_string("0")
;;

(* fonction appliquant un operateur a deux entiers *)

let oper(c, v1, v2 : string * int * int) : int = 
  if c = "+"
  then v1 + v2
  else 
    if c = "-"
    then v1 - v2
    else
      if c = "*"
      then v1 * v2
      else
        if v2 = 0
        then failwith "erreur eval_treexpr : division par 0"
        else v1 / v2
;;

let take_2digits(p : string t_pile) : int * int * string t_pile =
  if p = []
  then failwith "erreur take_2digits : pile vide"
  else 
    let (c1, r1) : string * string t_pile = (fstp(p), rem_fstp(p)) in
      if r1 = []
      then failwith "erreur take_2digits : un seul chiffre dans la pile"
      else 
        let (c2, r2) : string * string t_pile = (fstp(r1), rem_fstp(r1)) in
          if not(isdigit(c1) && isdigit(c2))
          then failwith "erreur take_2digits : une des 2 chaines n'est pas un chiffre"
          else (valdigit(c1), valdigit(c2), r2)
;;

let rec eval_expr_aux(e, p : t_expr * string t_pile) : string t_pile = 
  if e = []
  then p
  else 
    let (ce, re) : string * string list = (fst(e), rem_fst(e)) in
      if chk_charexpr(ce)
      then 
        if isoper(ce)
        then 
          let (v1, v2, newp) : int * int * string t_pile = take_2digits(p) in
            eval_expr_aux(re, add_fstp(newp, string_of_int(oper(ce, v1, v2))))
        else eval_expr_aux(re, add_fstp(p, ce))
      else failwith "erreur eval_expr_aux : expression mal formee"
;;


let eval_expr(e : t_expr) : int =
  let p = eval_expr_aux(e, []) in
    if p = []
    then failwith "eval_expr : la pile resultat est vide"
    else 
      let (valp, newp) : string * string list = (fstp(p), rem_fstp(p)) in
        if newp <> []
        then failwith "eval_expr :  expression mal formee"
        else int_of_string(valp)
;;


let e = ["4" ; "6" ; "7" ; "+" ; "9" ; "1" ; "+" ; "*" ; "+"];;

let e1 = ["4" ; "6" ; "7" ; "+" ; "9" ; "1" ; "+" ; "*" ; "+"];;


(* Definition du labyrinthe et de fonctions de manipulation du labyrinthe *)

(* définition d'un noeud : go sert a mémoriser les couloirs qui ont deja ete parcourus, *)
(* avec le code :  '-' signifie aucun couloir, 'l' signifie le couloir de gauche, *)
(* 'm' signifie les couloirs de gauche et du milieu, 'r' signifie les trois couloirs ; *)
(* dleft, dmiddle et dright indiquent les numéros des noeuds atteints par les couloirs *)
(* de gauche, du milieu et de droite ; *)
(* thend indique si le noeud est une sortie du labyrinthe *)
type t_node = {go : char ref ; dleft : int ; dmiddle : int ; dright : int ; thend : bool} ;;

(* l'ensemble des noeuds du labyrinthe est stocké dans un tableau *)
type t_laby = t_node array ;;

(* un exemple de labyrinthe : cf. figure 1. *)
(* Chaque valeur du champ mutable go est initialisée a la valeur '-' *)
(* indiquant qu'aucun couloir n'a ete emprunte jusqu'a maintenent *)
(* depuis le noeud 0, on voit qu'on atteint les noeuds 1, 2 et 3 respectivement par *)
(* le couloir de gauche, le couloir du milieu et le couloir de droite *)
(* il y a un noeud de sortie, qui est le noeud 5 *)
let lab : t_laby = [| 
		{go = ref '-' ; dleft = 1 ; dmiddle = 2 ; dright = 3 ; thend = false} ; 
		{go = ref '-' ; dleft = 0 ; dmiddle = -1 ; dright = -1 ; thend = false} ; 
		{go = ref '-' ; dleft = 1 ; dmiddle = 4 ; dright = 3 ; thend = false} ; 
		{go = ref '-' ; dleft = 2 ; dmiddle = 1 ; dright = 5 ; thend = false} ; 
		{go = ref '-' ; dleft = -1 ; dmiddle = -1 ; dright = -1 ; thend = false} ; 
		{go = ref '-' ; dleft = 3 ; dmiddle = 1 ; dright = -1 ; thend = true} ; 
|] ;;

(* retourne le noeud d'entree du labyrinthe *)
let lab_entrance(lab : t_laby) : int =
  0 
;;

(*indique si le noeud est un cul-de-sac *)
let lab_dead_end(node : int) : bool =
  node = -1
;;

(* indique si le noeud est une sortie du labyrinthe *)
let lab_exit(lab, node : t_laby * int) : bool =
  lab.(node).thend
;;

(* les paramètres node et go indiquent qu'on souhaite visiter le noeud *)
(* et que l'on est deja sorti du noeud avec le couloir go *)
(* voire que l'on n'a pas visite le noeud si go = '-' *)
(* la fonction verifie que c'est coherent avec la marque eventuellement laissee *)
(* lors d'un precedent passage dans le noeud *)
let lab_soon_visited_node(lab, node, go : t_laby * int * char) : bool =
  (go <> !(lab.(node).go))
;;

(* indique si toutes les issues d'un noeud ont ete visitees *)
let node_all_visited_passage(go : char) : bool =
  go = 'r'
;;

(* permet de marquer un noeud en indiquant les issues qui ont ete visitees *)
let lab_mark_node(lab, node, go : t_laby * int * char) : unit =
  lab.(node).go := go
;;

(* Definition des types utilises par le visiteur *)
(* un type permettant de representer un couple (noeud, couloir) *)
type t_visit = int * char ;;

(* la pile permettant de mémoriser la partie utile du parcours du visiteur *)
type t_visitpile = t_visit t_pile ;;

(* les paramètres node et go indiquent qu'on visite le noeud node *)
(* et que l'on est deja sorti du noeud avec le couloir go *)
(* voire que l'on n'a pas visite le noeud si go = '-' *)
(* la fonction retourne le prochain noeud a visiter ainsi que *)
(* le couloir emprunté a partir de node pour atteindre ce prochain noeud *)
let follow(lab, node, go : t_laby * int * char) : t_visit = 
  if go = '-'
  then (lab.(node).dleft, 'l')
  else
    if go = 'l'
    then (lab.(node).dmiddle, 'm')
    else (lab.(node).dright, 'r')
;;

(* Definition des fonctions permettant l'exploration du labyrinthe *)

(* fonction de visite du labyrinthe *)
let rec visitlab_aux(lab, p : t_laby * t_visitpile) : int =
  if p = []  (* il n'y a plus rien a visiter *)
  then failwith "erreur visitlab_aux ; la pile de visite est vide ; 
                                       le labyrinthe a t'il une sortie atteignable ?"
  else
    let ((node, go), rp) : t_visit * t_visitpile = (fstp(p), rem_fstp(p)) in
      if lab_dead_end(node) (* le noeud courant est un cul-de-sac *)
      then visitlab_aux(lab, rp) (* on retourne au noeud precedent *)
      else
        if lab_exit(lab, node) (* une sortie a ete trouvee *)
        then node
        else
          if lab_soon_visited_node(lab, node, go) || node_all_visited_passage(go) 
          (* le noeud courant a deja ete visite anterieurement *)
          (* via un autre chemin : on a fait une boucle dans le labyrinthe, *)
          (* ou alors on a explore toutes les issues du noeud *)
          then visitlab_aux(lab, rp) (* on retourne au noeud precedent *)
          else 
          (* on recherche le prochain couloir a suivre *)
          (* et le noeud que l'on atteint  par ce couloir *)
            let (newnode, newgo) : t_visit = follow(lab, node, go) in
              (
              lab_mark_node(lab, node, newgo) ; 
              (* on marque le noeud courant pour se souvenir du couloir emprunte *)
              (* et on poursuit en visitant le prochain noeud *)
              visitlab_aux(lab, add_fstp(add_fstp(rp, (node, newgo)), (newnode, '-')))
              )
;;

(* fonction principale : appel de la fonction de visite a partir de l'entree du labyrinthe *)
(* en indiquant qu'aucune issue n'a ete visitee *)

let visitlab(lab : t_laby) : int = 
  visitlab_aux(lab, add_fstp([], (lab_entrance(lab), '-')))
;;

(* un autre labyrinthe pour les tests *)
(* n'hesitez pas a modifier les destinations des couloirs *)
let labbis : t_laby = [| 
		{go = ref '-' ; dleft = 1 ; dmiddle = 3 ; dright = 4 ; thend = false} ; 
		{go = ref '-' ; dleft = 2 ; dmiddle = 2 ; dright = 6 ; thend = false} ; 
		{go = ref '-' ; dleft = -1 ; dmiddle = -1 ; dright = -1 ; thend = false} ; 
		{go = ref '-' ; dleft = 6 ; dmiddle = 9 ; dright = 7 ; thend = false} ; 
		{go = ref '-' ; dleft = 7 ; dmiddle = 8 ; dright = 5 ; thend = false} ; 
		{go = ref '-' ; dleft = -1 ; dmiddle = -1 ; dright = -1 ; thend = false} ; 
		{go = ref '-' ; dleft = 13 ; dmiddle = 14 ; dright = 9 ; thend = false} ; 
		{go = ref '-' ; dleft = 9 ; dmiddle = 10 ; dright = 11 ; thend = false} ; 
		{go = ref '-' ; dleft = 11 ; dmiddle = 14 ; dright = 5 ; thend = false} ; 
		{go = ref '-' ; dleft = 12 ; dmiddle = 14 ; dright = 10 ; thend = false} ; 
		{go = ref '-' ; dleft = -1 ; dmiddle = -1 ; dright = -1 ; thend = false} ; 
		{go = ref '-' ; dleft = -1 ; dmiddle = -1 ; dright = -1 ; thend = false} ; 
		{go = ref '-' ; dleft = -1 ; dmiddle = -1 ; dright= -1 ; thend = false} ; 
		{go = ref '-' ; dleft = -1 ; dmiddle = -1 ; dright = -1 ; thend = false} ; 
		{go = ref '-' ; dleft = -1 ; dmiddle = -1 ; dright = -1 ; thend = true} ;
|] ;;


(*----------------------------------------------------------------------------------*)

(* type pour représenter une file d'attente *)
type t_myfile = int t_file ;; 

(*type pour représenter (le temps necessaire pour traiter) *)
(* un client au guichet et une file d'attente *)
type t_mywork = int * t_myfile ;;
(* NB. pas de valeur nulle dans la file *)

(* fonction permettant d'ajouter un nouveau client a une file d'attente *)
(* 60 pour 100 de chance qu'il n'y ait personne, 10 pour cent pour travail de duree 1 *)
(* 10 pour cent pour travail de duree 2, 10 pour cent pour travail de duree 3 *)
(* 10 pour cent pour travail de duree 4 *)

let add_work(mf : t_myfile) : t_myfile = 
  let x : int = rand_int(0, 9) in
    if x <= 5
    then mf
    else add_lstf(mf, x - 5)
;;

(* etat initial du travail : personne au guichet, file d'attente vide *)
let init_mywork():  t_mywork = 
  (0, [])
;;

(* travail durant une minute *)
(* s'il n'y a personne au guichet, il y a transfert du premier client *)
(* de la file au guichet, s'il existe ; *)
(* s'il y a quelqu'un au guichet, le temps necessaire pour le traiter *)
(* diminue d'une unite durant cette minute *)
let rec work((mw, mf) : t_mywork) : t_mywork = 
  if mw = 0
  then
    if mf = []
      then (mw, mf)
      else (fstf(mf), rem_fstf(mf))
    else
      (mw - 1, mf)
;;

(* si le temps de simulation est ecoule, le resultat de la fonction *)
(* est l'etat courant (client au guichet, file d'attente) *)
(* sinon on simule le travail d'une minute, et on recommence avec une minute de moins, *)
(* sans oublier d'ajouter l'eventuel nouveau client qui arrive a ce moment *)
let rec simulmw_aux(nb, (mw, mf) : int * t_mywork) : t_mywork = 
  if nb = 0
  then (mw, mf)
  else 
    let newconfig : t_mywork = work((mw, add_work(mf))) in
      simulmw_aux(nb - 1, newconfig)
;;

(* initialisation et appel de la fonction auxiliaire realisant la simulation du travail *)
let simulmw(nb : int) : t_mywork =
  simulmw_aux(nb, init_mywork())
;;
