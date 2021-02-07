/***********************************************************
** Fonction qui "efface" le contenu du champ input 
** dont l'identifiant est passé en paramètre 
************************************************************/
function erase(o){
document.getElementById(o).value = "";
}

/***********************************************************
** Récupère le contenu du champ input prévu pour entrer 
** le nom du joueur et l'affiche dans la page en utilisant 
** la fonction fournie pour cela (setNickname)
************************************************************/
function setNickname(){
  var  name = document.getElementById("nickname");
  addNickname(name.value);
}

/***********************************************************
** Récupère le contenu des champs input prévus pour entrer
** le nombre de lignes et de colonnes et crée un tableau 
** contenant le nombre de lignes et de colonnes voulues
** en utilisant la fonction fournie pour cela (createBoard)
** Attention : la fonction en quetion attend des entiers 
** pas des chaines de caractères !
************************************************************/
function buildBoard(){
var  nbCols = parseInt(document.getElementById("cols").value) ;
var nbRows = parseInt(document.getElementById("rows").value);
createBoard(nbCols,nbRows);
}


/***********************************************************
** Positionne la couleur de fond de l'objet passé en paramètre 
** (ici ce n'est pas un identifiant mais bien un objet qui est 
** passé en paramètre)
** en fonction de sa distance avec la case du trésor
** calculée via la fonction computeDistanceFromTreasure 
** On utilisera un switch case comme vu en cours
************************************************************/
function setBackground(o){
  let distance = computeDistanceFromTreasure(o);
  switch (distance) {
    case 0 :
    case 1 : o.style.backgroundColor="red";break;
    case 2 :
    case 3 : o.style.backgroundColor="orange";break;
    case 4 :
    case 5 :
    case 6 : o.style.backgroundColor="yellow";break;
    default: o.style.backgroundColor="lightblue";break;

  }
}



/***********************************************************
** crée 2 tableaux, l'un contenant les chaînes de caractères : 
** "lightblue","yellow","orange","red", 
**l'autre contenant les chaînes de caractères
** " >= 7", "entre 4 et 6", "entre 2 et 3", "<= 1"
** et appelle la fonction buildLegend avec comme premier paramètre
** le tableau de noms de couleurs
** et comme deuxième paramètre l'autre tableau
************************************************************/
function createLegend(){
let colors = ["lightblue","yellow","orange","red"];
  let values = [">=7","in[4,]","in[2,3]","<=1"];
  buildLegend(colors,values);
  }


/************************************************************
** Affiche le message d'alerte suivant :
** "Congratulations ! You win !"
**************************************************************/
function displayWinningMessage(){
   alert("Congratulations ! You win !")
}

/************************************************************
** Parcourt toutes les cases du tableau et affiche sur chacune 
** la distance qui la sépare du trésor si elle est strictement positive 
** et affiche le texte "X" sur la case du trésor
**************************************************************/

function displaySolution(){
  for (let r = 0 ; r < getRowNb() ; r++){
    for (let c = 0 ; c < getColNb() ; c++){
      let current = getElement(r,c); // récupération de la case située
      // ligne r colonne c
      setBackground(current); // on utilise la fonction écrite dans une question précédente
      let dist = computeDistanceFromTreasure(current); // calcule de la
      // distance de la case par rapport au trésor
      if (dist == 0){ // si on est sur la case du trésor
        setTextToElement(r,c,"X");
      }
      else{
        setTextToElement(r,c,dist+"");
      }
    }
  }
}



