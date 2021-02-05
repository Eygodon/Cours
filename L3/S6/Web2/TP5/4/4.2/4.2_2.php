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

        <h1>exo 4.2, deuxième page</h1>

        <p>
            <a href="4.2_1.php">cliquer ici</a> pour revenir à la première page.
        </p>

        <h2>Actions</h2>

        <?php
        if (isset($_GET["action"]) && is_numeric($_GET["action"]) && 0 < $_GET["action"] && $_GET["action"] < 6){
            switch ($_GET["action"]){
                case 1 : $_SESSION["nom"] = "Arthur";
                         $_SESSION["age"] = 950;
                         break;
                case 2 : $_SESSION["nom"] = "Perceval";
                         $_SESSION["age"] = 800;
                         break;
                case 3 : print_r($_SESSION);
                         break;
                case 4 : unset($_SESSION["nom"]);
                         break;
                case 5 : session_destroy();
                         break;
            }
        }
        ?>

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
