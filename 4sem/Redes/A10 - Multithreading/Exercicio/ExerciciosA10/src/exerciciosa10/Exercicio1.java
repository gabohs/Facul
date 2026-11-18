package exerciciosa10;

import java.util.Random;

/* 
EXERCICIO 1: 
Criar um exemplo de programação em Java que gera um número aleatório e variável de Threads. 
Esses threads devem se alternar em escrever mensagens na tela. Observe a sequência em que escrevem e explique o que acontece no seu exemplo.
*/

public class Exercicio1 
{
    public static int numero_aleatorio(int min, int max)
    {   
        return (int) (min + Math.random() * (max - min));
    }
    
    public static void main(String[] args) 
    {
        int num_threads = GeradorAleatorio.gerar_aleatorio(2, 6);
        System.out.println("Num. de threads: " + num_threads);
        
        String nomes[] = {"Adario", "Andre", "Dario", "Gabriel", "Emanuel", "Ricardo"};
        
        for (int i = 0; i < num_threads; i++)
        {
            Mensageiro mensageiro = new Mensageiro(i, nomes[i]);
            mensageiro.start();
        }
        
    }   
}
