package testeinterface;

public class ContaCorrente extends Conta implements Tributavel
{
    public ContaCorrente(double saldo)
    {
        super(saldo);
    }
    
    @Override
    public double calculaTributos()
    {
        return this.saldo * 1.5 / 100;
    }
}
