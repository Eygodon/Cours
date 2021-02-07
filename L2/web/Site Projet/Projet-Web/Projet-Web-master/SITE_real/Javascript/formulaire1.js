/*
* Ce fichier JS est relié à la page formulaire1.xhtml.
* On y retrouve la vérification des inputs et la création de pages xhtml en fonction du contenu entré
* ( Soit résumé des inputs, soit pseudo création d'une fiche vidéo à partir des inputs ).
*
* Une partie des fonction de vérification est activé onblur de l'input.
* Si la bordure de l'input devient vert, alors la valeur semble cohérente, sinon la bordure est jaune.
* A noter que la vérification approfondie de chaque input n'as pas été fait ( par exemple, pour les
* noms / prénoms, on ne vérifie que la présence de chiffes, pas des autre charactères incohérents tels que
* ~#{[|`\^@]}=+ etc ).
* La vérification est sommaire.
*
* Note :
* Pour la création de pages HTML externes à partir du formulaire, nous aurions pu ajouter un bouton qui
* ramène à la page précédente, mais comme on ouvre une autre page, le formulaire reste ouvert.
* Ajouter un bouton pour soit fermer la page html ouverte serait inutile, et aller à la page du formulaire
* est aussi inutile parce qu'il est déjà ouvert.
*
* */

// Vérifie que le nom / prénom ne contienne pas de chiffres dedans.
function check_name(o) {
    let str = o.value;
    let boolean = false;

    for (let i = 0; i < str.length; i++) {
        if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            boolean = true;
        }
    }

    if (boolean === true ){
        o.style= "border-color: yellow";
    }
    if (boolean === false ){
        o.style= "border-color: green";
    }
}

// Vérifie que l'âge est sélectionné.
function check_age(o) {
    if ( o.value === "select"){
        o.style= "border-color: yellow";
    }
    else{
        o.style= "border-color: green";
    }
}

// On vérifie que la catégorie est sélectionnée.
function check_category(o) {
    if ( o.value === "select"){
        o.style= "border-color: yellow";
    }
    else{
        o.style= "border-color: green";
    }
}

// On vérifie que l'input n'est pas vide
function check_string(o) {
    if ( o.value === ""){
        o.style= "border-color: yellow";
    }
    else{
        o.style= "border-color: green";
    }
}

// On vérifie que l'input n'est pas vide
function check_length(o) {
    if ( o.value !== ""){
        o.style= "border-color: green";

    }
    else{
        o.style= "border-color: yellow";
    }
}

// On vérifie que l'input n'est pas vide
function check_date(o) {
    if ( o.value === ""){
        o.style= "border-color: yellow";

    }
    else{
        o.style= "border-color: green";
    }
}

// On vérifie que l'input est bien un int, sinon on extrait tous les entiers avant le premier caractère qui n'est pas un chiffre.
function check_number(o) {
    if (isNaN(parseInt(o.value))){
        o.style= "border-color: yellow";

    }
    else{
        o.style= "border-color: green";
        o.value = parseInt(o.value);
    }
}


/*
*
* Vérification de chaque inputs avant la création des pages xHtml ( ou le bouton check )
* On utilise les mes idées que pour les functions check précédentes.
* A chaque fois qu'un input est valide, on le compte.
* Nous avons 12 inputs ( sans compter les radio ) qui peuvent êtrent invalident
* Donc si le nombre compté est différents de 12, alors on retourne false
* Sinon, si tous les inputs sont 'valides', on retourne true.
*
* */
function count_form() {
    let count = 0; // Global count



    // ------------------ NOM CHECK     ------------------ \\
    let boolean1 = false; // To know if there's a number in the value
    let obj_name = document.getElementById("id_nom").value;
    for (let i = 0; i < obj_name.length; i++) {
        if (obj_name.charAt(i) >= '0' && obj_name.charAt(i) <= '9'){
            boolean1 = true;
        }
    }

    if (boolean1 === false){
        count += 1;
    }

    // ------------------ PRENOM CHECK  ------------------ \\
    let boolean2 = false;
    obj_name = document.getElementById("id_prenom").value;
    for (let i = 0; i < obj_name.length; i++) {
        if (obj_name.charAt(i) >= '0' && obj_name.charAt(i) <= '9'){
            boolean2 = true;
        }
    }

    if (boolean2 === false ){
        count += 1;
    }



    // ------------------ AGE CHECK      ------------------ \\
    if (document.getElementById("id_age").value !== "select"){
        count += 1;
    }



    // ------------------ CATEGORY CHECK ------------------ \\
    if (document.getElementById("video_category").value !== "select" ){
        count += 1;
    }


    // ------------------ NAME CHECK     ------------------ \\
    if (document.getElementById("video_name").value !== "" ){
        count += 1;
    }


    // ------------------ ID CHECK      ------------------ \\
    if (document.getElementById("video_id").value !== "" ){
        count += 1;
    }


    // ------------------ COMMENT CHECK ------------------ \\
    if (document.getElementById("video_comment").value !== "" ){
        count += 1;
    }


    // ------------------ LENGTH CHECK  ------------------ \\
    if (document.getElementById("video_length").value !== ""){
        count += 1;
    }


    // ------------------ DATE CHECK     ------------------ \\
    if (document.getElementById("video_date").value !== ""){
        count += 1;
    }


    // ------------------ VIEWS CHECK   ------------------ \\
    if (document.getElementById("video_views").value !== "" ){
        count += 1;
    }


    // ------------------ UP CHECK      ------------------ \\
    if (document.getElementById("video_up").value !== "" ){
        count += 1;
    }


    // ------------------ DOWN CHECK   ------------------ \\
    if (document.getElementById("video_down").value !== "" ){
        count += 1;
    }

    return (count === 12);  // Return true if count = 12, return false if count != 12.
}

