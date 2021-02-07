var board;


function setStyle(o,rownb,colnb){
    o.style.backgroundColor="white";
    var w = window.innerWidth * 0.8 / colnb;
    var h = window.innerHeight / rownb;
    o.style.width = w/2 + "px";
    o.style.height = h/2 + "px";
    o.style.border = "black solid 1px";
    o.style.textAlign="center";
    o.style.fontSize="1.8em";
}

function setBoardStyle(o,div){
    
    o.style.width = window.innerWidth * 0.8 / 2 +"px";
    o.style.height = window.innerHeight / 2+"px";
    o.style.marginLeft="auto";
    o.style.marginRight="auto";
    o.style.marginTop=(window.innerHeight / 12) + "px";
    o.style.borderCollapse="collapse";
    
    div.style.width = window.innerWidth * 0.8;
    div.style.display="inline-block";
    o.style.verticalAlign="top";
    

}

function setAttributes(o, x, y){
    o.id="_case_"+x+"_"+y+"_";
}

function setEvents(o){
    o.onclick = function () {
	currentTrio = board.grid.currentTrio;
	if (currentTrio.length == 0){
	    currentTrio[0] = [this.row,this.col];
	    setSelectedStyle(this);
	    setValue("op1",this.firstChild.nodeValue);
	}
	else if((currentTrio.length == 1) && (is8Neighbour(currentTrio[0][0], currentTrio[0][1],this.row,this.col))){
	    currentTrio[1] = [this.row,this.col];
	    currentTrio.dir = [this.row-currentTrio[0][0],this.col-currentTrio[0][1]];
	    setSelectedStyle(this);
	    setValue("op2",this.firstChild.nodeValue);
	}
	else if((currentTrio.length == 2) && (isInDirection(currentTrio[1][0], currentTrio[1][1],this.row,this.col,currentTrio.dir ))){
	    currentTrio[2] = [this.row,this.col];
	    setSelectedStyle(this);
	    setValue("op3",this.firstChild.nodeValue);
	}

	else{
	    if (currentTrio.length < 3){
		window.alert("Mauvais choix : les 3 chiffres doivent être alignés");
	    }
	    else if (currentTrio.length == 3){
		window.alert("Vous avez déjà choisi 3 valeurs");
	    }
	}
	    
	
	
    };
}


function addElementAfter(toadd,father,son){
    if (son.nextSibling == null){
	father.appendChild(toadd);
    }
    else if (son.nextSibling.nodeName == toadd.nodeName){
	father.replaceChild(toadd,son.nextSibling);
    }
    else {
	father.insertBefore(toadd,son.nextSibling);
    }
}


function createBoardInElement(o,row,col){
    board = new Array();
    board.row = row;
    board.col = col;
    board.grid=initGrid(col,row);

    
    var table = document.createElement("table");
    table.id = "_board_";
    table.style.marginLeft = "auto";
    table.style.marginRight="auto";
    table.style.marginTop = "auto";
    table.style.marginBottom="auto";
    
    var old = document.getElementById("_board_");
    if ( old != null){
	o.replaceChild(table,old);
    }
    else{
	o.appendChild(table);
    }
    
    for (var i = 0 ; i < row ; i++){
	var tr = document.createElement("tr");
	table.appendChild(tr);
	board[i] = new Array();
	for (var j = 0 ; j < col ; j++){
	    board[i][j] = document.createElement("td");
	    board[i][j].row=i;
	    board[i][j].col=j;
	    tr.appendChild(board[i][j]);

	    var digitOnTD = document.createTextNode(board.grid[i][j]+"");
	    board[i][j].appendChild(digitOnTD);
	    setStyle(board[i][j],row,col);
	    setAttributes(board[i][j],i,j);
	    setEvents(board[i][j]);
	}
    }

    o.style.height =((3 *  window.innerHeight) / 4) + "px";
  
    o.style.border="1px lightgrey solid";
    setBoardStyle(table,o);

}




function createBoard(row,col){
    createBoardInElement(document.getElementById("grid"),row,col);
}



function getElement(row,col){
    
    return board[row][col];
}

function getRowNb(){
    return board.row;
}

function getColNb(){
    return board.col;
}


function giveOperationResult(){
    return giveOpResult(board.grid);
}

function eraseContent(o){
    while (o.hasChildNodes()){
	o.removeChild(o.firstChild);
    }
}

function giveANewChance(){
    for (var k = 0 ; k < board.grid.currentTrio.length ; k++){
	var point = board.grid.currentTrio[k];
	board[point[0]][point[1]].style.border = "1px solid black";
	board[point[0]][point[1]].style.color = "black";
    }
    eraseTrio(board.grid);
}

function addResult(o){
    eraseContent(o);
    o.style.width = "30pt";
    o.appendChild(document.createTextNode(giveOperationResult()));
}

function setSelectedStyle(o){
    o.style.color = "blue";
    o.style.border = "2px solid red";
}
