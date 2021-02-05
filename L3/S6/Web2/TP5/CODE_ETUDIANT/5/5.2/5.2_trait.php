<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP 5</title>
    </head>
    <body>

        <h1>exo 5.2, réception formulaire</h1>

        <table border="3">
            <caption>Contenu du formulaire</caption>

            <thead>
                <tr>
                    <th>champs</th>
                    <th>valeur</th>
                </tr>
            </thead>

            <tbody>
                <?php
                    // le nom
                    echo '<tr>';
                    echo '<td>nom</td>';
                    // TODO : le code est ici fourni pour servir d'exemple
                    if (! isset($_POST['nom']))
                        $val = '(absent)';
                    elseif ($_POST['nom'] == '')
                        $val = '(empty)';
                    else
                        $val = $_POST['nom'];
                    echo '<td>' . $val . '</td>';
                    echo '</tr>';

                    // le mot de passe
                    echo '<tr>';
                    echo '<td>password</td>';
                    // TODO : gérer le champ 'passwd'
                    $val = '???';
                    echo '<td>' . $val . '</td>';
                    echo '</tr>';
                
                    // l'état civil
                    echo '<tr>';
                    echo '<td>radio1</td>';
                    // TODO : gérer le champ 'radio1'
                    $val = '???';
                    echo '<td>' . $val . '</td>';
                    echo '</tr>';

                    // les centres d'intérêt
                    echo '<tr>';
                    echo '<td>cb1</td>';
                    // TODO : gérer le champ 'cb1'
                    //        attention c'est un tableau
                    $val = '???';
                    echo '<td>' . $val . '</td>';
                    echo '</tr>';
                
                    // le pays
                    echo '<tr>';
                    echo '<td>liste2</td>';
                    // TODO : gérer le champ 'liste2'
                    $val = '???';
                    echo '<td>' . $val . '</td>';
                    echo '</tr>';

                    // centres d'intérêt (bis repetita)
                    echo '<tr>';
                    echo '<td>liste4</td>';
                    // TODO : gérer le champ 'liste4'
                    //        attention c'est un tableau
                    $val = '???';
                    echo '<td>' . $val . '</td>';
                    echo '</tr>';
                
                    // la taille maximale
                    echo '<tr>';
                    echo '<td>MAX_FILE_SIZE</td>';
                    // TODO : gérer le champ 'MAX_FILE_SIZE'
                    $val = '???';
                   echo '<td>' . $val . '</td>';
                    echo '</tr>';
                
                    // le fichier reçu
                    echo '<tr>';
                    echo '<td>fichier</td>';
                    // TODO : gérer la variable $_FILES
                    //        c'est un tableau à 5 cases avec des noms précis
                    //        attention le tableau a pu ne pas être envoyé
                    $val = '???';
                    echo '<td>' . $val . '</td>';
                    echo '</tr>';

                ?>
            </tbody>
        </table>


        <h2>GET</h2>
        <?php
            echo '<pre>';
            echo htmlspecialchars(print_r($_GET, true));
            echo '</pre>';
        ?>

        <h2>POST</h2>
        <?php
            echo '<pre>';
            echo htmlspecialchars(print_r($_POST, true));
            echo '</pre>';
        ?>

        <h2>FILES</h2>
        <?php
            echo '<pre>';
            echo htmlspecialchars(print_r($_FILES, true));
            echo '</pre>';
        ?>

   </body>
</html>
