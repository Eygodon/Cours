let len(l) = List.length l;;

let fst(l) =
  match l with
    [] -> failwith "error empty list"
  | hd::tail -> hd
;;

let rec lst(l) =
  match l with
    [] -> failwith "error empty list"
  | hd::[] -> hd
  | hd::tail -> lst(tail)
;;

let rec nth(l,k) =
  match (l,k) with
    ([],_) -> failwith "error list is too short"
  | (hd::tail,0) -> hd
  | (hd::tail,k) -> if (k<0) then failwith "error index must be positive"
                    else nth(tail,k-1)
;;
   
let rec add_nth(l,e,k) =
  match (l,k) with
    (_,0) -> e::l
  | ([],_) -> failwith "error index must be in [0..len(l)-1]"
  | (hd::tail,k) -> hd::add_nth(tail,e,k-1)
;;
let add_fst(l,e) = add_nth(l,e,0) ;;
let add_lst(l,e) = add_nth(l,e,len(l)) ;;

let rec rem_nth(l,k) =
  match (l,k) with
    ([],_) -> failwith "error index must be in [0..len(l)-1]"
  | (hd::tail,0) -> tail
  | (hd::tail,k) -> hd::rem_nth(tail,k-1)
;;
let rem_fst(l) = rem_nth(l,0) ;;
let rem_lst(l) = rem_nth(l,len(l)-1) ;;



type t_day = MONDAY | TUESDAY | WEDNESDAY | THURSDAY | FRIDAY | SATURDAY | SUNDAY;;
let next_day (day : t_day) : t_day =
  if day = MONDAY
  then TUESDAY
  else (
    if day = TUESDAY
    then WEDNESDAY
    else (
      if day = WEDNESDAY
      then THURSDAY
      else (
        if day = THURSDAY
        then FRIDAY
        else (
          if day = FRIDAY
          then SATURDAY
          else (
            if day = SATURDAY
            then SUNDAY
            else (
              if day = SUNDAY
              then MONDAY
              else failwith("FUCK O C A M L")
            )
          )
        )
      )
    )
  )
;;

let x = THURSDAY;;
next_day(x);;

(* Q U E S T I O N 2 *)

type t_color = SPIKE | HEART | DIAMOND | CLUB;;

type t_card ={
    color : t_color;
    number : int;
  }
;;

let create_card ( color, number : t_color * int ) : t_card =
  {color = color; number = number}
;;
create_card(SPIKE,10);;

let same_value_card(card1, card2 : t_card * t_card ) : bool =
  if card1.number = card2.number
  then true
  else false
;;


let rec create_card_color ()

;;



make_deck();;                                
list_card;;




(* conception des joueurs*)(* int c'est bien parce qu'on peut les additioner et string c'est bien par
ce que pas de commentaires à faire , genre c'est explicite*)
(* question 9 un t_card list ça a l'air cool *)
(* même réponse avec le cimetière*)
(*question 11*)
