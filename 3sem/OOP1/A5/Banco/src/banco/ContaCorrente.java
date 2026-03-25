package banco;

public class ContaCorrente extends Conta
{
    private double limite;
    
    public ContaCorrente(String nome_titular, String numero_conta, double saldo, double limite)
    {
        super(nome_titular, numero_conta, saldo);
        this.limite = limite;
    }
    
    // ------------------------------------------------
    
    public double getLimite()
    {
        return this.limite;
    }
    
    public void setLimite(double valor)
    {
        this.limite = valor;
    }
    
    // -----------------------------------------------
    
    @Override
    public void sacar(double valor)
    {
        if (valor <= this.saldo + limite)
            saldo -= valor;
        else
            System.out.println("Nao ha saldo suficiente!");
    }
    
    @Override
    public void escrever()
    {
        super.escrever();
        System.out.println("Limite: " + this.limite);
    }
}
