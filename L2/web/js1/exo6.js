function display( message ) {
    console.log(message) ;

}

let tab = [10,200,"Bonjour",40];
display(tab);
tab [0] = 100 ;
display(tab);
display(tab.join());
display(tab[4]);
tab[4] = 7;
display(tab[1]);
display(tab.join());
display(tab);
function computeMax(t){
    let max = t [0];
    for (let i = 1 ; i < t.length; i++){
        if (t[i] > max){
            max = t[i];
        }
    }
    return max;
}
display(computeMax(tab));

function turnLeft(tab) {

    var tab_new = [];
    for (var i = tab.length; i >= 0 ; i--) {
        tab_new[tab.length-i] = tab[i];
        
        }
    return tab_new;
}
display(turnLeft(tab).join());