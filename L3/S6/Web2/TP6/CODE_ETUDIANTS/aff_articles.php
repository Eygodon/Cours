<?php
    // TODO : 3.6 : il y a quelque chose à faire ici, en premier, pour la gestion de l'authentification
    include_once('auth.php');
    include_once('bd.php');
    // TODO :
    // - 3.6 : redirection vers la page d'accueil si l'internaute n'est pas authentifié
    // - connexion au serveur de bases de données
?>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP 6</title>
        <link rel="stylesheet" media="all" type="text/css" title="Mon Style" href="style.css" />
    </head>
    <body>
        <p>
            Retour à la <a href="main.php">page principale</a><br />
            <!-- TODO : 3.6 : lien de déconnexion-->
        </p>

        <h1>exo 3.1, affichage des articles</h1>

        <?php
            $sql = 'SELECT tp_auteurs.*, tp_villes.nom AS ville_nom FROM tp_auteurs, tp_villes ' .
                   'WHERE ville_id = tp_villes.id;';
            // TODO : 
            // - faire la requête SQL
            // - afficher le résultat dans une table HTML
        ?>

    </body>
</html>
<?php
    bd_deconnexion();
?>

