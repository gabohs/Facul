import java.sql.*;
import javax.swing.JOptionPane;

public class CriadorBD 
{
    // CRIACAO
    public void geraBD()
    {
        final String URL = "jdbc:mysql://localhost:" + ConexaoBD.getPorta() + "/";
        final String USER = "root";
        final String SENHA = "123";
        
        try
        {
            Class.forName(ConexaoBD.getDriver());
            
            Connection conn = DriverManager.getConnection(URL, USER, SENHA);
            
            Statement st = conn.createStatement();
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + ConexaoBD.getNome());
            
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
    
    //CRIANDO TABELAS
    private void criarTabela(String nomeTabela, String campos)
    {
        if (ConexaoBD.getConnection())
        {   
            String sqlDrop = "DROP TABLE IF EXISTS " + nomeTabela;
            String sqlCreate = "CREATE TABLE " + nomeTabela + " (" + campos + ")";

            System.out.println("Executando:\n" + sqlDrop);
            ConexaoBD.runSQL(sqlDrop);

            System.out.println("Executando:\n" + sqlCreate);
            ConexaoBD.runSQL(sqlCreate);

            JOptionPane.showMessageDialog(null, "Tabela criada com sucesso");
            
            ConexaoBD.close();
        }
        else
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados");
    }
    
    public void criarTabelaFornecedor()
    {
        criarTabela(
            "fornecedor", 
                
            "id INT PRIMARY KEY," + 
            "razao_social VARCHAR(50)," +
            "telefone VARCHAR(20)," + 
            "cidade VARCHAR(30)," + 
            "estado VARCHAR(2)," + 
            "categoria VARCHAR(20)," +
            "status VARCHAR(20)," + 
            "tipo_pessoa VARCHAR(15)"
        );
    }
    
    // CONSULTAS
    public void consultaFornecedor()
    {
       if (ConexaoBD.getConnection())
       {
            try 
            {
                ConexaoBD.setResultSet("SELECT id, razao_social FROM fornecedor");
                while (ConexaoBD.resultSet.next())
                {
                    int id = ConexaoBD.resultSet.getInt("id");
                    String nome = ConexaoBD.resultSet.getString("razao_social");
                    System.out.println(id + " " + nome);
                }
                JOptionPane.showMessageDialog(null, "Consulta realizada com sucesso");
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Erro ao ler o resultado: " + ex.getMessage());
            }
            finally
            {
                ConexaoBD.close();
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados");
    }
}
