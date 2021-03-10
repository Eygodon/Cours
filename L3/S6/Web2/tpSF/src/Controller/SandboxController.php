<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class SandboxController extends AbstractController
{
    /**
     * @Route("/sandbox", name="sandbox")
     */

    public function indexAction(): Response
    {
        return new Response('<body>Hello World!</body>');
    }

    /**
     * @Route("/sandbox/hello2", name="sandbox_hello2")
     */
    public function hello2Action() : Response
    {
        return $this->render('Sandbox/hello2.html.twig');
    }

    /**
     * @Route("/sandbox/hello3", name="sandbox_hello3")
     */
    public function hello3Action() : Response
    {
        $args = array(
            'prenom' => 'Ezio',
            'jeux' => array('AC II', 'AC REVELATION', 'AC Brotherhood')
        );

        return $this->render('Sandbox/hello3.html.twig', $args);
    }
}
