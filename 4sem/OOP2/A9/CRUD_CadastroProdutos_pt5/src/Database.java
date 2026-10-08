
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Database 
{
    final static int PORTA = 3306;
    final static String NOME_DB = "empresa_oop2";
    
    public void geraBD()
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
    
    public void criarTabela()
    {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:" + PORTA + "/" + NOME_DB;

        try 
        {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, "root", "123");
            
            Statement st = conn.createStatement();
            
            // criacao da tabela de produtos
            String sql = "CREATE TABLE IF NOT EXISTS produto"
                       + "(id int primary key,"
                       + "descricao varchar(50),"
                       + "categoria varchar(30),"
                       + "marca varchar(30),"
                       + "preco_custo double,"
                       + "preco_venda double,"
                       + "fornecedor varchar(30),"
                       + "tipo varchar(20),"
                       + "quantidade_estoque int,"
                       + "estoque_minimo int,"
                       + "situacao varchar(10))";
            
            System.out.println("Executando:\n" + sql);
            st.executeUpdate(sql);
            
            // criacao da tabela de nota fiscal
            String sql2 = "CREATE TABLE IF NOT EXISTS NotaFiscal"
                       + "(idNotaFiscal int primary key AUTO_INCREMENT,"
                       + "dataEmissao date,"
                       + "idCliente int,"
                       + "valorTotal double)";
            
            System.out.println("Executando:\n" + sql2);
            st.executeUpdate(sql2);
            
            // criacao da tabela dos itens da nota
            String sql3 = "CREATE TABLE IF NOT EXISTS ItemNotaFiscal"
                       + "(idItem int primary key AUTO_INCREMENT,"
                       + "idNotaFiscal int,"
                       + "descricao varchar(50),"
                       + "quantidade int,"
                       + "preco_unitario double,"
                       + "FOREIGN KEY (idNotaFiscal) REFERENCES NotaFiscal (idNotaFiscal))";
            
            System.out.println("Executando:\n" + sql3);
            st.executeUpdate(sql3);
            
            JOptionPane.showMessageDialog(null, "Tabelas criadas com sucesso");

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
    
    public void consultaBD()
    {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:" + PORTA + "/" + NOME_DB;

        try 
        {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, "root", "123");
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, nome FROM funcionario");
            while (rs.next()) {
                int codigo = rs.getInt("id");
                String nom = rs.getString("nome");
                System.out.println(codigo + " "+ nom);
            }
            JOptionPane.showMessageDialog(null,"Consulta realizada com sucesso");
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
