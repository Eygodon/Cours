<?php
   // pas de session_start dans ce fichier
?>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP 5</title>
    </head>
    <body>

        <h1>exo 4.2, première page</h1>

        <p>
            <!-- lien vers 4.2_2.php avec action=1 --> : modification de <code>nom</code> et de <code>age</code><br />
            <!-- lien vers 4.2_2.php avec action=2 --> : autre modification de <code>nom</code> et de <code>age</code><br />
            <!-- lien vers 4.2_2.php avec action=3 --> : affichage de <code>nom</code> et de <code>age</code><br />
            <!-- lien vers 4.2_2.php avec action=4 --> : suppression de <code>nom</code><br />
            <!-- lien vers 4.2_2.php avec action=5 --> : destruction de la session<br />
        </p>

        <h2>SESSION</h2>
        <p>
            On ne gère pas les session dans ce fichier, donc normalement le tableau n'existe pas.
        </p>
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
