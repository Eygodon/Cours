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

        <h1>exo 3.4, modification d'un article</h1>
        
        <?php
        /*--------------------------------------------------------------------*
         * choix de l'article à modifier
         *--------------------------------------------------------------------*/
        ?>
        <h2>Choix de l'article</h2>

        <form action="modif_article.php" method="post">
            <p>
            <label>Choix de l'article</label>
            <select name="id" size="1">
                <?php
                    $sql = 'SELECT id, titre FROM tp_articles';
                    // TODO :
                    // - faire la requête SQL
                    // - créer les éléments de la liste déroulante
                ?>
            </select>
            </p>

            <p><input type="submit" value="Valider" /></p>
        </form>
        
        <?php
            /*--------------------------------------------------------------------*
             * réception du formulaire "choix de l'article"
             *--------------------------------------------------------------------*/
            if (/* TODO : on reçoit le premier formulaire */)
            {
                echo '<h2> Modifiez votre article </h2>';
                // notons la faille de sécurité : il peut y avoir n'importe quoi dans la saisie de l'utilisateur
                $sql = 'SELECT * FROM tp_articles WHERE id = ' . /* id article */;
                // TODO : faire la requête
                echo '<form action="modif_article.php" method="post">';
                echo '<p>';
                echo '   <input type="hidden" name="operation" value="modif article" />';
                echo '   <label>id</label> ';
                echo '   <input type="text" name="id" size="80" readonly="readonly" ' .
                     '          value="' . /* TODO : id article */ . '" /><br />';
                // il faudrait une liste déroulante avec pré-sélection
                echo '   <label>id_auteur</label> ';
                echo '   <input type="text" name="id_auteur" ' .
                     '          value="' . /* TODO : id auteur */ . '" /><br />';
                echo '   <label>titre</label> ';
                echo '   <input type="text" name="titre" value="' . /* TODO : titre article */ . '" /><br />';
                echo '   <label>contenu</label> ';
                echo '   <textarea name="contenu" rows="5" cols="80">' . /* TODO : contenu article */ .
                        '</textarea><br />';
                echo '   <label>date</label> ';
                echo '   <input type="text" name="date" value="' . /* TODO : date */ . '" /><br />';
                echo '   <input type="submit" value="Envoyer" />';
                echo '</p>';
                echo '</form>';
            }

            /*--------------------------------------------------------------------*
             * réception du formulaire "modification de l'article"
             *--------------------------------------------------------------------*/
            elseif (/* TODO : on reçoit le second formulaire */)
            {
                $sql = 'UPDATE tp_articles SET '
                                    . 'auteur_id = \'' . addslashes(/* TODO : id auteur */) . '\', '
                                    . 'titre     = \'' . addslashes(/* TODO : titre article */) . '\', '
                                    . 'contenu   = \'' . addslashes(/* TODO : contenu article */) . '\', '
                                    . 'date      = \'' . addslashes(/* TODO : date */) . '\' '
                                . 'WHERE tp_articles.id = ' . /* TODO : id article */;
                // TODO : faire la requête
            }
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

