function display( message ) {
    console.log(message) ;

}

function computeSyracuse(init , k){
    let u = init;
    for (i = 1 ; i <= k; i++){
        if (u % 2 === 0 ){
            u = u / 2 ;
        }
        else{
            u = 3 * u + 1;
        }
    }
    return u;
}
display(computeSyracuse(100,16));
function computeSyracuseFlight(init) {
    let u = init;
    let cpt = 0;
    while (u > 1){
        if (u % 2 === 0){
            u = u / 2;
        }
        else {
            u = 3 * u + 1;
        }
        cpt = cpt + 1;
    }
    return cpt;
}

display(computeSyracuseFlight(10));

function getNumberOfDigit(a) {
    let s = a;
    let u = 0;
    while (s >= 1){
        s = s / 10 ;
        u = u + 1;
    }
    return u;
}
display(getNumberOfDigit(10));

function integerSum(a,b) {
    let r = a;
    for (  i = a ; i < b ; i++){
        r =  r + (i + 1);
    }
    return r
}
display(integerSum(1,6));

