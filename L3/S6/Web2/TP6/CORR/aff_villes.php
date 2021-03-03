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

        <h1>exo 3.1, affichage des villes</h1>

        <?php
            $sql = 'SELECT * FROM tp_villes;';
            $result = bd_requete($sql, true);
            echo '<p>Nombre de réponses : ' . $result->rowCount() . '</p>';
            echo '<table>';
            echo '<tr><th>id</th><th>nom</th><th>code</th></tr>';
            while ($ligne = $result->fetch(PDO::FETCH_ASSOC))
            {
                echo '<tr>';
                // on pourrait faire une boucle ici (cf. aff_articles.php)
                // mais attention si plusieurs colonnes s'appellent pareil (cf. aff_auteurs.php)
                echo '   <td>' . $ligne['id'] . '</td>';
                echo '   <td>' . $ligne['nom'] . '</td>';
                echo '   <td>' . $ligne['code'] . '</td>';
                echo '</tr>';
            }
            echo '</table>';
            $result->closeCursor();
        ?>

    </body>
</html>
<?php
    bd_deconnexion();
?>

