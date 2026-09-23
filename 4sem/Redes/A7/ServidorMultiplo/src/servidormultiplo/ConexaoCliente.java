package servidormultiplo;

import java.io.*;
import java.net.*;

public class ConexaoCliente implements Runnable
{
    private Socket minhaConexao;
    private PrintStream msgSaida;
    private BufferedReader msgEntrada;
    
    public ConexaoCliente(Socket conexao)
    {
        if (conexao == null)
            throw new IllegalArgumentException("Voce forneceu uma conexao invalida");
        
        minhaConexao = conexao;
    }
    
    @Override
    public void run()
    {
        try
        {
            msgSaida = new PrintStream(minhaConexao.getOutputStream());
            msgEntrada = new BufferedReader( new InputStreamReader(minhaConexao.getInputStream()) );
            
            String mensagem = msgEntrada.readLine();
            
            while (mensagem != null && !mensagem.equals("FIM"))
            {
                System.out.println(mensagem);
                msgSaida.println("Positivo e Operante");
                mensagem = msgEntrada.readLine();
            }
            
            minhaConexao.close();
        }
        catch (IOException exc)
        {
            exc.printStackTrace();
        }
    }
}
