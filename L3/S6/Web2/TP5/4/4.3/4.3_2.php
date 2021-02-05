<?php
    // pas de session_start dans cet exercice
    // Attention : la création de cookie doit se faire ici et surtout ne pas mettre
    // le moindre espace avant la balise php
    // Remarque : c'était vrai à une certaine époque et maintenant c'est plus permissif ;
    //            cependant la règle est de faire la modification des cookies avant
    //            l'envoi de l'entête (bref avant le doctype)

    ini_set("display_errors", "on");
    ini_set("expose_php", "on");
    ini_set("error_reporting", E_ALL);

    $valActionOk = true;
    $valActionMsg = "";
    $actionOk = false;
    $actionMsg = "";

    if (isset($_GET["action"]) && is_numeric($_GET["action"])&& 0 < $_GET["action"] && $_GET["action"] < 6)
    {
        switch ($_GET["action"]) {
            case 1 :
                if (isset($_COOKIE["compteur"]))
                    $actionOk = setcookie("compteur", $_COOKIE["compteur"] + 1, time() + 3600 * 24);
                else
                    $actionOk = setcookie("compteur", $_COOKIE["compteur"] = 0, time() + 3600 * 24);
                if (! $actionOk)
                    $actionMsg = "set cookie compteur";
                break;
            case 2 :
                $actionOk1 = setcookie("nombres[un]", "one", 0);
                $actionOk2 = setcookie("nombres[deux]", "two", 0);
                $actionOk3 = setcookie("nombres[trois]", "three", 0);
                $actionOk = $actionOk1 && $actionOk2 && $actionOk3;
                if (! $actionOk)
                    $actionMsg = 'set cookie nombres';
                break;
            case 3 :
                break;
            case 4 :
                $actionOk = setcookie("compteur", "", 1);
                if (! $actionOk)
                    $actionMsg = "detruit cookie compteur";
                break;
            case 5 :
                if (! isset($_COOKIE["nombres"]))
                {
                    $actionOk = false;
                    $actionMsg = "cookie(s) nombres inexistant(s)";
                }
                else
                {
                    $actionOk = true;
                    foreach ($_COOKIE["nombres"] as $cle => $val)
                    {
                        $ok = setcookie("nombres [".$cle."]", "", 1);
                        $actionOk = $actionOk && $ok;
                    }
                    if (! $actionOk)
                        $actionMsg = "detruit cookie(s) nombre(s)";
                }
                break;
            default :
                $numActionOk = false;
                $numActionMsg = "<p>Le numéro d\'action n\'est pas un entier correct, voire pas un entier du tout</p>";
        }
    }
?>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP 5</title>
    </head>
    <body>

        <h1>exo 4.3, deuxième page</h1>

        <p>
            <a href="4.3_1.php">cliquer ici</a> pour revenir à la première page.
        </p>

        <h2>Actions</h2>

        <?php
            function afficheCookies()
            {
                echo "<p>";
                if (! isset($_COOKIE))
                    echo "$_COOKIE n\'existe pas.<br/>";
                else
                    {
                        if (isset($_COOKIE["compteur"]))
                            echo'$_COOKIE[\"compteur\"] vaut'. $_COOKIE["compteur"]. "<br/>";
                        else
                            echo '$_COOKIE[\'compteur\'] n\'existe pas.<br />';
                        if (isset($_COOKIE['nombres']))
                        {
                            echo 'Affichage de $_Cookie[nombres]<br />';
                            foreach ($_COOKIE['nombres'] as $cle => $val)
                                echo '&nbsp;&nbsp;$_COOKIE[\'nombres\']['. $cle. '] vaut :'. $_COOKIE['nombres'][$cle].'<br/>';
                        }
                        else
                            echo '$_COOKIE[nombres] n\'existe pas.<br/>';
                    }
                echo '</p>';
            }
            if (! $valActionOk)
            {
                echo $valActionMsg;
                exit("");
            }

            switch($_GET['action'])
            {
                case 1:
                    if (! $actionOk)
                        echo '<p> L\'action 1 a échouée </p>';
                    break;
                case 2:
                    if (! $actionOk)
                        echo '<p> L\'action 2 a échouée </p>';
                    break;
                case 3:
                    afficheCookies();
                    break;
                case 4:
                    if (! $actionOk)
                        echo '<p> L\'action 4 a échouée </p>';
                    break;
                case 5:
                    if (! $actionOk)
                        echo '<p> L\'action 5 a échouée </p>';
                    break;
                default:
                    // déjà traité en début de fichier
            }
        ?>

        <h2>COOKIE</h2>
        <?php
            echo '<pre>';
            echo htmlspecialchars(print_r($_COOKIE, true));
            echo '</pre>';
        ?>

    </body>
</html>
