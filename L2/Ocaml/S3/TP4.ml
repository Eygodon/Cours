#use "AP2util.ml";;
#use "AP2TP1draw.ml";;
#use "graphique.ml";;


type t_point = {
    x : float;
    y : float
  };;

type t_pointarr = {
    tab : t_point array;
    len : int
  };;

type t_Bseg = {
    mat : t_point matrix;
    deg : int
  };;

let make_Bseg(t : t_pointarr) : t_Bseg =
  let mat : t_point matrix = mat_make(2, t.len, {x = 0.; y = 0.}) in
  for i = 0 to t.len - 1
  do
    mat.(0).(i) <- t.tab.(i);
  done;
  {
    mat = mat;
    deg = t.len - 1
  }
;;

let tab : t_pointarr = {
    tab = [|{x = 100.; y = 50.} ; {x = 400.; y = 100.} ; {x = 150.; y = 150.} ; {x = 450.; y = 200.}|];
    len = 4
  };;


let seg : t_Bseg = make_Bseg(tab);;

let plot_controlpointseg(s : t_Bseg) : unit =
  open_graph(500, 500);
  clear_graph();
  for i = 0 to s.deg
  do
    fill_circle(int_of_float(s.mat.(0).(i).x), int_of_float(s.mat.(0).(i).y), 3);
  done
;;

plot_controlpointseg(seg);;

let cpy_line(s : t_Bseg) : unit =
  for i = 0 to s.deg
  do
    s.mat.(1).(i) <- s.mat.(0).(i);
  done
;;


let mp_computeBsegpoint(s, u : t_Bseg * float) : unit =
  cpy_line(s);
  let xj : float ref = ref 0. and
      yj : float ref = ref 0. in
  for i = 1 to s.deg
  do
    for j = 0 to s.deg - i
    do
      xj := (u *. s.mat.(1).(j).x) +. ((1. -. u) *. s.mat.(1).(j+1).x);
      yj := (u *. s.mat.(1).(j).y) +. ((1. -. u) *. s.mat.(1).(j+1).y);
      s.mat.(1).(j) <- {x = !xj; y = !yj}; 
    done;
  done;;

mp_computeBsegpoint(seg, 1.);;
seg;;

let mp_computeBseg(s, n : t_Bseg * int) : t_pointarr =
  let arrPoint : t_pointarr = {tab = arr_make(n + 1, {x = 0.; y = 0.}); len = n + 1} in
  for i = 0 to n
  do
    mp_computeBsegpoint(s, float_of_int(i) /. float_of_int(n));
    arrPoint.tab.(i) <- s.mat.(1).(0)
  done;
  arrPoint;;

let arr : t_pointarr = mp_computeBseg(seg, 100);;

let draw_Bseg(c : t_pointarr) : unit =
  for i = 0 to c.len - 2
  do
    moveto(int_of_float(c.tab.(i).x), int_of_float(c.tab.(i).y));
    lineto(int_of_float(c.tab.(i+1).x), int_of_float(c.tab.(i+1).y));
  done;;

draw_Bseg(arr);;
