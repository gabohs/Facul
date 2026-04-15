package controlepagamento;

public class ControlePagamento 
{
    public static void main(String[] args) 
    {
        SistemaPagamento sistema = new SistemaPagamento();
        sistema.executar(); // logica feita no metodo executar, para deixar o main mais limpo
    }
}
