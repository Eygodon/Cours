// Make the function write_time() is executed every 99 ms
window.setInterval(function(){write_time()}, 99);

// Function used it index.xhtml to display the time on load on the id = "time" (bottom left)
function write_time(){
    let o = document.getElementById("time"); //o is the time document we write on (on the main page)
    let d = new Date();
    let h = d.getHours();
    let m = check_time(d.getMinutes(),10);
    let s = check_time(d.getSeconds(),10);
    let ms = check_time(d.getMilliseconds(),100);
    o.innerText = "What time is it ? It's " + h + "h " + m + "m " + s + "s " + ms + "ms";
}


// Check time to add or not a '0' in front of the number to respect the alignment
function check_time(i,unit) {
    if (i<unit) {
        i = "0" + i;
    }
    return i;
}

// Display image or hide when button pressed
function display_secret(){
    let o = document.getElementById("secret_img");
    let display_status = o.style.display;
    if (display_status === 'none') {
        o.style.display = 'inline';
    }
    if (display_status === 'inline') {
        o.style.display = 'none';
    }
}


//Swap image from red to blue or blue to red when image clicked.
let is_swapping = false;
let timer =  setInterval("swap_image()", 3000);     // Every 3 sec
clearInterval(timer);

function click_brofist(){
    swap_image();
    if (is_swapping === false){
        timer =  setInterval("swap_image()", 3000);
        is_swapping = true;
    }
    else if (is_swapping === true){
        clearInterval(timer);
        is_swapping = false
    }
}

// Related to the function above, just swap the images.
function swap_image(){
    let blue = document.getElementById("brofistblue");
    let red = document.getElementById("brofistred");
    if (red.style.display === 'inline'){
        red.style.display = 'none';
        blue.style.display = 'inline';
    }
    else{
        blue.style.display = 'none';
        red.style.display = 'inline';
    }
}

function swap_style() {
    let lien_css = document.createElement('link');
    lien_css.href = "Styles/forOldGuys.css";
    lien_css.rel = "stylesheet";
    lien_css.type = "text/css";
    document.getElementsByTagName("head")[0].appendChild(lien_css);
}