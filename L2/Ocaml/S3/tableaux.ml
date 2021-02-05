#use "fonction4.ml";;
type t_point =
  {
    x : float ;
    y : float
  }
;;

type t_pointarr =
  {
    len : int ;
    arr : t_point array
  }
;;

type t_Bsegm =
  {
    mat : t_point matrix ;
    d : int
  }
;;
let make_Bsegm (t : t_pointarr) : t_Bsegm =
  let matr : t_point matrix = mat_make(2, (t.len), {x = 0. ; y = 0. })in
  for i = 0 to (t.len-1)
  do
    (
      matr.(0).(i) <- t.arr.(i)
    )
  done;
  {mat = matr ; d = t.len - 1}
  ;;
  
  let plot_controlpointsegm(s : t_Bsegm) : unit =
    for i = 0 to s.d
    do (
      open_graph(10,10);
      draw_circle(int_of_float(s.mat.(0).(i).x),int_of_float( s.mat.(0).(i).y), 3)
    )
    done;
  ;;
  let( a, b, c) : t_point * t_point * t_point = {x = 1. ; y = 2.} , {x = 5. ; y = 7.}, {x = 3. ; y = 4.} ;;
  
  let point_arr_test :t_pointarr = { len = 3 ;
                                     arr = [|a ; b ;  c |]
                                   }
                                 
  ;;
  
  let bsegm : t_Bsegm = make_Bsegm(point_arr_test);;

  plot_controlpointsegm(bsegm);;
  clear_graph();;

  let mp_computeBsegmpoint ( s, u : t_Bsegm * float ) =
    for i = 0 to (s.d)
    do
      (
        s.mat.(1).(i) <- s.mat.(0).(i)
      )
    done;
    for i = s.d downto 0
    do
      (
        
        for j = 0 to i-1
        do
          (
            s.mat.
    
