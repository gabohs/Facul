package contabanc;

public class ContaBanc 
{
    public static void print_conta(Conta c)
    {
        System.out.println(
            "A conta [" + c.getNumero() + "] pertence a " + c.getDono() + 
            " e possui um saldo de " + c.getSaldo() + " e um limite de " + c.getLimite()
        );
    }
    
    public static void main(String[] args) 
    {
        // 6: instanciando
        Conta cg = new Conta(1, "Gabriel", 250.0, 200.0);
        Conta cd = new Conta(2, "Dario", 1000.0, 5000.0);
        
        // 7: mostre os valores do atributo saldo de cada um dos objetos:
        print_conta(cg);
        print_conta(cd);
        
        //8: Invoque o método sacar do primeiro objeto sacando R$ 500,00 
        //   e invoque o método depositar do segundo objeto depositando R$ 1.700,00
        cg.sacar(500.0);
        cd.depositar(1700.0);
        
        // mostre novamente os valores
        System.out.print("\n");
        print_conta(cg);
        print_conta(cd);
    }
    
}
