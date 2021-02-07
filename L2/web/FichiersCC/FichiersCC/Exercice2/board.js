var board;


function setStyle(o,rownb,colnb){
    o.style.backgroundColor="grey";
    var w = window.innerWidth / colnb;
    var h = window.innerHeight / rownb;
    o.style.width = w/2 + "px";
    o.style.height = h/2 + "px";
    o.style.border = "black solid 1px";
}

function setBoardStyle(o,div){
    
    o.style.width = window.innerWidth / 2+"px";
    o.style.height = window.innerHeight / 2+"px";
    o.style.marginLeft="auto";
    o.style.marginRight="auto";
    o.style.marginTop=(window.innerHeight / 12) + "px";

}

function setAttributes(o, x, y){
    o.id="_case_"+x+"_"+y+"_";
}

function setEvents(o){
    o.onclick = function () {setBackground(this);};
}

function setTreasure(o){
    o.treasureX = Math.floor(Math.random()*o.col);
    o.treasureY = Math.floor(Math.random()*o.row);

    o[o.treasureY][o.treasureX].onclick = function(){
	if (!o.found){
	    o.found=true;
	    setBackground(this);
	    var textNode = document.createTextNode("X");
	    this.appendChild(textNode);
	    this.style.fontSize="14pt";
	    this.style.color = "white";
	    this.style.textAlign="center";
	
	    displayWinningMessage();
	}
    }
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

function displaySolutionButton(o){
    var button = document.createElement("button");
    var boardtable = document.getElementById("_board_");

    button.appendChild(document.createTextNode("Display solution"));
    addElementAfter(button,o,boardtable);

    button.onclick=function(){ displaySolution();
			     };
    button.style.marginLeft="auto";
    button.style.marginRight="auto";
    button.style.display="block";
}

function createBoardInElement(o,row,col){
    board = new Array();
    board.row = row;
    board.col = col;
    board.found = false;
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
	    board[i][j].x=j;
	    board[i][j].y=i;
	    tr.appendChild(board[i][j]);
	    setStyle(board[i][j],row,col);
	    setAttributes(board[i][j],j,i);
	    setEvents(board[i][j]);
	}
    }
    setTreasure(board);

    displaySolutionButton(o);

    o.style.height =((3 *  window.innerHeight) / 4) + "px";
  
    o.style.border="1px lightgrey solid";
    setBoardStyle(table,o);

}




function createBoard(row,col){
    createBoardInElement(document.getElementById("game"),row,col);
}


function addNickname(name){
    var hr = document.getElementById("separator");
    var body = document.getElementsByTagName("body")[0];
    var h1 = document.createElement("h1");
    h1.appendChild(document.createTextNode("Welcome to the Treasure Chest of "+name));
    h1.style.textAlign="center";
    
    addElementAfter(h1,body,hr);

}

function computeDistanceFromTreasure(o){
    return (Math.abs(o.x-board.treasureX) +  Math.abs(o.y-board.treasureY));
    
}

function buildLegend(colors, values){
    if (colors.length != values.length){
	console.log("Error : arrays do not have the same length");
	return ;
    }
    
    var tableinputs = document.getElementById("inputs");

    var tablelegend = document.createElement("table");
    var caption = document.createElement("caption");
    tablelegend.appendChild(caption);
    caption.appendChild(document.createTextNode("Meaning of colors"));
    caption.style.fontStyle="italic";
    
    var thead = document.createElement("thead");
    var tr = document.createElement("tr");
    var th_color = document.createElement("th");
    var th_distance = document.createElement("th");

    tablelegend.appendChild(thead);
    thead.appendChild(tr);
    tr.appendChild(th_color);
    tr.appendChild(th_distance);
    th_color.appendChild(document.createTextNode("color"));
    th_distance.appendChild(document.createTextNode("distance "));
    th_distance.appendChild(document.createElement("br"));
    th_distance.appendChild(document.createTextNode("to the treasure"));
    
    var tbody = document.createElement("tbody");
    tablelegend.appendChild(tbody);

    for (var i = 0 ; i < colors.length; i++){
	var tri = document.createElement("tr");
	var td_color = document.createElement("td");
	var td_distance = document.createElement("td");
	tbody.appendChild(tri);
	tbody.appendChild(td_color);
	tbody.appendChild(td_distance);
	td_color.appendChild(document.createTextNode(colors[i]));
	td_color.style.width="40px";
	td_color.style.backgroundColor=colors[i];
	td_distance.appendChild(document.createTextNode(values[i]));
	td_distance.style.backgroundColor=colors[i];
	td_color.style.border="1px solid black";
	td_distance.style.border="1px solid black";
    }

    tablelegend.style.borderCollapse="collapse";
    tablelegend.style.border="1px solid black";
    thead.style.border="1px solid blue";
    th_color.style.border="1px solid black";
    th_distance.style.border="1px solid black";


    var div=document.getElementById("data");
    addElementAfter(tablelegend,div,tableinputs);

    tableinputs.style.display="inline-block";
    tablelegend.style.display="inline-block";
    tablelegend.style.position="fixed";
    tablelegend.style.right="10px";
    tablelegend.style.top="10px";
    tablelegend.style.zIndex="3";
    tablelegend.style.fontSize="10pt";
    tablelegend.style.top="10px"

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

function setTextToElement(row, col, text){
    if (board[row][col].hasChildNodes()){
	var c = board[row][col].childNodes;
	for (var i = 0 ; i < c.length ; i++){
	    board[row][col].removeChild(c[i]);
	}
    }
    board[row][col].appendChild(document.createTextNode(text+""));
    board[row][col].style.textAlign="center";
    board[row][col].style.fontSize="14pt";
}
