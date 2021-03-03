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

        <h1>exo 3.4, insertion d'un auteur</h1>
        
        <h2>Saisissez votre auteur</h2>

        <form action="insert_auteur.php" method="post">
            <p>
                <input type ="hidden" name="operation" value="insert_auteur" />
                <label>id</label>
                <input type="text" size="80" readonly="readonly"
                    value="== auto-increment ==" /><br />
                <label>nom</label>
                <input type="text" name="nom" size="80" value="" /><br />
                <label>ville</label>
                <select name="ville_id">
                    <option value="">---</option>       <!-- si l'auteur n'est pas lié à une ville -->
                    <?php
                        $sql = 'SELECT * FROM tp_villes';
                        $result = bd_requete($sql, true);
                        while ($ligne = $result->fetch(PDO::FETCH_ASSOC))
                            echo '<option value="' . $ligne['id']  .'">' . $ligne['nom'] .'</option>';
                        $result->closeCursor();
                    ?>
                </select>
            </p>
            <p><input type="submit" value="Envoyer" /></p>
        </form>
        
        <?php
            if (isset($_POST['operation']) && ($_POST['operation'] == "insert_auteur"))
            {
                if (   (! isset($_POST['nom'])) || (! isset($_POST['ville_id'])))
                    echo '<p>Il manque des valeurs</p>';
                elseif (empty($_POST['nom']))
                    echo '<p>Le nom est vide</p>';
                else
                {
                    $ville_id = 'NULL';
                    if (is_numeric($_POST['ville_id']))
                        $ville_id = $_POST['ville_id'];
                    $sql = 'INSERT INTO tp_auteurs (nom, ville_id)' .
                           ' VALUES (\'' . $_POST['nom'] . '\', ' .
                           $ville_id . ')';
                   $result = bd_requete($sql, true);
                   if ($result)
                   {
                        echo '<p>Insertion réussie !</p>';
                        $result->closeCursor();
                   }
                   else
                        echo '<p>Insertion échouée !!!</p>';
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

