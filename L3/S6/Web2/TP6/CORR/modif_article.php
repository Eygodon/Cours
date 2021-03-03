<?php
    session_start();
    include_once('auth.php');
    include_once('bd.php');
    exitIfNotAuthenticate();
    bd_connexion();
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
            <a href="deconnexion.php">Déconnexion</a>
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
            <input type ="hidden" name="operation" value="choix article" />
            <label>Choix de l'article</label>
            <select name="id" size="1">
                <?php
                    $sql = 'SELECT id, titre FROM tp_articles';
                    $result = bd_requete($sql, true);
                    while ($ligne = $result->fetch(PDO::FETCH_ASSOC))
                        echo '<option value="' . $ligne['id'] . '">' . $ligne['titre']. '</option>';
                    $result->closeCursor();
                ?>
            </select>
            </p>

            <p><input type="submit" value="Valider" /></p>
        </form>
        
        <?php
            /*--------------------------------------------------------------------*
             * réception du formulaire "choix de l'article"
             *--------------------------------------------------------------------*/
            if (isset($_POST['operation']) && ($_POST['operation'] === "choix article"))
            {
                echo '<h2> Modifiez votre article </h2>';
                // notons la faille de sécurité : il peut y avoir n'importe quoi dans $_POST['id']
                $sql = 'SELECT * FROM tp_articles WHERE id = ' . $_POST['id'];
                $result = bd_requete($sql, true);
                if ($result->rowCount() != 1)
                    echo '<p>L\'article n\'existe pas !</p>';
                else
                {
                    $ligne = $result->fetch(PDO::FETCH_ASSOC);
                    echo '<form action="modif_article.php" method="post">';
                    echo '<p>';
                    echo '   <input type="hidden" name="operation" value="modif article" />';
                    echo '   <label>id</label> ';
                    echo '   <input type="text" name="id" size="80" readonly="readonly" ' .
                         '          value="' . $ligne['id'] . '" /><br />';
                    // il faudrait une liste déroulante avec pré-sélection
                    echo '   <label>id_auteur</label> ';
                    echo '   <input type="text" name="id_auteur" ' .
                         '          value="' . $ligne['auteur_id'] . '" /><br />';
                    echo '   <label>titre</label> ';
                    echo '   <input type="text" name="titre" value="' . $ligne['titre'] . '" /><br />';
                    echo '   <label>contenu</label> ';
                    echo '   <textarea name="contenu" rows="5" cols="80">' . $ligne['contenu'] .
                            '</textarea><br />';
                    echo '   <label>date</label> ';
                    echo '   <input type="text" name="date" value="' . $ligne['date'] . '" /><br />';
                    echo '   <input type="submit" value="Envoyer" />';
                    echo '</p>';
                    echo '</form>';
                }
                $result->closeCursor();
            }

            /*--------------------------------------------------------------------*
             * réception du formulaire "modification de l'article"
             *--------------------------------------------------------------------*/
            elseif (isset($_POST['operation']) && ($_POST['operation'] == "modif article"))
            {
                if (! isset($_POST['id']))
                    echo '<p>Impossible de déterminer qui doit être modifié !</p>';
                elseif (   (! isset($_POST['id_auteur'])) || (! isset($_POST['titre']))
                        || (! isset($_POST['contenu'])) || (! isset($_POST['date'])))
                    echo '<p>Il manque des valeurs</p>';
                else
                {
                    $sql = 'SELECT id FROM tp_articles WHERE id = ' . $_POST['id'];
                    $result = bd_requete($sql, true);
                    if ($result->rowCount() != 1)
                        echo '<p>Article inexistant !</p>';
                    else
                    {
                        $sql = 'UPDATE tp_articles SET '
                                            . 'auteur_id = \'' . addslashes($_POST['id_auteur']) . '\', '
                                            . 'titre     = \'' . addslashes($_POST['titre']) . '\', '
                                            . 'contenu   = \'' . addslashes($_POST['contenu']) . '\', '
                                            . 'date      = \'' . addslashes($_POST['date']) . '\' '
                                        . 'WHERE tp_articles.id = ' . $_POST['id'];
                        $result = bd_requete($sql, false);
                        if ($result)
                        {
                            echo '<p>La mise à jour a réussi !</p>';
                            $result->closeCursor();
                        }
                        else
                            echo '<p>La mise à jour a échoué !!!</p>';
                    }
                }
            }

            elseif (isset($_POST['operation']))
            {
                echo '<p>Opération inconnue !</p>';
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

