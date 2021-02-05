<?php
   session_start();
?>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP 5</title>
    </head>
    <body>

        <h1>exo 4.1, deuxième page</h1>

        <p>
            <?php

            isset($_SESSION);
            if (isset($_SESSION[0]))
                echo $_SESSION[0];
            if (isset($_SESSION[1]))
                echo $_SESSION[1];
            ?>
        </p>

        <h2>SESSION</h2>
        <?php
            echo '<pre>';
            echo htmlspecialchars(print_r($_SESSION, true));
            echo '</pre>';
        ?>

        <h2>COOKIE</h2>
        <?php
            echo '<pre>';
            echo htmlspecialchars(print_r($_COOKIE, true));
            echo '</pre>';
        ?>

    </body>
</html>
