import java.sql.*;

public class ConexaoBD 
{
    final static int PORTA = 3306;
    final static String NOME_DB = "treino_oop2";
    
    final static String USER = "root";
    final static String SENHA = "123";
    
    public static Connection connection  = null;    
    public static Statement statement  = null;   
    public static ResultSet resultSet  = null;   
    
    public static final String DRIVER  = "com.mysql.cj.jdbc.Driver";   
    public static String URL = "jdbc:mysql://localhost:" + PORTA + "/" + NOME_DB;
    
    public static boolean getConnection()
    {
        try
        {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, SENHA);
            
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            System.out.println("Conectou");
            return true;
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
            return false;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
    }
    
    // carrega o result set com o resultado do sql executado
    public static void setResultSet(String sql)
    {
        try 
        {
            resultSet = statement.executeQuery(sql);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    // executa um script SQL de atualização
    // retorna um valor inteiro contendo a quantidade de linhas afetadas
    public static int runSQL(String sql)
    {
        int quant = 0;
        try
        {
            quant = statement.executeUpdate(sql);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return quant;
    }
    
    public static int getPorta()
    {
        return PORTA;
    }
    
    public static String getNome()
    {
        return NOME_DB;
    }
    
    public static String getDriver()
    {
        return DRIVER;
    }
    
    public static String getURL()
    {
        return URL;
    }
    
    // fecha as conexoes
    public static void close()
    {
        closeResultSet();
        closeStatement();
        closeConnection();
    }
    
    private static void closeConnection()
    {
         try 
         {
            if (connection != null)
                connection.close();
            System.out.println("Desconectou");
         } 
         catch (SQLException erro)
         {
            erro.printStackTrace();
         }
    }
    
    private static void closeStatement()
    {
        try 
        {   
            if (statement != null)
                statement.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    private static void closeResultSet()
    {
        try 
        {  
           if (resultSet != null)
               resultSet.close();
        } 
        catch (Exception e)
        {
           e.printStackTrace();
        }
    }
}
