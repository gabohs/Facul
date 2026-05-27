package testeinterface;

public class Conta 
{
    protected double saldo;
    
    public Conta(double saldo)
    {
        this.saldo = saldo;
    }
    
    public double getSaldo()
    {
        return this.saldo;
    }
    
    public void setSaldo(double valor)
    {
        this.saldo = valor;
    }
}
