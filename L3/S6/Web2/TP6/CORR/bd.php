<?php
    // peut-être plus adéquat de faire les déclarations dans bd_connexion (pour éviter les variables globales) ?
    $bd_host = 'localhost';
    $bd_login = 'cours_web';
    $bd_passwd = 'toto';
    $bd_base = 'cours_web2';
    
    // pour PDO : instance de la classe
    // Ce n'est pas élégant d'avoir une variable globale.
    // Il serait préférable que la fonction de connexion renvoie la variable
    // au script appelant. Cette variable serait alors passée en paramètre aux
    // autres fonctions.
    // Mais cette solution simplifie les scripts
    $bd_obj = null;

    // affichage d'une erreur
    function bd_erreur($msg)
    {
        echo '<h1>Erreur base de données</h1>';
        echo '<p>' . $msg . '</p>';
        exit(1);
    }

    // connexion à la BD, arrêt du script en cas d'erreur
    function bd_connexion()
    {
        global $bd_host, $bd_login, $bd_passwd, $bd_base, $bd_obj;
        try
        {
            $bd_obj = new PDO('mysql:host=' . $bd_host . ';dbname=' . $bd_base . ';charset=utf8', $bd_login, $bd_passwd);
        }
        catch (PDOException $e)
        {
            // ne jamais faire ces affichages en prod
            echo "Erreur : " . $e->getMessage() . "\n";
            print_r($e);
            exit();
        }
    }

    // déconnexion 
    function bd_deconnexion()
    {
        global $bd_obj;
        $bd_obj = null;
    }

    // fonction envoyant la requête au serveur de base de données
    // En cas d'erreur, la fonction ne s'arrête que si l'appelant l'autorise
    // via le second paramètre
    // le premier paramètre est la chaîne de caractères contenant la requête SQL
    function bd_requete($requete, $stopOnError = false)
    {
        global $bd_obj;
        $result = $bd_obj->query($requete);
        
        // On ne peut pas arrêter d'office le programme s'il y a une erreur.
        // L'appelant pourrait vouloir la traiter (par exemple s'il y a une
        // violation d'une contrainte d'intégrité).
        if ($stopOnError)
        {
            if (! $result)
                bd_erreur('erreur requête "' . $requete . '"');
        }

        return $result;
    }

