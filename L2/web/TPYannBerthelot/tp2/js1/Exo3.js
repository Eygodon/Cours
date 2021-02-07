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
    return (min < a < max)
}
console.log(isBetween(5,1,4));
console.log(isBetween(3,1,4));
display(isBetween('e','a','z'));