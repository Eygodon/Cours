function display( message ) {
    console.log(message) ;

}
function isGreaterThan2(a) {
    return (a > 2)
}

console.log(isGreaterThan2(3));
console.log(isGreaterThan2(1));
console.log(isGreaterThan2(2.5));

function isBeginningWithUpperCase(valeur) {
    return (valeur>= 'A') && (valeur <= 'Z');
}
console.log(isBeginningWithUpperCase('E'));
console.log(isBeginningWithUpperCase('a'));
console.log(isBeginningWithUpperCase(3));
//vrai
console.log(isBeginningWithUpperCase("Bonjour"));

function isUppercase(lettre) {
    return (typeof lettre == "string")
    && (lettre.length == 1 )
    && (lettre >= 'A')
    && (lettre <= 'Z')
}
console.log(isUppercase('E'));
console.log(isUppercase('albert'));
console.log(isUppercase(33));

function isBetween(a,min,max) {
    return (min < a )
        && (a < max)
        && (min < max)
}
console.log(isBetween(5,1,4));
console.log(isBetween(3,1,4));
console.log(isBetween('e','a','z'));

function isLetter(a) {
    return isBetween(a,"A","z")
    && (typeof a == "string")
    && (a.length == 1)
}
display(isLetter("a"));
display(isLetter("ab"));
function isDigit(a){
    return isBetween(a,0,9)
    && (typeof a == "number")
}
display(isDigit(3));
display(isDigit(45));
display(isDigit("3"));
display(isDigit("34"));
function isAlphaNumeric(a) {
    return (isLetter(a))
    || (isDigit(a))
}
display(isAlphaNumeric("v"));

function isLeapyear(year) {
    return ((year % 4 == 0) && (year % 100 !=0))
    || ( year % 400 ==0)
}
display(isLeapyear(2016));

function belongsToRectangle(x,y,a1,b1,a2,b2) {
    return (isBetween(x,a1,a2))
    && (isBetween(y,b1,b2))

}
display(belongsToRectangle(2,3,0,0,5,5));
