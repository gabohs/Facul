package empresa;

public class ControleDeBonificacoes 
{
    private double totalDeBonificacoes = 0;
    
    public void registra(Funcionario func)
    {
        this.totalDeBonificacoes += func.calcularBonificacao();
    }
    
    public double getTotalDeBonificacoes()
    {
        return this.totalDeBonificacoes;
    }
    
    public void setTotalDeBonificacoes(double val)
    {
        this.totalDeBonificacoes = val;
    }
}
