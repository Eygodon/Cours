/* Voici la fameuse fonction qui renvoie un valeur booléenne et ne
 * réalise aucun test...
 */

function isBetween(a,min,max){
    return ((a >= min) && (a <= max));
}


/* Dans les deux fonctions ci-dessous, l'intérêt est d'utiliser
 * la fonction isBetween */
function isLetter(a){
    return typeof a == "string" && a.length == 1 && (isBetween(a,'A','Z') || isBetween(a,'a','z'));
}


function isDigit(a){
    return typeof a == "number" && isBetween(a,0,9);
}



function getMaximum(a,b,c){
    if ((a > b) && (a > c)){
        return a;
    }
    else if ((b > a) && (b > c)){
        return b;
    }
    else 
        return c;
}


/* Pour trouver l'order, on cherche d'abord le min et le max entre a
 * et b puis on regarde ou se situe c par rapport à ces valeurs */
function getOrder(a,b,c){
    let min;
    let max;
    let s = "";
    
    if (a > b){
        max=a;
        min=b;
    }
    else {
        max=b;
        min=a;
    }
    
    if (c > max){
        s = min + " < " + max + " < " + c;
    }
    else if (c < min){
        s = c + " < " + min + " < " + max;
    }
    else{
        s = min + " < " + c + " < " + max;
    }
    return s;
}


function getMonthName(m){
    let s;
    switch (m){
    case 1 : s = "January"; break;
    case 2 : s = "February"; break;
    case 3 : s = "March"; break;
    case 4 : s = "April"; break;
    case 5 : s = "May";break;
    case 6 : s = "June"; break;
    case 7 : s = "July"; break;
    case 8 : s = "August"; break;
    case 9 : s = "September"; break;
    case 10 : s = "October"; break;
    case 11 : s = "November"; break;
    case 12 : s = "December"; break;
    default : s=""; break;
    }
    return s;
}


function getNumberOfDays(m,b){
    switch (m){
    case 1 :
    case 3 :
    case 5 :
    case 7 :
    case 8 :
    case 10:
    case 12: 
        return 31;
    case 2 : 
        if (b){
            return 29;
        }
        else{
            return 28
        }
    case 4 :
    case 6 :
    case 9 :
    case 11 :
        return 30;
    default: return -1; 
    }
}



function IntegerSum(a,b){
    let s = 0;
    for (let i = a ; i <= b ; i++){
        s = s + i;
    }
    return s;
}



function NumberOfDigits(a){
    let i = 0;
    let div = a;
    while (a >= 1){
        a = a / 10;
        i = i + 1;
    }
    return i;
}


function turnRight(tab){
    let tmp = tab[tab.length-1];
    for (let i = tab.length-1 ; i > 0 ; i--){
        tab[i] = tab[i-1];
    }
    tab[0] = tmp;
}


function turnLeft(tab){
    let tmp = tab[0];
    for (let i = 0; i < tab.length-1 ; i++){
        tab[i] = tab[i+1];
    }
    tab[tab.length-1] = tmp;
}

/* On peut faire plus efficace mais il s'agissait ici de ré-utiliser
 * les fonctions précédentes */
function permute(tab,k){
    if (k > 0){
        for (let i = 0 ; i < k ; i++){
            turnRight(tab);
        }
    }
    else
        for (let i = 0 ; i < -k ; i++){
            turnLeft(tab);
        }
}


function getNavigatorProperties(){
    let s = "";
    for (let prop in navigator){
        s = s + prop + "  : " + navigator[prop] + "\n";
    }
    return s;
}


function getDocumentProperties(){
    let s = "";
    for (let prop in document){
        s = s + prop + "  : " + document[prop] + "\n";
    }
    return s;
}



function getWindowProperties(){
    let s = "";
    for (let prop in window){
        s = s + prop + "  : " + window[prop] + "\n";
    }
    return s;
}

