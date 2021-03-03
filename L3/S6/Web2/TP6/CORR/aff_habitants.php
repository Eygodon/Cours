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

        <h1>exo 3.2, affichage des habitants</h1>
        
        <h2>Choix de la ville</h2>

        <form method="post" action="aff_habitants.php">
            <p>
                Quelle ville :
                <select name="ville">
                    <?php
                        $sql = 'SELECT * FROM tp_villes';
                        $result = bd_requete($sql, true);
                        while ($ligne = $result->fetch(PDO::FETCH_ASSOC))
                            echo '<option value="' . $ligne['id']  .'">' . $ligne['nom'] .'</option>';
                        $result->closeCursor();
                    ?>
                </select>
                <input type="submit" value="go"/>
            </p>
        </form>


        <h2>Liste des habitants</h2>
        
        <?php
            if (! isset($_POST['ville']))
                echo '<p>Choisissez une ville</p>';
            elseif ((! is_numeric($_POST['ville'])) || (! is_int(0+$_POST['ville'])))
                echo '<p>Impossible de traiter le formulaire</p>';
            else
            {
                // attention aux injections (todo)
                $sql = 'SELECT tp_villes.nom FROM tp_villes WHERE tp_villes.id =' . $_POST['ville'] . ';';
                $result = bd_requete($sql, true);
                if ($result->rowCount() != 1)
                    echo '<p>Ville inconnue</p>';
                else
                {
                    $ligne = $result->fetch(PDO::FETCH_ASSOC);
                    $ville = $ligne['nom'];

                    $sql = 'SELECT tp_auteurs.nom FROM tp_auteurs WHERE tp_auteurs.ville_id =' . $_POST['ville'] . ';';
                    $result = bd_requete($sql, true);
                    echo '<p>Nombre d\'habitants : ' . $result->rowCount() . ' dans ' . $ville . '</p>';
                    echo '<ul>';
                    while ($ligne = $result->fetch(PDO::FETCH_ASSOC))
                    {
                        echo '   <li>' . $ligne['nom'] . '</li>';
                    }
                    echo '</ul>';
                }
                $result->closeCursor();
            }
        ?>

    </body>
</html>
<?php
    bd_deconnexion();
?>

