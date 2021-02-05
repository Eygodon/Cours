#use "AP2util.ml" ;;
#load "graphics.cma" ;;
#use "graphique.ml" ;;
#use "AP2TP1draw.ml" ;;


(* etude complexite operation fst et lst *)

let init_list(n : int) : int list =
  let l : int list ref = ref [] in
    (
    for k = 1 to n do l := add_fst(!l, 0)  done ;
    !l ;
    )
;;


let chk_fst(n : int) : float array * float array = 
  let ind : float array = arr_make(n+1, 0.0) in
  let tm : float array = arr_make(n + 1, 0.0) in
  let l : int list ref = ref [] in
    (
    for j = 1 to n
    do
      l := init_list(100000 * j) ;
      tm.(j) <- Sys.time() ;
      ignore(fst(!l)) ; 
      tm.(j) <- Sys.time() -. tm.(j);
      ind.(j) <- float_of_int(j) ;
    done ;
    (tm, ind) ;
    )
;;

open_graph(1000, 600) ;;

let rep : t_rep = {orx = 50 ; ory = 50 ; extx = 850 ; exty = 450} ;;

let (v, i) : float array * float array = chk_fst(40) ;;

draw_curve(v, i, 40, rep) ;;

clear_graph() ;;


