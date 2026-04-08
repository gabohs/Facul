package cadastroprodutos;

public class ProdutoImportado extends Produto
{
    private double imposto;
    private double taxa;
    private double taxaImportacao;
    
    public ProdutoImportado(String descricao, double valor)
    {
        super(descricao, valor);
        this.imposto        = 0.1;
        this.taxa           = 0.05;
        this.taxaImportacao = 0.05;
    } 
    
    @Override
    public double calcularValorFinal()
    {
        return this.valor + (this.valor * this.imposto) + (this.valor * this.taxa) + (this.valor * this.taxaImportacao);
    }
    
    @Override 
    public void exibir()
    {    
        super.exibir();
        
        System.out.println("Imposto (%):\t" + this.imposto * 100 + "%" + "\t");
        System.out.println("IMPOSTO:\t\t" + this.imposto * this.valor);
        
        System.out.print("Taxa (%):\t" + this.taxa * 100 + "%" + "\t");
        System.out.println("TAXA (val):\t" + this.taxa * this.valor);
        
        System.out.print("Taxa Import (%):\t" + this.taxa * 100 + "%" + "\t");
        System.out.println("Taxa Import (valor):\t" + this.taxa * this.valor);
        
        System.out.println("VALOR FINAL:\t" + this.calcularValorFinal());
        
        System.out.println("--------------------------------------------------");
    }
    
    public double getImposto()
    {
        return this.imposto;
    }
    
    public double getTaxa()
    {
        return this.taxa;
    }
    
    public double getTaxaImportacao()
    {
        return this.taxaImportacao;
    }
    
    public void setImposto(double valor)
    {
        this.imposto = valor;
    }
    
    public void setTaxa(double valor)
    {
        this.taxa = valor;
    }
    
    public void setTaxaImportacao(double valor)
    {
        this.taxaImportacao = valor;
    }
    
}
