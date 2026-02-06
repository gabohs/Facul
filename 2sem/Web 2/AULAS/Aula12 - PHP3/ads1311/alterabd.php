<!doctype html>
<html lang="en">
    <head>
        <title>Altera banco de dados</title>
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

        <div class="container">
            
            <h1>Alteracao de Cliente</h1>

            <?php 
                try
                {
                    require 'conexao.php';

                    $nome  = $_GET['nm'];   
                    $nasc  = $_GET['dt'];
                    $email = $_GET['email'];
                    $cpf   = $_GET['cpf'];
                    $sexo  = $_GET['sexo'];

                    $codigo = $_GET['codigo'];

                    $sql = "UPDATE cliente SET nome=?, cpf=?, email=?, dtnascto=?, sexo=? WHERE codigo=?";

                    $res = $con->execute_query($sql, [$nome, $cpf, $email, $nasc, $sexo, $codigo]);

                    echo "<div class='alert alert-success' role='alert'>Cliente atualizado com Sucesso !!</div>";

                }
                catch (Exception $e)
                {
                    echo "<h2 class='text-danger'>Erro na atualizacao do cliente</h2>";
                    echo $e->getMessage();
                }
                finally
                {
                    $con->close();
                }

            ?>
            
            <a href="index.php">
                <button type="button" class="btn btn-primary">
                    Voltar
                </button>
            </a>

            
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
