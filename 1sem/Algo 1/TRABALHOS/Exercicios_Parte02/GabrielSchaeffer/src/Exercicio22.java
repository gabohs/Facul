import java.util.Scanner;

/* EX 22
Leia 4 valores inteiros A, B, C e D. Em seguida, se B for maior do que C e se D for maior do que
A, e a soma de C com D for maior que a soma de A e B e se C e D, ambos, forem positivos e se
a variável A for par escrever a mensagem “Valores aceitos”, senão escrever “Valores nao
aceitos”.
 */

public class Exercicio22
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite os 4 valores inteiros: ");
        
        int a = leitor.nextInt();
        int b = leitor.nextInt();
        int c = leitor.nextInt();
        int d = leitor.nextInt();
        
        if ( (a % 2 == 0) && ((b > c) && (d > a)) && ((c + d > a + b)) && ((c > 0) && (d > 0)) )
        {
            System.out.println("Valores aceitos");
        }
        else
        {
            System.out.println("Valores nao aceitos");
        }
    }
}
