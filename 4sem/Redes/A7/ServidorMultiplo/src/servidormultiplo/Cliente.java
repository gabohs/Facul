package servidormultiplo;

import java.io.*;
import java.net.*;

public class Cliente 
{

    private final static int PORTA_SERVIDOR = 8123;
    private final static String ENDER_SERVIDOR = "127.0.0.1";
    private Socket minhaConexao = null;
    
    public Cliente() 
    {
        try 
        {
            minhaConexao = new Socket(ENDER_SERVIDOR, PORTA_SERVIDOR);            
        } catch (IOException exc) 
        {
            System.err.println("Erro na inicialização do servidor");
            exc.printStackTrace();
            System.exit(-1);
        }
    }
    
    public void comunica() 
    {
        try 
        {
            PrintStream msgSaida = new PrintStream(minhaConexao.getOutputStream());
            
            BufferedReader msgEntrada = new BufferedReader(
                    new InputStreamReader(minhaConexao.getInputStream())
            );
            
            msgSaida.println("MENSAGEM");
            
            String resposta = msgEntrada.readLine();
            System.out.println("Resposta do Servidor: " + resposta);
            
            msgEntrada.close();
            msgSaida.close();
            minhaConexao.close();
        } 
        catch (IOException exc) 
        {
            System.err.println("Nao foi possivel estabelecer a comunicacao");
            exc.printStackTrace();
            System.exit(-1);
        } 
        finally 
        {
            
        }
    }
    
    public static void main(String[] args) 
    {
        Cliente novoCliente = new Cliente();
        novoCliente.comunica();
    }
    
}

