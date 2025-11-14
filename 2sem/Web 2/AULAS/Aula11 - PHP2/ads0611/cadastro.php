<!doctype html>
<html lang="en">
    <head>
        <title>Cadastro</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
        />

        <!-- Bootstrap CSS v5.2.1 -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
        />
    </head>

    <body>
        
        <h1>Cadastro de Clientes</h1>

        <?php
            function converteData($data)
            {
                $ano = substr($data, 0, 4);
                $mes = substr($data, 5, 2);
                $dia = substr($data, 8, 2);

                return $dia.'/'.$mes.'/'.$ano;
            }

            $nome  = $_GET['nm'];   
            $nasc  = $_GET['dt'];
            $email = $_GET['email'];
            $cpf   = $_GET['cpf'];
            $sexo  = $_GET['sexo'];
            
            echo '<h4> Nome do cliente: '.$nome.'</h4>';
            echo '<h4> Data de nascimento: '.converteData($nasc).'</h4>';
            echo '<h4> Email: '.$email.'</h4>';
            echo '<h4> CPF: '.$cpf.'</h4>';
            echo '<h4> Sexo: '.$sexo.'</h4>';
        ?>


        <!-- Bootstrap JavaScript Libraries -->
        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"
        ></script>

        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
