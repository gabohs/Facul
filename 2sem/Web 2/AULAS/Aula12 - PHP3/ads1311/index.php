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

        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    </head>

    <body>
        
        <div class="text-center m-5">
            <h1>PHP e MySQL</h1>
        </div>
        

        <div class="container">

            <div class="justify-content-between mb-4">

                <div class="btnInserir">
                    <a href="cadcli.html" target="_blank">
                        <button type="button" class="btn btn-primary mb-2">
                            Inserir Cliente
                        </button>
                    </a>
                </div>

                <div class="filtro">
                    <form method="GET" action="#" class="mb-3">
                        <div class="d-flex justify-content-left">
                            <div class="">
                                <input type="text" class="form-control" name="nm" id="nm1" placeholder="Nome"/>
                            </div>

                            <button type="submit" class="btn btn-primary mx-2">
                                Filtrar
                            </button>
                        </div>
                    
                    </form>
                </div>

            </div>

            <?php
                require 'conexao.php';

                try
                {   
                    if (isset($_GET['nm']))
                        $nome = $_GET['nm'];
                    else
                        $nome = '';
                    
                    $sql = "SELECT * FROM cliente WHERE nome LIKE ?";
                    $res = $con->execute_query($sql, ['%'.$nome.'%']);

                    echo "<table class='table table-striped'>";

                    echo "<thead class='thead-dark'> <tr> <th>ID</th>    <th>NOME</th>    <th>EMAIL</th>    <th>OPERACAO</th> </tr></thead>";

                    while ($row = $res->fetch_assoc()) // fetch_row() retorna um array indexável, fetch_assoc retorna um associativo()
                    {    
                        echo '<tr>';

                        echo '<td>'.$row['codigo'].'</td>';
                        echo '<td>'.$row['nome'].'</td>';
                        echo '<td>'.$row['email'].'</td>';

                        echo "<td> <a class=edt href=alteraform.php?codigo=".$row['codigo']."><button class='btn btn-primary mx-2'>Editar</button> </a>";
                        echo "<a class=exc href=exclui.php?codigo=".$row['codigo']."><button class='btn btn-danger mx-2'>Excluir</button></a></td>";
                        
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

        <script>
            $('.exc').click(function(e)
            {
                let conf= confirm('Confirma a exclusão deste cliente?');
                if(!conf)
                    e.preventDefault();
            }); 
        </script>


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
