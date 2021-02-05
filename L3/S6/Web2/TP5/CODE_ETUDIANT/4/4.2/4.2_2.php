<?php
   // TODO : créer/récupérer la session
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
            // TODO
            // vérifier que la variable GET nommée 'action' :
            // - existe (fonction isset)
            // - est un nombre (fonction is_numeric)
            // - est comprise entre 1 et 5
            // selon valeur de action :
            // 1: modifier les cases 'nom' et 'age' de la session
            // 2: modifier les cases 'nom' et 'age' de la session avec d'autres valeurs
            // 3: afficher les deux cases de la session si elles existent
            // 4: détruire (fonction unset) la case 'nom' de la session
            // 5: détruire la session (fonction session_destroy)
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
