let image_status = 0;
function switchImage(){
    let o1 = document.images[0];
    let o2 = document.images[1];
    if (image_status === 0){
        o1.style.display = 'none';
        o2.style.display = 'inline';
        image_status = 1;
    }
    else if (image_status === 1) {
        o2.style.display = 'none';
        o1.style.display = 'inline';
        image_status = 0;
    }
}

function setValue(id,val){
    document.getElementById(id).value = val;
}

function isCorrectAnswer(){
    let val1 = parseInt(document.getElementById("op1").value);
    let val2 = parseInt(document.getElementById("op2").value);
    let val3 = parseInt(document.getElementById("op3").value);
    let result = parseInt(document.getElementById("result").innerText);
    if ((val1 * val2) + val3 === result || (val1 * val2) - val3 === result){
        return true
    }
    else {
        return false
    }
}

function checkTrio(){
    if (isCorrectAnswer()){
        alert("You win !")
    }
    else {
        alert("You made some mistake")
    }
}

function replayTrio(){
    document.getElementById("op1").value = 0;
    document.getElementById("op2").value = 0;
    document.getElementById("op3").value = 0;
    giveANewChance();
}

function validateTrio(){
    if (isCorrectAnswer()) {
        let val1 = document.getElementById("op1").value;
        let val2 = document.getElementById("op2").value;
        let val3 = document.getElementById("op3").value;
        let div = document.getElementById("solution");
        let span = document.createElement("span");
        span.appendChild(document.createTextNode(val1 + " ; " + val2 + " ; " + val3));
        div.appendChild(span);
        div.appendChild(document.createElement("br"));
        replayTrio();
    }
}
