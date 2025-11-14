<!doctype html>
<html lang="en">
    <head>
        <title>PHP aula 1</title>
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
        
        <h1>Intro PHP</h1>
        <hr>

        <script>
            document.write("<h4>Hello World JS!</h4>")
        </script>

        <?php
            echo "<h4>Hello, World PHP!</h4>";

            $nome = 'Ernani';
            echo "<p> Nome: ".$nome."</p>";

            $valor = 10.5;
            $cars = ['Monza'];
            $cars[1] = 'Fusca';
            $cars[2] = 'Gol';
            $cars[3] = 'Uno';

            sort($cars);

            echo sprintf("Length do array: %d", count($cars));
            // var_dump($cars)

            echo "<h5>Elementos do array:</h5>";

            echo "<p>Com for normal:</p>";

            for ($i = 0; $i < count($cars); $i++)
            {
                echo '<li>'.$cars[$i]."</li>";
            }

            echo '<br>';
            echo "<p>Com foreach (e tabela):</p>";

            echo "<table class='table table-dark'>";

            foreach ($cars as $car)
            {   
                echo '<tr>';
                echo '<td>'.$car.'</td>';
                echo '<tr>';
            }

            echo '</table>';

            // -----------------------------------------------------------
            echo "<hr>";

            $email = 'manumanusi2014@gmail.com';

            echo "<h4>Email: ".$email."</h4>";

            $pos = strpos($email, '@');
            if (!$pos)
                echo "<p> Email invalido";
            else
            {
                echo "<p>Posicao do @: ".$pos."</p>";

                $user = substr($email, 0, $pos);
                echo "<p>Username: ".$user."</p>";

                $server = substr($email, ($pos + 1));
                echo "<p>Servidor: ".$server."</p>";
            }

            date_default_timezone_set('America/Sao_Paulo');

            echo "<p>Data de hoje: ".date('d/m/y H:i:s')."</p>";
            echo "<p>Dia da semana: ".date('w')."</p>";

            $hj = date_create();
            echo "<p>Data formatada: ".date_format($hj, 'd/m').'</p>';

            $dtvenc = date_create_from_format('d/m/Y', '15/11/2025');
            $diff = date_diff($hj, $dtvenc);

            echo "<p>Nr de dias para vencer o boleto: ".$diff->format('%a')."</p>";  
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
