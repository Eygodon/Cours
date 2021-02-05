<?php
   // TODO : ajouter 2 cases à $_SESSION
?>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP 5</title>
    </head>
    <body>

        <h1>exo 4.1, première page</h1>

        <p>
            Allez sur la <!-- faire un lien sur la page suivante -->
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
