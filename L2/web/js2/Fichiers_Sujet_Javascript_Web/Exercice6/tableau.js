var td;

function buildTable(lines,columns){
    let oldtable = document.getElementById("autotable");
    if (oldtable != null){
	oldtable.parentNode.removeChild(oldtable);
    }

    td = new Array(lines*columns);
    td.lines = lines;
    td.columns = columns;
    let table = document.createElement("table");
    table.id="autotable";
    
    document.body.appendChild(table);

    table.style.borderCollapse="collapse";


    for (let l = 0 ; l < lines ; l++){
	let tr = document.createElement("tr");
	tr.style.width="100%"
	for (let c = 0 ; c < columns ; c++){
	    td[l*columns+c] = document.createElement("td");
	    td[l*columns+c].style.border="solid 2px black";
	    td[l*columns+c].width = "30px";
	    td[l*columns+c].height="60px";

	    tr.appendChild(td[l*columns+c]);
	}
	table.appendChild(tr);
    }
}

function fillTable(){
    for (let i = 1 ; i <= td.lines ; i++){
	for (let j = 1 ; j <= td.columns ; j++){
	    setElementValue(i,j,"("+i+","+j+")");
	}
    }
}

function setElementValue(line,col, val){
    let currentNode = td[(line-1) * td.columns + (col-1)];
    // on enleve d'abord ce qui etait eventuellement dans la case 
    while( currentNode.hasChildNodes()){
	let child = currentNode.firstChild;
	currentNode.removeChild(child);
    }

    // on ajoute la nouvelle valeur
    let newnode = document.createTextNode(val.toString()+"");
    currentNode.appendChild(newnode);

}

function getElement(line,col){
    return td[(line-1) * td.columns + (col-1)];
}

function getElementValue(line,col){
    return td[(line-1) * td.columns + (col-1)].firstChild.nodeValue;
}

function getNumberOfLines(){
    return td.lines;
}

function getNumberOfColumns(){
    return td.columns;
}
