<?php
    session_start();
    include_once('auth.php');

    if (isAuthenticate())
        unsetAuthenticate();
        
    header('Location: main.php');
?>

