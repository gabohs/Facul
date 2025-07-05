package Lista1;

import java.util.Scanner;
import java.util.ArrayList;

/*
Escreva um programa em Java que crie uma lista para armazenar valores inteiros. Faça a leitura,
a partir do teclado, de 15 valores e armazene na lista. Crie uma segunda lista para numeros
inteiros. Percorra a primeira lista e remova todos os valores armazenados que são ímpares,
inserindo-os na segunda lista. Exiba todos os valores inseridos na segunda lista.
*/

public class Exercicio04
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        ArrayList<Integer> lista = new ArrayList();
        for (int i = 0; i < 15; i++)
        {
            lista.add(leitor.nextInt());
        }
        
        ArrayList<Integer> lista2 = new ArrayList();
        for (int i = 0; i < lista.size(); i++)
        {
            if (lista.get(i) % 2 != 0)
            {
                lista2.add(lista.get(i));
                lista.remove(i);
            }
        }
        
        for (int n : lista2)
            System.out.print(n + "  ");
        
        System.out.print("\n");
    }
    
}
