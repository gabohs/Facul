package testebd;

import java.sql.*;
import javax.swing.JOptionPane;

public class TesteBD 
{
    final static int PORTA = 3306;
    final static String NOME_DB = "empresa_oop2";
    
    public static void main(String[] args) 
    {
        //geraBD();
        // criarTabela();
        consultaBD();
    }
    
    public static void geraBD()
    {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:" + PORTA + "/";

        try 
        {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, "root", "123");
            
            Statement st = conn.createStatement();
            
            String sql = "CREATE DATABASE IF NOT EXISTS " + NOME_DB;
            st.executeUpdate(sql);
            
            
            JOptionPane.showMessageDialog(null, "BD criado com sucesso");

            st.close();
            conn.close();
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
            Connection conn = DriverManager.getConnection(URL, "root", "123");
            
            Statement st = conn.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS funcionario"
                       + "(id int primary key,"
                       + "nome varchar(35),"
                       + "endereco varchar(50))";
            
            System.out.println("Executando:\n" + sql);
            st.executeUpdate(sql);
            
            String sql2 = "INSERT IGNORE INTO funcionario VALUES (1, 'Pedro Silva', 'Rua das Dores, 85'),"
                    + "                                   (2, 'Dario Adario', 'Rua Pedro Silva, 92'),"
                    + "                                   (3, 'Joao Ricardo', 'Rua Diogo Emanuel, 12');";
            
            System.out.println("Executando:\n" + sql2);
            st.executeUpdate(sql2);
            
            JOptionPane.showMessageDialog(null, "BD criado com sucesso");

            st.close();
            conn.close();
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
    
    public static void consultaBD()
    {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:" + PORTA + "/" + NOME_DB;

        try 
        {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, "root", "123");
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM funcionario;");
            
            while (rs.next())
            {
                int codigo  = rs.getInt("id");
                String nome = rs.getString("nome");
                String end  = rs.getString("endereco");
                
                System.out.println(codigo + ": " + nome + "\t\t" + end );
            }
            
            rs.close();
            st.close();
            conn.close();
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
