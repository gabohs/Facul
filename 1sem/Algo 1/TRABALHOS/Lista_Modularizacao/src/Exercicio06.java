/*
Em Java, implemente um método com a seguinte assinatura:
public static void imprimirLinhaDecor(int quantidade, char caractere)
O método deve:
● Imprimir uma linha com o caractere informado, repetido pela quantidade informada.
● Exemplo: imprimirLinhaDecor(5, '*') deve imprimir *****.
*/

public class Exercicio06
{   
    public static void imprimirLinhaDecor(int quantidade, char caractere)
    {
        for (int i = 0; i < quantidade; i++)
        {
            System.out.print(caractere);
        }
        System.out.print("\n");
    }
    
    public static void main(String[] args)
    {
        imprimirLinhaDecor(5, '*');
        imprimirLinhaDecor(10, '#');
    }
}
