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
                    if (! isset($_POST['passwd']))
                        $val = '(absent)';
                    elseif ($_POST['passwd'] == "")
                        $val = "(empty)";
                    else
                        $val = hash("md5", $_POST['passwd'], false);
                    echo '<td>' . $val . '</td>';
                    echo '</tr>';
                
                    // l'état civil
                    echo '<tr>';
                    echo '<td>radio1</td>';
                    if (! isset($_POST['radio1']))
                        $val = '(absent)';
                    elseif ($_POST['radio1'] == "")
                        $val = '(empty)';
                    else
                        $val = $_POST['radio1'];
                    echo '<td>' . $val . '</td>';
                    echo '</tr>';

                    // les centres d'intérêt
                    echo '<tr>';
                    echo '<td>cb1</td>';
                    if (! isset($_POST['cb1']))
                        $val = '(absent)';
                    elseif (count($_POST['cb1']) == 0)
                        $val = '(empty)';
                    else
                    {
                        $val ="";
                        for ($i = 0; $i < count($_POST['cb1']); $i++)
                            $val .= $_POST['cb1'][$i].'<br/>';
                    }
                    echo '<td>' . $val . '</td>';
                    echo '</tr>';
                
                    // le pays
                    echo '<tr>';
                    echo '<td>liste2</td>';
                    if (! isset($_POST['liste2']))
                        $val = '(absent)';
                    elseif ($_POST['liste2'] == "")
                        $val = '(empty)';
                    else
                        $val = $_POST['liste2'];
                    echo '<td>' . $val . '</td>';
                    echo '</tr>';

                    // centres d'intérêt (bis repetita)
                    echo '<tr>';
                    echo '<td>liste4</td>';
                    if (! isset($_POST['liste4']))
                        $val = '(absent)';
                    elseif (count($_POST['liste4']) == 0)
                        $val = '(empty)';
                    else
                    {
                        $val ="";
                        for ($i = 0; $i < count($_POST['liste4']); $i++)
                            $val .= $_POST['liste4'][$i].'<br/>';
                    }
                    echo '<td>' . $val . '</td>';
                    echo '</tr>';
                
                    // la taille maximale
                    echo '<tr>';
                    echo '<td>MAX_FILE_SIZE</td>';
                    if (! isset($_POST['MAX_FILE_SIZE']))
                        $val = '(absent)';
                    elseif ($_POST['MAX_FILE_SIZE'] == "")
                        $val = '(empty)';
                    else
                        $val = $_POST['MAX_FILE_SIZE'];
                    echo '<td>' . $val . '</td>';
                    echo '</tr>';
                
                    // le fichier reçu
                    echo '<tr>';
                    echo '<td>fichier</td>';
                    if (! isset($_POST['fichier']))
                        $val = '(absent)';
                    else
                    {
                        $val ='';
                        $val .= '<table>';
                        $val .= '<td><td>name</td> <td>=</td><td></td>'. $_FILES['fichier']['name']. '</td></tr>';
                        $val .= '<td><td>type</td> <td>=</td><td></td>'. $_FILES['fichier']['type']. '</td></tr>';
                        $val .= '<td><td>tmp_name</td> <td>=</td><td></td>'. $_FILES['fichier']['tmp_name']. '</td></tr>';
                        $val .= '<td><td>error</td> <td>=</td><td></td>'. $_FILES['fichier']['error']. '</td></tr>';
                        $val .= '<td><td>size</td> <td>=</td><td></td>'. $_FILES['fichier']['size']. '</td></tr>';
                        $val .= '</table>';
                    }
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
