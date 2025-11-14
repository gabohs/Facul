<!doctype html>
<html lang="en">
    <head>
        <title>PHP Aula 2 - 06/11/2025</title>
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
        
        <div class="text-center m-5">
            <h1>PHP e MySQL</h1>
        </div>
        

        <div class="container">

            <a href="cadcli.html" target="_blank">
                <button type="button" class="btn btn-primary mb-2">
                    Inserir Cliente
                </button>
            </a>
            

            <?php
                require 'conexao.php';

                try
                {
                    $sql = "SELECT * FROM cliente";
                    $res = $con->execute_query($sql);

                    echo "<table class='table table-striped'>";

                    echo "<thead class='thead-dark'> <tr> <th>ID</th>    <th>NOME</th>    <th>EMAIL</th>    <th>OPERACAO</th> </tr></thead>";

                    while ($row = $res->fetch_assoc()) // fetch_row() retorna um array indexável, fetch_assoc retorna um associativo()
                    {
                        echo '<tr>';

                        echo '<td>'.$row['codigo'].'</td>';
                        echo '<td>'.$row['nome'].'</td>';
                        echo '<td>'.$row['email'].'</td>';

                        echo "<td> <button class='btn btn-primary mx-2'>Editar</button>";
                        echo "<button class='btn btn-danger mx-2'>Excluir</button> </td>";
                        
                        echo '</tr>';
                    }

                    echo '</table>';
                }
                catch (Exception $e)
                {
                    echo '<p> [ERRO]: '.$e->getMessage()().'</;>';
                }
                finally
                {
                    $con->close();
                }

            ?>
        </div>


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
