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
            <!-- TODO : lien de déconnexion-->
        </p>

        <h1>exo 3.5, suppression d'un auteur</h1>
        
        <h2>Choisissez votre auteur</h2>

        <form action="efface_auteur.php" method="post">
            <p>
                <label>Choix de l'auteur</label>
                <select name="id" size="1">
                    <?php
                        $sql = 'SELECT id, nom FROM tp_auteurs';
                        // TODO :
                        // - faire la requête SQL
                        // - créer les éléments de la liste déroulante
                    ?>
                </select>
            </p>
            <p><input type="submit" value="Valider" /></p>
        </form>

        <?php
            // TODO :
            // si on reçoit le formulaire
            // - $sql = 'SELECT id FROM tp_articles WHERE auteur_id = ' . /* id auteur */;
            // - faire la requête
            //   (permet de vérifier si l'auteur a écrit des articles)
            // - s'il n'a pas écrit d'article
            //      . $sql = 'DELETE FROM tp_auteurs WHERE id = ' . /* id auteur */;
            //      . faire la requête
        ?>

        <h2>POST</h2>
        <?php
            echo '<pre>';
            echo htmlspecialchars(print_r($_POST, true));
            echo '</pre>';
        ?>

    </body>
</html>
<?php
    bd_deconnexion();
?>

