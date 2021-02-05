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

        <h1>exo 3.2, affichage des habitants</h1>
        
        <h2>Choix de la ville</h2>

        <form method="post" action="aff_habitants.php">
            <p>
                Quelle ville :
                <select name="ville">
                    <?php
                        $sql = 'SELECT * FROM tp_villes';
                        // TODO :
                        // - faire la requête SQL
                        // - créer les éléments de la liste déroulante
                    ?>
                </select>
                <input type="submit" value="go"/>
            </p>
        </form>


        <h2>Liste des habitants</h2>
        
        <?php
            // TODO :
            // si on reçoit le formulaire
            // - $sql = 'SELECT tp_auteurs.nom FROM tp_auteurs WHERE tp_auteurs.ville_id =' . /* id ville */ . ';';
            // - faire la requête
            // - afficher les habitants dans une liste HTML
        ?>

    </body>
</html>
<?php
    bd_deconnexion();
?>

