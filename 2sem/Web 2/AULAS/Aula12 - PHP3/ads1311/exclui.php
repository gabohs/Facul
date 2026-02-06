<!doctype html>
<html lang="en">
    <head>
        <title>Excluir</title>
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
        <h1>Exlusão de cliente</h1>

        <?php 
            try
            {
                require 'conexao.php';

                $codigo = $_GET['codigo'];

                $sql = "DELETE FROM cliente WHERE codigo=?";

                $res = $con->execute_query($sql, [$codigo]);

                echo "<h2 class='text-success'>Cliente excluido com sucesso!</h2>";
            }
            catch (Exception $e)
            {
                echo "<h2 class='text-danger'>Erro ao excluir cliente</h2>";
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