// Crée une alert à propos de l'état du form.
function check_form() {
    if (count_form()){
        alert("Correct inputs, you can Submit !");
    }
    else {
        alert("Invalid inputs, please verify what you wrote");
    }
}

// Récupère la valeur de gender
function get_gender() {
    if (document.getElementById("id_male").checked){
        return "male";
    }
    if (document.getElementById("id_female").checked){
        return "female";
    }
    if (document.getElementById("id_other").checked){
        return "other";
    }
}

// Permet de stocker toutes les valeurs d'inputs pour les afficher dans la page résumé html générée.
function get_data() {
    let nom = document.getElementById("id_nom").value;
    let prenom = document.getElementById("id_prenom").value;
    let gender = get_gender();
    let age = document.getElementById("id_age").value;
    let category = document.getElementById("video_category").value;
    let video_name = document.getElementById("video_name").value;
    let video_comment = document.getElementById("video_comment").value;
    let video_length = document.getElementById("video_length").value;
    let video_date = document.getElementById("video_date").value;
    let video_views = document.getElementById("video_views").value;
    let video_up = document.getElementById("video_up").value;
    let video_down = document.getElementById("video_down").value;
    let d = new Date();
    let user_date = d.getFullYear() + " - " + (d.getMonth() + 1) + " - " + d.getDate();
    let user_time = d.getHours() + " - " + d.getMinutes();
    let user_language = window.clientInformation.language;


    return [nom, prenom, gender, age, category, video_name, video_comment, video_length, video_date, video_views, video_up, video_down, user_date, user_time, user_language];
}

// Crée la page xhtml avec le résumé des inputs de l'utilisateur.
function create_resume() {

  let div = document.createElement("div");
  let table = document.createElement("table");
  let first_tr = document.createElement("tr");
  let th_name = document.createElement("th");
  th_name.appendChild(document.createTextNode("Name"));
  let th_data = document.createElement("th");
  th_data.appendChild(document.createTextNode("Data"));
  first_tr.appendChild(th_data);
  first_tr.appendChild(th_name);
  table.appendChild(first_tr);


  let user_array = [["user_nom","user_prenom", "user_genre", "user_age","video_category", "video_name", "video_comment",
      "video_length", "video_date", "video_views", "video_up", "video_down", "user_date", "user_time", "user_language"],
      get_data()];

  for (let i = 0; i <= user_array[0].length - 1; i+=1) {
      let name = user_array[0][i];
      let data = user_array[1][i];
      let tr = document.createElement("tr");
      let th_name = document.createElement("th");
      let th_data = document.createElement("th");

      th_name.appendChild(document.createTextNode(name));
      th_data.appendChild(document.createTextNode(data));

      tr.appendChild(th_name);
      tr.appendChild(th_data);

      table.appendChild(tr);
  }

  div.appendChild(table);

  let str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
      "<!DOCTYPE html\n" +
      "        PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n" +
      "        \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
      "<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\" xml:lang=\"en\">\n" +
      "<head>\n" +
      "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n" +
      "    <title>The PewDiePie Project</title>\n" +
      "    <link rel=\"icon\" type=\"image/png\" href=\"../../Images/pdplogo.png\"/>\n" +
      "\n" +
      "    <link rel=\"stylesheet\" href=\"../../Styles/style.css\"/>\n" +
      "    <link rel=\"stylesheet\" href=\"../../Styles/data.css\"/>\n" +
      "\n" +
      "</head>\n" +
      "<body class=\"main\">" + "<h1><a href=\"../Collection/categories.xhtml\">The PewDiePie Project</a></h1>" + div.innerHTML + "</body>\n" +
      "</html>";
  

  let new_page = window.open("data.xhtml");
  new_page.document.write(str)
}

