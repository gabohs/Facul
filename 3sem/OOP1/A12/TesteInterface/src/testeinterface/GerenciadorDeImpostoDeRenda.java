package testeinterface;

public class GerenciadorDeImpostoDeRenda 
{
    private double totalTributos = 0;
    
    public void adicionarTributos(Tributavel t)
    {
        totalTributos += t.calculaTributos();
    }
    
    public double getTotalTributos()
    {
        return this.totalTributos;
    }
    
    public void setTotalTributos(double valor)
    {
        this.totalTributos = valor;
    }
    
}
