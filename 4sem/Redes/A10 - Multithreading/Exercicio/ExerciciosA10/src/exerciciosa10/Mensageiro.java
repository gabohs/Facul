package exerciciosa10;

public class Mensageiro extends Thread
{
    private int codigo;
    private String nome;
    
    private String[] mensagens = {
        "Oi", "Como vai?", "Tudo bem?", "Tenho uma mensagem para Gabriel", "Tenho uma mensagem para Adario",
        "Tenho uma mensagem para Emanuel", "Java eh a melhor linguagem!", "C eh a melhor linguagem!", "Python eh a melhor linguagem!"
    };
    
    public Mensageiro(int codigo, String nome)
    {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    @Override
    public void run()
    {
        final int numero_mensagens = 10; // cada mensageiro escreve 10 mensagens
        
        for (int mensagem = 0; mensagem < numero_mensagens; mensagem++)
        {
            System.out.println(
                mensagem + ": O mensageiro " + codigo + " (" + nome + ") esta dizendo: " + 
                mensagens[GeradorAleatorio.gerar_aleatorio(0, mensagens.length)]
            );
        }
    }
}