// Lance la création de la page résumé si le formulaire est correct
function exec_resume() {
    if (count_form()){
        create_resume()
    }
    else {
        window.alert("Invalid inputs, check the informations you entered")
    }
}

/* Génère la page xhtml de la vidéo à partir de l'input de l'utilisateur.
* Note : le video ID permet de récupérer l'iframe de youtube.
* Pour avoir l'ID d'un vidéo Youtube :
* Aller sur une vidéo Youtube, le lien se présente sous la forme suivante
* https://www.youtube.com/watch?v=VIDEO_ID
* Il vous suffit alors de copier la chaîne de caractères équivalente à VIDEO_ID ici
* */
function create_page() {
    let category = document.getElementById("video_category").value;
    let video_name = document.getElementById("video_name").value;
    let video_comment = document.getElementById("video_comment").value;
    let video_length = document.getElementById("video_length").value;
    let video_date = document.getElementById("video_date").value;
    let video_views = document.getElementById("video_views").value;
    let video_up = document.getElementById("video_up").value;
    let video_down = document.getElementById("video_down").value;
    let video_id = document.getElementById("video_id").value;
    let ratio = Math.round(parseInt(video_up) / (parseInt(video_up) + parseInt(video_down)) * 100) + " %";
    let str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<!DOCTYPE html\n" +
        "        PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n" +
        "        \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
        "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\n" +
        "<head>\n" +
        "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n" +
        "    <title>PDP Project - LWIAY</title>\n" +
        "    <link rel=\"icon\" type=\"image/png\" href=\"../../Images/pdplogo.png\"/>\n" +
        "    <link rel=\"stylesheet\" href=\"../../Styles/style.css\"/>\n" +
        "    <link rel=\"stylesheet\" href=\"../../Styles/Vids.css\"/>\n" +
        "</head>\n" +
        "<body class=\"main\">" +
        "<h1><a href=\"../Collection/categories.xhtml\">The PewDiePie Project</a></h1>\n" +
        "<p>" + category +"</p>\n" +
        "<div>\n" +
        "    <p>" + video_name + "</p>\n" +
        "    <div>\n" +
        "        <p>" + video_comment + "</p>\n" +
        "           <div>\n" +
        "            <iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/" + video_id + "\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen=\"true\"><p>iFrame not supported</p></iframe>\n" +
        "        </div>" +
        "    </div>\n" +
        "    <div>\n" +
        "        <ul>\n" +
        "            <li>Length : " + video_length + " </li>\n" +
        "            <li>Date : " + video_date + "</li>\n" +
        "            <li>Views : " + video_views + "</li>\n" +
        "            <li>Ratio : " + ratio + "</li>\n" +
        "        </ul>\n" +
        "    </div>\n" +
        "    <div>\n" +
        "        <a  href=\"\"> <img  src=\"../../Images/navigation-next-1.svg\" alt=\"next\"/></a>\n" +
        "        <a  href=\"\"> <img  src=\"../../Images/navigation-before-1.svg\" alt=\"previous\"/></a>\n" +
        "    </div>\n" +
        "    <div>\n" +
        "        <p>Go back to the <a href=\"../Collection/categories.xhtml\">menu </a> or go to the <a href=\"../../index.html\"> gates </a></p>\n" +
        "    </div>\n" +
        "    <p>All the information posted here are from <a href=\"https://youtube.com/user/pewdiepie\">Youtube</a>.</p>\n" +
        "</div>" +
        "</body>\n" +
        "</html>";

    let new_page = window.open("newvideo.xhtml");
    new_page.document.write(str)

}

// Lance la création de la page vidéo si le formulaire est correct
function exec_page() {
    if (count_form()){
        create_page();
    }
    else {
        window.alert("Invalid inputs, check the informations you entered")
    }
}
