package controlepagamento;

public class ServicoComTaxa extends Servico
{
    private double percentual_taxa;
    
    public ServicoComTaxa(String descricao, double valor_base, double percent_taxa)
    {
        super(descricao, valor_base);
        this.percentual_taxa = percent_taxa;
    }

    public double getPercent_taxa() 
    {
        return this.percentual_taxa;
    }

    public void setPercent_taxa(double percent_taxa) 
    {
        this.percentual_taxa = percent_taxa;
    }
    
    @Override
    public double calcularPagamento()
    {
        return this.valor_base + (this.valor_base * (this.percentual_taxa / 100));
    }
    
    @Override
    public void escrever()
    {
        super.escrever();
        System.out.println("P. Taxa: " + this.percentual_taxa);
    }
}
