let unentier = 3 ;
console.log(unentier);
console.log(typeof unentier);
let a =42  ;
console.log(a);
console.log(typeof a);
// a est non défini ni en type ni en valeur sans init
// a vaut 42 et est un nombre
let b = 24;
console.log(b);
console.log(typeof (b));
a = a + b;
b = a - b;
a = a - b ;
console.log(a);
console.log(b);
let c = a+b;
console.log(c);
console.log(typeof (c));
c = a - b ;
console.log(c);
console.log(typeof (c));
let s1 ="Bonjour ";
console.log(s1);
console.log(typeof (s1));
// string
let s2 = " Yann";
let s3 = s1 + s2 ;
console.log(s3);
console.log(typeof s3);
//string
let s4 = s1 - s2;
console.log(s4);
//NaN non connue, erreur
console.log(typeof s4);
//nombre
let car1 = 'a';
console.log(typeof car1);
//string
let d0 = new Date (1955,5,8);
console.log(d0.toString());
console.log(typeof d0);
//Un mercredi bien évidemment , oui c'estr bon, l'année, le mois le jour,
let d1 = new Date(1999,6, 12);
console.log(d1.toString());
let d2 = new Date();
function display( message ) {
    console.log(message) ;

}
display(d1+d2);
//on affiche juste deux dates côtes à côtes
display((d1+d2+5));
// les dates sont des objets et s'affichent donc juste entre elles en s'affichant côtes à côtes. Le nombre est un type différent et ne peux pas s'addtioner à un type différent
