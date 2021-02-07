/*
* Petit Quizz sur 10 inputs
*/


// fonction pour alléger le code et nous faire gagner un peu de temps
function doc_id(id){
    return document.getElementById(id);
}

// Une autre fonction pour alléger le code et nous faire gagner du temps
function is_checked(id) {
    return doc_id(id).checked
}

// Fonction qui corrige le quizz. Vérifie chaque inputs, en comptant les points
// Puis ajoute le score en bas de l'écran ou l'actuallise
function correct_quizz() {
    let count = 0;


    // ------------------ NOM TEST      ------------------ \\
    if (doc_id("id_nom").value === "Kjellberg"){
        count += 1;
    }


    // ------------------ PRENOM TEST   ------------------ \\
    if (doc_id("id_prenom").value === "Felix"){
        count += 1;
    }


    // ------------------ PRENOM TEST   ------------------ \\
    if (doc_id("id_male").checked){
        count += 1;
    }


    // ------------------ DATE TEST   ------------------ \\
    if (doc_id("id_date").value === "2010-04-29"){
        count += 1;
    }


    // ------------------ AGE TEST   ------------------ \\
    if (doc_id("id_age").value === "29" || doc_id("id_age").value === "9"){
        count += 1;
    }


    // ------------------ COUNTRY TEST ------------------ \\
    if (doc_id("id_from").value === "sweden"){
        count += 1;
    }


    // ------------------ FIANCE TEST   ------------------ \\
    if (doc_id("id_fiance").value === "Marzia"){
        count += 1;
    }


    // ------------------ OPPONENT TEST ------------------ \\
    if (doc_id("id_opponent").value === "T-Series"){

        count += 1;
    }


    // ------------------ HOST TEST     ------------------ \\

    if (is_checked("box_pewdiepie") && is_checked("box_mrbeast") && is_checked("box_roland") && is_checked("box_benshapiro") && is_checked("box_elonmusk") && is_checked("box_blueshirtkid")){
        count += 1;
    }


    // ------------------ OPPONENT TEST ------------------ \\
    if (doc_id("id_pewnews").value === "Gloria Borger" || doc_id("id_pewnews").value === "Poppy Harlow"){
        count += 1;
    }


    // ------------------ RESULT H1 EXIST ?   ------------------ \\
    if (document.getElementById("result_text") === null){
        let str = "You got " + count + " points out of 10 !";
        let par = document.createElement("H1");
        let doc = document.createTextNode(str);
        par.appendChild(doc);
        par.id = "result_text";
        document.getElementById("result").appendChild(par);
    }
    else {
        document.getElementById("result_text").innerText = "You got " + count + " points out of 10 !";
    }
    console.log(count);
}

