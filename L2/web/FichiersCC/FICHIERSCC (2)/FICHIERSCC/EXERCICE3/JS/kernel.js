function initGrid(nbCols, nbRows){

    var grid = new Array();
    for (var row = 0 ; row < nbRows ; row++){
	grid[row]=new Array();
	for (var col = 0 ; col < nbCols ; col++){
	    grid[row][col] = Math.floor(Math.random() * 9) + 1;
	}
    }
    grid.nbRows = nbRows;
    grid.nbCols = nbCols;

    grid.currentTrio=new Array();
    
    return grid;
}

function eraseTrio(grid){
    grid.currentTrio = new Array();
}

function grid2string(grid){
    var s = "Rows " + grid.nbRows + " Cols " + grid.nbCols + "\n";
    
    for (var row = 0 ; row < grid.nbRows ; row++){
	for (var col = 0 ; col < grid.nbCols ; col++){
	    s += grid[row][col] + " ";
	}
	s+= "\n";
    }

    return s;
}


function nextValueInDirection(grid, row, col, dir){
    return grid[row+dir[0]][col+dir[1]];
}

function randomValue(x, max){
    var rv = 0;
    
    switch(x){
    case 1 : rv = Math.floor(Math.random()* (max-2)); break;
    case -1 : rv = Math.floor(Math.random()* (max-2))+2; break;
    case 0 : rv = Math.floor(Math.random()*max); break;
    }

    return rv;
}

function giveOpResult(grid){

   // var direction = {"E" : [0,1], "SE" : [1,1], "S" : [1,0], "SW" : [1,-1], "W" : [0,-1], "NW" : [-1,-1], "N" : [-1,0], "NE" : [-1,1]};
    var direction = [[0,1],  [1,1], [1,0],  [1,-1],  [0,-1],  [-1,-1],  [-1,0],  [-1,1]];
    
    var aleaDirection = Math.floor(Math.random() * 8);

    var aleaRow = randomValue(direction[aleaDirection][0],grid.nbRows);
    var aleaCol = randomValue(direction[aleaDirection][1],grid.nbCols);

    var aleaS = Math.floor(Math.random(2));
    var aleaSign = 1;
    if (aleaS == 0){
	aleaSign = -1;
    }
    
    var res = grid[aleaRow][aleaCol] * nextValueInDirection(grid,aleaRow,aleaCol,direction[aleaDirection])
	+ aleaSign * nextValueInDirection(grid,aleaRow,aleaCol, [direction[aleaDirection][0]*2,direction[aleaDirection][1]*2]);


    grid.trioGenerator = {"initPoint" : [aleaRow,aleaCol], "direction" : direction[aleaDirection]}
    return res;
    
    
}


function is8Neighbour(row,col,row_n,col_n){
    return (Math.abs(row-row_n) <= 1) &&  (Math.abs(col-col_n) <= 1);
}

function isInDirection(row,col, row_n, col_n, dir){
    return (row_n-row) == dir[0] && (col_n-col) == dir[1];
}
