// This file is about the sitemap - it make possible the deploy thying when you click on the triangle.
// It's allow to display or not the content under each line.

// Return to the relative case
function deploy_bellow(id){
    console.log(id);
    switch (id) {
        case "categories": display_categories(); console.log(id); break;
        case "memereview": display_memereview(); console.log(id); break;
        case "LWIAY": display_LWIAY(); console.log(id); break;
        case "YLYL": display_YLYL(); console.log(id); break;
        case "PewNews": display_PewNews(); console.log(id); break;
        case "TIKTOK": display_TIKTOK(); console.log(id); break;
        case "other": display_other(); console.log(id); break;
        case "miscellaneous": display_miscellaneous(); console.log(id); break;

    }
}
// For each case, display or not the parts.
function display_categories(){
    status = document.getElementById("memereview").style.display;
    if (status === 'none'){
        document.getElementById("memereview").style.display = 'block';
        document.getElementById("LWIAY").style.display = 'block';
        document.getElementById("YLYL").style.display = 'block';
        document.getElementById("PewNews").style.display = 'block';
        document.getElementById("TIKTOK").style.display = 'block';
        document.getElementById("other").style.display = 'block';
        document.getElementById("miscellaneous").style.display = 'block';
    }
    else if (status === 'block'){
        document.getElementById("memereview").style.display = 'none';
        document.getElementById("LWIAY").style.display = 'none';
        document.getElementById("YLYL").style.display = 'none';
        document.getElementById("PewNews").style.display = 'none';
        document.getElementById("TIKTOK").style.display = 'none';
        document.getElementById("other").style.display = 'none';
        document.getElementById("miscellaneous").style.display = 'none';
    }
}

function display_memereview(){
    console.log("Meme Review Time !");
    status = document.getElementById("memereviewvideos").style.display;
    console.log(status);
    if (status === 'none') {
        document.getElementById("memereviewvideos").style.display = 'block';
        console.log("displayed");
    }
    else if (status === 'block'){
        document.getElementById("memereviewvideos").style.display = 'none';
        console.log("hidden ;)");
    }
}

function display_LWIAY() {
    status = document.getElementById("LWIAYvideos").style.display;
    if (status === 'none') {
        document.getElementById("LWIAYvideos").style.display = 'block';
    }
    else if (status === 'block'){
        document.getElementById("LWIAYvideos").style.display = 'none';
    }
}

function display_YLYL() {
    status = document.getElementById("YLYLvideos").style.display;
    if (status === 'none') {
        document.getElementById("YLYLvideos").style.display = 'block';
    }
    else if (status === 'block'){
        document.getElementById("YLYLvideos").style.display = 'none';
    }

}

function display_PewNews() {
    console.log("Display PewNews");
    status = document.getElementById("PewNewsvideos").style.display;
    if (status === 'none') {
        document.getElementById("PewNewsvideos").style.display = 'block';
    }
    else if (status === 'block'){
        document.getElementById("PewNewsvideos").style.display = 'none';
    }
}

function display_TIKTOK() {
    status = document.getElementById("TIKTOKvideos").style.display;
    if (status === 'none') {
        document.getElementById("TIKTOKvideos").style.display = 'block';
    }
    else if (status === 'block'){
        document.getElementById("TIKTOKvideos").style.display = 'none';
    }
}

function display_other() {
    status = document.getElementById("othervideos").style.display;
    if (status === 'none') {
        document.getElementById("othervideos").style.display = 'block';
    }
    else if (status === 'block'){
        document.getElementById("othervideos").style.display = 'none';
    }
}

function display_miscellaneous() {
    status = document.getElementById("miscellaneousvideos").style.display;
    if (status === 'none') {
        document.getElementById("miscellaneousvideos").style.display = 'block';
    }
    else if (status === 'block'){
        document.getElementById("miscellaneousvideos").style.display = 'none';
    }
}