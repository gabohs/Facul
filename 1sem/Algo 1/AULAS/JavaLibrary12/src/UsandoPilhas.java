import java.util.Stack;

public class UsandoPilhas
{
    public static void main(String[] args)
    {
        Stack<String> pilha = new Stack();
        
        pilha.push("Erechim");
        pilha.push("Passo Fundo");
        pilha.push("Sertao");
        pilha.push("Getulio Vargas");
        pilha.push("Estacao");
        
        while (!pilha.empty())
        {
            System.out.println(pilha.pop()); // pilha.pop() remove e retorna o ultimo elemento
        }
    }
    
}
