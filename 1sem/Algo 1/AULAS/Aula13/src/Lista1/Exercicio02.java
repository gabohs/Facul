package Lista1;

import java.util.Scanner;
import java.util.ArrayList;

/*
Escreva um programa em Java que crie uma lista para armazenar valores inteiros. Faça a leitura,
a partir do teclado, de 30 valores e armazene na lista. Percorra a lista e informe o índice de todos
os valores armazenados que são ímpares.
*/

public class Exercicio02
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        ArrayList<Integer> lista = new ArrayList();
        
        for (int i = 0; i < 30; i++)
        {
            lista.add(leitor.nextInt());
        }
        
        for (int i = 0; i < lista.size(); i++)
        {
            if ( lista.get(i) % 2 != 0)
            {
                System.out.println("Numero impar encontrado no indice: " + i);
            }
        }        
    }
    
}
