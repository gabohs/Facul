package testeinterface;

public class SeguroDeVida implements Tributavel
{
    private double imposto;
    
    public SeguroDeVida(double imposto)
    {
        this.imposto = imposto;
    }
    
    @Override
    public double calculaTributos() 
    {
        return this.imposto;
    }
}
