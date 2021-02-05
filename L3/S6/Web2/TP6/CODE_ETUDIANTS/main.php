<?php
    // TODO : il y a quelque chose à faire ici, en premier, pour la gestion de l'authentification
    include_once('auth.php');
    include_once('bd.php');
    // TODO :
    // - connexion au serveur de bases de données
    bd_connexion();
    
    // TODO :
    // si on reçoit le formulaire de connexion
    // - si login et mot de passe corrects, mettre l'internaute dans l'état authentifié
?>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP 6</title>
        <link rel="stylesheet" media="all" type="text/css" title="Mon Style" href="style.css" />
    </head>
    <body>
        <?php
            // TODO : 
            if (/* formulaire reçu mais login incorrect */)
                echo '<p>Echec authentification</p>';
        ?>
        
        <?php
            if (/* l'internaute est authentifié */)
            {
        ?>
                <h1>exo 3.6; menu</h1>

                <ul>
                    <li><a href="aff_villes.php">Afficher les villes</a></li>
                    <li><a href="aff_auteurs.php">Afficher les auteurs</a></li>
                    <li><a href="aff_articles.php">Afficher les articles</a></li>
                    <li><a href="aff_habitants.php">Afficher les habitants d'une ville</a></li>
                    <li><a href="modif_article.php">Modifier un article</a></li>
                    <li><a href="insert_auteur.php">Ajouter un auteur</a></li>
                    <li><a href="efface_auteur.php">Supprimer un auteur</a></li>
                    <li><!-- TODO : lien de déconnexion--></li>
                </ul>
        <?php
            }
            else
            {
        ?>
        
                <h1>exo 3.6; authentification</h1>
        
                <form action="main.php" method="post">
                <p>
                    <label>login</label>
                    <input type="text" size="80" name="login" placeholder="login" /><br />
                    <label>mot de passe</label>
                    <input type="password" name="passwd" size="80" placeholder="mot de passe" /><br />
                </p>
                <p><input type="submit" value="Envoyer" /></p>
            </form>

        <?php
            }
        ?>

        <h2>POST</h2>
        <?php
            echo '<pre>';
            echo htmlspecialchars(print_r($_POST, true));
            echo '</pre>';
        ?>

        <h2>SESSION</h2>
        <?php
            echo '<pre>';
            echo htmlspecialchars(print_r($_SESSION, true));
            echo '</pre>';
        ?>

    </body>
</html>
<?php
    bd_deconnexion();
?>

