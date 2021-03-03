<?php
    function setAuthticate()
    {
        $_SESSION['auth'] = true;
    }

    function unsetAuthenticate()
    {
        $_SESSION['auth'] = false;
    }

    function isAuthenticate()
    {
        return isset($_SESSION['auth']) && ($_SESSION['auth'] === true);
    }
    
    function exitIfNotAuthenticate()
    {
        if (! isAuthenticate())
        {
            header('Location: main.php');
            exit(1);   // code de paranoïaque
        }
    }
?>

