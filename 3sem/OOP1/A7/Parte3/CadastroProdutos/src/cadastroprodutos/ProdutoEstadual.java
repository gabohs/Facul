package cadastroprodutos;

public class ProdutoEstadual extends Produto
{
    private double imposto; 
    
    public ProdutoEstadual(String descricao, double valor)
    {
        super(descricao, valor);
        this.imposto = 0.1; // exercicio especifica o imposto como sendo 10%
    }
    
    @Override
    public double calcularValorFinal()
    {
        return this.valor + (this.valor * this.imposto);
    }
    
    @Override 
    public void exibir()
    {   
        super.exibir();
        System.out.print("Imposto (%):\t" + this.imposto * 100 + "%" + "\t");
        System.out.println("IMPOSTO (valor):\t" + this.imposto * this.valor);
        
        System.out.println("VALOR FINAL:\t" + this.calcularValorFinal());
        
        System.out.println("-------------------------------------------------");
    }
    
    public double getImposto()
    {
        return this.imposto;
    }
    
    public void setImposto(double valor)
    {
        this.imposto = valor;
    }
}
