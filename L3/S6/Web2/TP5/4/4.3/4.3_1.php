<?php
    // pas de session_start dans cet exercice
?>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP 5</title>
    </head>
    <body>

        <h1>exo 4.3, première page</h1>

        <p>
            <a href="4.3_2.php?action=1">lien 1</a> : création ou modification de <code>compteur</code><br />
            <a href="4.3_2.php?action=2">lien 2</a> : crée/écrase <code>nombres</code><br />
            <a href="4.3_2.php?action=3">lien 3</a> : affiche les cookies<br />
            <a href="4.3_2.php?action=4">lien 4</a> : détruit <code>compteur</code><br />
            <a href="4.3_2.php?action=5">lien 5</a> : détruit les cookies <code>nombres</code><br />
        </p>

        <h2>COOKIE</h2>
        <?php
            echo '<pre>';
            echo htmlspecialchars(print_r($_COOKIE, true));
            echo '</pre>';
        ?>

   </body>
</html>
