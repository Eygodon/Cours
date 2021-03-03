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

        <h1>exo 3.1, affichage des auteurs</h1>

        <?php
            $sql = 'SELECT tp_auteurs.*, tp_villes.nom AS ville_nom FROM tp_auteurs, tp_villes ' .
                   'WHERE ville_id = tp_villes.id;';
            $result = bd_requete($sql, true);
            echo '<p>Nombre de réponses : ' . $result->rowCount() . '</p>';
            echo '<table>';
            echo '<tr><td colspan="4">les auteurs non reliés à une ville ne sont pas affichés (cf. LEFT JOIN)</td></tr>';
            echo '<tr><th> id </th><th> nom </th><th> id_ville </th><th>villes->nom</th></tr>';
            while ($ligne = $result->fetch(PDO::FETCH_ASSOC))
            {
                echo '<tr>';
                // souci car deux colonnes s'appellent a priori pareil (nom), on note
                // l'utilisation d'un alias dans la requête SQL pour lever l'ambiguïté
                echo '   <td>' . $ligne['id'] . '</td>';
                echo '   <td>' . $ligne['nom'] . '</td>';
                echo '   <td>' . $ligne['ville_id'] . '</td>';
                echo '   <td>' . $ligne['ville_nom'] . '</td>';
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

