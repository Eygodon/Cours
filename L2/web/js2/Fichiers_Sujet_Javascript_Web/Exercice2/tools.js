/*******************************************************
* Ajoute la chaîne de caractères associée à l'objet s  *
* dans la division d'identifiant id										 *
********************************************************/

function addTextToDiv(s, id)
{
    let el = document.getElementById(id);
    el.appendChild(document.createTextNode(s));
    
}

/*******************************************************
* Efface tout le contenu de l'élément de la page HTML  *
* passé en  paramètre                           			 *
********************************************************/
function eraseDiv(e2){
    
    while (e2.firstChild != e2.lastChild){
	if (typeof e2.firstChild.nodeType != "undefined"){
	    e2.removeChild(e2.firstChild);
	}
    }  
    
    if (e2.firstChild != null && typeof e2.firstChild.nodeType != "undefined"){
	e2.removeChild(e2.firstChild);
    }
}


/*******************************************************
* Ajoute la chaîne de caractères associée à l'objet s  *
* dans la division d'identifiant "divcontent"					 *
********************************************************/

function writediv(s){
    addTextToDiv(s,"divcontent");

}

/*******************************************************
* Ajoute la chaîne de caractères associée à l'objet s  *
* dans la division d'identifiant "divcontent"					 *
* et revient à la ligne                                *
********************************************************/
function writedivln(s){
    writediv(s);
    document.getElementById("divcontent").appendChild(document.createElement("br"));
	
}

/*******************************************************
* Efface tout le contenu de l'élément d'identifiant    *
* divcontent                                    			 *
********************************************************/
function erase(){
    eraseDiv(document.getElementById("divcontent"));
		
}

/*******************************************************
* Renvoie le nombre entré dans l'élément d'identifiant *
* idel du formulaire idform. Si la valeur n'est pas    * 
* un nombre, renvoie NaN                         			 *
********************************************************/
function getIntegerVal(idel){
    let inp = document.getElementById(idel);
    return parseInt(inp.value);
}

/*******************************************************
* Renvoie la chaîne de caractères saisie dans l'élément*
*  d'identifiant idel du formulaire idform.            * 
********************************************************/
function getVal(idel){
    let inp = document.getElementById(idel);
    return inp.value;
}



