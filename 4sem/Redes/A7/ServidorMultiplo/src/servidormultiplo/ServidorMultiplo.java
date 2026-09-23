package servidormultiplo;

import java.io.*;
import java.net.*;


public class ServidorMultiplo implements Runnable
{
    private static final int PORTA = 8123;
    private static final int MAX_CONEXOES = 10;
    
    private ServerSocket portaConexao;
    
    public ServidorMultiplo()
    {
        try 
        {
            portaConexao = new ServerSocket(PORTA);
        }
        catch (IOException exc)
        {
            exc.printStackTrace();
        }
    }
    
    @Override
    public void run() 
    {
        Socket novaConexao = null;
        ConexaoCliente novoCliente = null;
        
        System.out.println("Servidor Ativo.");
        
        while (true)
        {
            try
            {
                System.out.println("Aguardando nova conexao");
                novaConexao = portaConexao.accept();
                novoCliente = new ConexaoCliente(novaConexao);
                new Thread(novoCliente).start();
            }
            catch (IOException exc)
            {
                exc.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args)
    {
        ServidorMultiplo novoServidor = new ServidorMultiplo();
        new Thread(novoServidor).start();
    }
}
