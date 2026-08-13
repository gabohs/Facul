package testebd;

import java.sql.*;
import javax.swing.JOptionPane;

public class TesteBD 
{
    public static void main(String[] args) 
    {
        //geraBD();
        criarTabela();
    }
    
    public static void geraBD()
    {
        final int PORTA = 3306;
        final String NOME_DB = "empresa_oop2";

        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:" + PORTA + "/";

        try 
        {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, "root", "123");
            
            Statement st = connection.createStatement();
            
            String sql = "CREATE DATABASE IF NOT EXISTS " + NOME_DB;
            st.executeUpdate(sql);
            
            
            JOptionPane.showMessageDialog(null, "BD criado com sucesso");

            connection.close();
        } 
        catch (ClassNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(null, "Driver JDBC nao encontrado!"); 
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Problemas na conexao com a fonte de dados: " + ex.getMessage());
        }
    }
    
    public static void criarTabela()
    {
        final int PORTA = 3306;
        final String NOME_DB = "empresa_oop2";

        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:" + PORTA + "/" + NOME_DB;

        try 
        {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, "root", "123");
            
            Statement st = connection.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS funcionario"
                       + "(id int primary key,"
                       + "nome varchar(35),"
                       + "endereco varchar(50))";
            
            System.out.println("Executando:\n" + sql);
            st.executeUpdate(sql);
            
            String sql2 = "INSERT INTO funcionario VALUES (1, 'Pedro Silva', 'Rua das Dores, 85')";
            
            System.out.println("Executando:\n" + sql2);
            st.executeUpdate(sql2);
            
            JOptionPane.showMessageDialog(null, "BD criado com sucesso");

            connection.close();
        } 
        catch (ClassNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(null, "Driver JDBC nao encontrado!"); 
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Problemas na conexao com a fonte de dados: " + ex.getMessage());
        }
    }
    
}
