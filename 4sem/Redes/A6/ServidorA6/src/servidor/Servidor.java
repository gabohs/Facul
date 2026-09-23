
package servidor;
import java.io.*;
import java.net.*;
/**
 *
 * @author 05801128026
 */
public class Servidor {

    private final static int PORTA = 7777;
    private ServerSocket socketServidor = null;
    
    public Servidor() {
        try {
            socketServidor = new ServerSocket(PORTA);
        } catch (IOException exc) {
            System.err.println("Erro na inicialização do servidor");
            exc.printStackTrace();
            System.exit(-1);
        }
    }
    
    public void aguardaCliente() {
        while(true) {
            try {
                Socket novaConexao = socketServidor.accept();
                PrintStream msgSaida = new PrintStream(
                        novaConexao.getOutputStream()
                );
                
                BufferedReader msgEntrada = new BufferedReader(
                        new InputStreamReader(
                                novaConexao.getInputStream()
                        )
                );
                
                InetAddress endIP = novaConexao.getInetAddress();
                String nomeHost = endIP.getHostName();
                                
                System.out.println("Nova conexao: " + 
                        endIP.getHostAddress() + 
                        " - " + nomeHost);
                
                String mensagem = msgEntrada.readLine();                
                System.out.println("Mensagem do Cliente: " + mensagem);
                
                msgSaida.println("Encerrando a conexao");
                
                msgEntrada.close();
                msgSaida.close();
                novaConexao.close();
            } catch (IOException exc) {
                System.out.println("Erro na conexao com o Cliente");
                exc.printStackTrace();  
            }
        }
    }
    
    public static void main(String[] args) {
        
    }
}
