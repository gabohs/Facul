package controlepagamento;

public class ServicoFixo extends Servico 
{
    public ServicoFixo(String descricao, double valor_base)
    {
        super(descricao, valor_base);
    }
    
    @Override
    public double calcularPagamento()
    {
        return this.valor_base;
    }
    
    @Override
    public void escrever()
    {
        super.escrever();
    }
}
