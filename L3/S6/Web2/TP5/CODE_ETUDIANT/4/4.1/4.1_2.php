<?php
   // TODO : pour la fin de l'exercice
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
		// TODO :
		// tester ici
		// - l'existence de $_SESSION
		// - l'existence des deux cases de $_SESSION
		// - les afficher le cas échéant
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
