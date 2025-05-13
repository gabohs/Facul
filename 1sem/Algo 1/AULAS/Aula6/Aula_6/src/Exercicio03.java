/*
Um atleta faz ate 5 saltos em distancia. Dos 5 o menor e sempre descartado. Ao final, calcula-se a media dos demais saltos
 */

import java.util.Scanner;

public class Exercicio03
{
    public static void main(String[] args)
    {   
        Scanner leitor = new Scanner(System.in);
        
        double menor, soma, salto;
        menor = soma = leitor.nextDouble();
        
        for (int i = 0; i < 4; i++)
        {
            salto = leitor.nextDouble();
            
            soma += salto;
            
            if (salto < menor)
            {    
                menor = salto;
            }
        }
        
        soma -= menor;
        double media = soma / 4.0;
        
        System.out.println("Media dos saltos " + media);
    }
    
}
