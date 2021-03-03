<?php
    session_start();
    include_once('auth.php');
    include_once('bd.php');
    bd_connexion();
    
    $erreurConnexion = false;
    if (isset($_POST['login']) && isset($_POST['passwd']))
    {
        if(($_POST['login'] === 'toto') && ($_POST['passwd'] === 'titi'))
            setAuthticate();
        else
            $erreurConnexion = true;
    }
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
            if ($erreurConnexion)
                echo '<p>Echec authentification</p>';
        ?>
        
        <?php
            if (isAuthenticate())
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
                    <li><a href="deconnexion.php">Déconnexion</a></li>
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

