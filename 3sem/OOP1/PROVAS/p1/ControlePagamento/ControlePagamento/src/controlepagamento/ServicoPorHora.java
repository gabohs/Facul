package controlepagamento;

public class ServicoPorHora extends Servico
{
    private int quantidade_horas;
    private double valor_hora;
    
    public ServicoPorHora(String descricao, double valor_base, int quant_horas, double val_hora)
    {
        super(descricao, valor_base);
        this.quantidade_horas = quant_horas;
        this.valor_hora       = val_hora; 
    }

    public int getQuantidade_horas() 
    {
        return quantidade_horas;
    }

    public double getValor_hora() 
    {
        return valor_hora;
    }

    public void setQuantidade_horas(int quantidade_horas) 
    {
        this.quantidade_horas = quantidade_horas;
    }

    public void setValor_hora(double valor_hora) 
    {
        this.valor_hora = valor_hora;
    }
    
    @Override
    public double calcularPagamento()
    {
        return this.quantidade_horas * this.valor_hora;
    } 
    
    @Override
    public void escrever()
    {
        super.escrever();
        System.out.println("Q.Horas: " + this.quantidade_horas);
        System.out.println("V. Hora: " + this.valor_hora);
    }
}
