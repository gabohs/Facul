<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
      <!-- Bootstrap CSS v5.2.1 -->
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
        crossorigin="anonymous" 
    />
    <!--  jQuery  -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>


    <script type='text/javascript' src='js/cadastro.js'></script>
    <link rel='stylesheet' href="css/estilo.css">

    <title>Atualizacao de Clientes </title>

</head>

<body>
    <?php 
        try
        {
            require 'conexao.php';

            $codigo = $_GET['codigo'];

            $sql = "SELECT * FROM cliente WHERE codigo = ?";
            $res = $con->execute_query($sql, [$codigo]);

            $row = $res->fetch_assoc();
        }
        catch (Exception $e)
        {
            echo "<h2 class='text-danger'>Erro</h2>";
            echo $e->getMessage();
        }
        finally
        {
            $con->close();
        }
    ?>

    <div class="container mt-5">
        <h1 class="text-center">Atualizacao de Clientes</h1>
        <form id='form1' method="GET" action='alterabd.php'>

            <input type="hidden" name="codigo" value="<?php echo $codigo ?>">

            <div class="form-group m-2">
                <label for="nm1">Nome completo</label>
                <input type="text" class="form-control" 
                    value="<?php echo $row['nome'];  ?>"
                    id="nm1" placeholder="Nome do cliente" name="nm">
            </div>


            <div class="form-group m-2">
                <label for="dt1">Data de Nascimento</label>
                <input type="date" class="form-control" 
                    value="<?php echo $row['dtnascto']; ?>"
                    id="dt1" name='dt'>
            </div>


            <div class="form-group m-2">
                <label for="email1">Email</label>
                <input type="email" class="form-control" 
                    value="<?php echo $row['email']; ?>"
                    id="email1" name='email' placeholder="name@example.com">
            </div>
            <div class="form-group m-2">
                <label for="cpf1">CPF</label>
                <input type="text" class="form-control" 
                    value="<?php echo $row['cpf']; ?>"
                    id="cpf1" name='cpf' placeholder="Digite o CPF">
            </div>


            <fieldset class="form-group m-2" id='grpsexo'>
                <legend>Gênero</legend>
                <div class="form-check m-2">
                    <input class="form-check-input" type="radio" name="sexo" id="sexof" 
                        value="F" <?php echo $row['sexo'] == 'F' ? 'checked' : ''; ?> >
                    <label class="form-check-label" for="sexof">Feminino</label>
                </div>
                <div class="form-check m-2">
                    <input class="form-check-input" type="radio" name="sexo" id="sexom" 
                        value="M" <?php echo $row['sexo'] == 'M' ? 'checked' : ''; ?> >
                    <label class="form-check-label" for="sexom">Masculino</label>
                </div>
                <div class="form-check m-2">
                    <input class="form-check-input" type="radio" name="sexo" id="sexoo" 
                        value="O" <?php echo $row['sexo'] == 'O' ? 'checked' : ''; ?> >
                    <label class="form-check-label" for="sexoo">Outro</label>
                </div>
            </fieldset>


            <input type='button' id='validar' value='Validar' class="btn btn-primary m-2">
            <input type='submit' id='salvar' name='Enviar' class="btn btn-primary m-2">
            <input type='reset' id='limpar' name='Limpar' class="btn btn-warning m-2" value='Limpar'>
        </form>


        <p id='msg'> </p>
    </div>
</body>
</html>
