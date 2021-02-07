function display( message ) {
    console.log(message) ;

}
function computeDiscount ( price ) {
    let newPrice;
    if (typeof price != "number"
)
    {
        return -1; // ERREUR
    }
    if (price >= 1000)
    {
        newPrice = price * 0.6;
    }
    else if (price >= 500)
    {
        newPrice = price * 0.8;
    }
    else if (price >= 100)
    {
        newPrice = price * 0.9;
    }
    else {
        newPrice = price;
    }
    return newPrice;
}
display(computeDiscount("bi"));

function getMaximum(a,b,c){
    let Max;
    if ((a >= b) && (a >= c))
        {
            Max = a;
        }
    else if ((b >= a) && (b >= c))
        {
            Max = b;
        }
    else
        {
            Max = c;
        }
    return Max;
}

display(getMaximum(2,3,1));

function nextSecond(h,m,s) {
    let time;
    if  ((h===23) && (m===59) && (s===59)) {
            time=(`00 : 00 : 00`);
        }
    else if ((h!==23) && (m===59) && (s===59)) {
        time=(`${h + 1} : 00 : 00`);
    }
    else if ((h!==23) && (m!==59) && (s===59)) {
        time=(`${h} : ${m+1} : 00`);
    }
    else if ((h!==23) && (m!==59)&& (s!==59)) {
        time = (`${h} : ${m} : ${s+1}`);
    }
    else
    {
        time="UNKNOWN"
    }
        return time;
}
display(nextSecond(21,37,4));

function giveDirection(d){
    let direction;
    switch (d){
        case 'n':
        case 'N': direction = "NORTH"; break;
        case 'e':
        case 'E' : direction = "EAST"; break;
        case 's' :
        case 'S' : direction = "SOUTH"; break;
        case 'w' :
        case 'W' : direction = "WEST"; break;
        default : direction = "ERROR";
    }
    return direction;
}
display(giveDirection('k'));

function getMonthName(m){
    let month;
    switch(m){
        case 1 : month = "JANUARY";break;
        case 2 : month = "FEBRUARY";break;
        case 3 : month = "MARCH";break;
        case 4 : month = "APRIL";break;
        case 5 : month = "MAY";break;
        case 6 : month = "JUNE";break;
        case 7 : month = "JULY";break;
        case 8 : month = "AUGUST";break;
        case 9 : month = "SEPTEMBER";break;
        case 10 : month = "OCTOBER";break;
        case 11 : month = "NOVEMBER";break;
        case 12 : month = "DECEMBER";break;
        default : month = "PLEASE, ENTER A VALID NUMBER.";
    }
    return month
}
display(getMonthName(18));
function isLeapyear(year) {
    return ((year % 4 === 0) && (year % 100 !==0))
        || ( year % 400 ===0)
}
display(isLeapyear(2018));
function getNumberOfDays(m,y) {
    let days;
    if (isLeapyear(y)===true){
        switch (m) {
            case 1 : days = 31;break;
            case 2 : days = 29;break;
            case 3 : days = 31;break;
            case 4 : days = 30;break;
            case 5 : days = 31;break;
            case 6 : days = 30;break;
            case 7 : days = 31;break;
            case 8 : days = 31;break;
            case 9 : days = 30;break;
            case 10 : days = 31;break;
            case 11 : days = 30;break;
            case 12 : days = 31;break;
            default : days = "PLEASE, ENTER VALID NUMBERS.";
        }
    }
    else {
        switch (m) {
        case 1 : days = 31;break;
        case 2 : days = 28;break;
        case 3 : days = 31;break;
        case 4 : days = 30;break;
        case 5 : days = 31;break;
        case 6 : days = 30;break;
        case 7 : days = 31;break;
        case 8 : days = 31;break;
        case 9 : days = 30;break;
        case 10 : days = 31;break;
        case 11 : days = 30;break;
        case 12 : days = 31;break;
        default : days = "PLEASE, ENTER VALID NUMBERS.";
        }
    }
    return days
}
        display(getNumberOfDays(2,2017));
