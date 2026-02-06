<?php
    try
    {
        $con = new mysqli("localhost", "root", "", "teste_php");
    }
    catch (Exception $e)
    {
        echo "Erro na conexão: ".$e->getMessage();
    }
    
    mysqli_set_charset($con, "utf8");

?>  