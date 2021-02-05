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

        <h1>exo 3.4, insertion d'un auteur</h1>
        
        <h2>Saisissez votre auteur</h2>

        <form action="insert_auteur.php" method="post">
            <p>
                <label>nom</label>
                <input type="text" name="nom" size="80" value="" /><br />
                <label>ville</label>
                <select name="ville_id">
                    <option value="">---</option>       <!-- si l'auteur n'est pas lié à une ville -->
                    <?php
                        $sql = 'SELECT * FROM tp_villes';
                        // TODO :
                        // - faire la requête SQL
                        // - créer les éléments de la liste déroulante
                    ?>
                </select>
            </p>
            <p><input type="submit" value="Envoyer" /></p>
        </form>
        
        <?php
            // TODO :
            // si on reçoit le formulaire
            // - $sql = 'INSERT INTO tp_auteurs (nom, ville_id)' .
            //          ' VALUES (\'' . /* nom auteur */ . '\', ' .
            //          /* id ville */ . ')';
            //   (gérer le cas où il n'y a pas de ville)
            // - faire la requête
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

