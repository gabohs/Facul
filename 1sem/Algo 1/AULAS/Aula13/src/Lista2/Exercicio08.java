package Lista2;

import java.util.Scanner;
import java.util.LinkedList;

/*
Escreva um programa que crie uma fila para armazenar pedidos de um restaurante. Os pedidos
podem ser “pizza salao”, “pizza delivery”, “sushi salao” e “sushi delivery”. Receba todos os
pedidos (serão um total de 20.). Em seguida, tire os pedidos da fila, e envie para outras duas
filas de preparo: pizza e sushi. Depois de alocar todos os pedidos nas filas de preparação, retire
delas e insira em novas duas filas de entrega: salao e delivery.
*/

public class Exercicio08
{
    public static void main(String[] args)
    {   
        Scanner leitor = new Scanner(System.in);
        
        LinkedList<String> pedidos = new LinkedList();
        
        LinkedList<String> pizza = new LinkedList();
        LinkedList<String> sushi = new LinkedList();
        
        LinkedList<String> salao = new LinkedList();
        LinkedList<String> delivery = new LinkedList();
       
        for (int i = 0; i < 5; i++)
        {
            pedidos.add(leitor.nextLine());
        }
        
        while (!pedidos.isEmpty())
        {
            String pedido = pedidos.poll();
            
            if (pedido.contains("pizza"))
                pizza.add(pedido);
            
            else if (pedido.contains("sushi"))
                sushi.add(pedido);
        }
        
        while (!pizza.isEmpty())
        {
            String pedido = pizza.poll();
            
            if (pedido.contains("salao"))
                salao.add(pedido);
            
            else if (pedido.contains("delivery"))
                delivery.add(pedido);
        }
        
        while (!sushi.isEmpty())
        {
            String pedido = sushi.poll();
            
            if (pedido.contains("salao"))
                salao.add(pedido);
            
            else if (pedido.contains("delivery"))
                delivery.add(pedido);
        }
        
        // ---------------------------------------------------------------------
        
        System.out.println("--- SALAO ---");
        for (String p : salao)
            System.out.println("> " + p);
        
        System.out.println("\n--- DELIVERY ---");
        for (String p : delivery)
            System.out.println("> " + p);
        
        // ---------------------------------------------------------------------
        
    }
    
}
