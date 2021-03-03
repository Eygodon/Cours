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

        <h1>exo 3.5, suppression d'un auteur</h1>
        
        <h2>Choisissez votre auteur</h2>

        <?php
            // attention, le formulaire se fabrique avant (peut-être) un effacement
            // dans la seconde partie du script, et donc la liste déroulante
            // va peut-être contenir une entrée de trop
        ?>
        <form action="efface_auteur.php" method="post">
            <p>
                Si vous venez de demander la suppression d'un auteur, il
                apparait tout de même (à traiter normalement bien sûr)<br />
                <input type ="hidden" name="operation" value="suppr_auteur" />
                <label>Choix de l'auteur</label>
                <select name="id" size="1">
                    <?php
                        $sql = 'SELECT id, nom FROM tp_auteurs';
                        $result = bd_requete($sql, true);
                        while ($ligne = $result->fetch(PDO::FETCH_ASSOC))
                            echo '<option value="' . $ligne['id'] . '">' . $ligne['nom']. '</option>';
                        $result->closeCursor();
                    ?>
                </select>
            </p>
            <p><input type="submit" value="Valider" /></p>
        </form>

        <?php
            if (isset($_POST['operation']) && ($_POST['operation'] == "suppr_auteur"))
            {
                echo '<h2> Résultat de la suppression </h2>';
                if (! isset($_POST['id']))
                    echo '<p>Impossible de déterminer qui doit être supprimé !</p>';
                else
                {
                    $sql = 'SELECT * FROM tp_auteurs WHERE id = ' . $_POST['id'];
                    $result = bd_requete($sql, true);
                    if ($result->rowCount() != 1)
                    {
                        echo '<p>L\'auteur n\'existe pas !</p>';
                        $result->closeCursor();
                    }
                    else
                    {
                        $result->closeCursor();
                        /*
                         * une vérification manuelle, mais on peut ne pas la faire et regarder
                         * si le DELETE échoue, ce qui signifie certainement qu'une contrainte
                         * d'intégrité est violée.
                         * L'avantage de ne pas faire de vérification manuelle est double
                         * - plus simple puisqu'il n'y a rien à faire
                         * - si de nouvelles tables sont rajoutées, il n'y a aucun code à compléter
                         * L'inconvénient est qu'il est choquant de lancer une requête qui se
                         * solde par une erreur.
                         */
                        $sql = 'SELECT id FROM tp_articles WHERE auteur_id = ' . $_POST['id'];
                        $result = bd_requete($sql, true);
                        if ($result->rowCount() > 0)
                            echo '<p>L\'auteur possède au moins un article, la suppression va échouer</p>';
                        $result->closeCursor();

                        $sql = 'DELETE FROM tp_auteurs WHERE id = ' . $_POST['id'];
                        $result = bd_requete($sql, false);
                        if ($result)
                        {
                            echo '<p>La suppression a réussi !</p>';
                            $result->closeCursor();
                        }
                        else
                            echo '<p>La suppression a échoué !!!</p>';
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

