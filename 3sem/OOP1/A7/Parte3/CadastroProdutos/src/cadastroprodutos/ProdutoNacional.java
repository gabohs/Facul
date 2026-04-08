package cadastroprodutos;

public class ProdutoNacional extends Produto 
{
    private double imposto;
    private double taxa;
    
    public ProdutoNacional(String descricao, double valor)
    {
        super(descricao, valor);
        this.imposto = 0.1;
        this.taxa    = 0.05; 
    } 
    
    @Override
    public double calcularValorFinal()
    {
        return this.valor + (this.valor * this.imposto) + (this.valor * this.taxa);
    }
    
    @Override 
    public void exibir()
    {   
        super.exibir();
        
        System.out.print("Imposto (%):\t" + this.imposto * 100 + "%" + "\t");
        System.out.println("IMPOSTO:\t" + this.imposto * this.valor);
        
        System.out.print("Taxa (%):\t" + this.taxa * 100 + "%" + "\t");
        System.out.println("TAXA (val):\t" + this.taxa * this.valor);
        
        System.out.println("VALOR FINAL:\t" + this.calcularValorFinal());
        
        System.out.println("-------------------------------------------------");
    }
    
    public double getImposto()
    {
        return this.imposto;
    }
    
    public double getTaxa()
    {
        return this.taxa;
    }
    
    public void setImposto(double valor)
    {
        this.imposto = valor;
    }
    
    public void setTaxa(double valor)
    {
        this.taxa = valor;
    }
           
}
