package empresa;

public class Gerente extends Funcionario
{
    private int senha;
    private int numeroDeFuncionariosGerenciados;
    
    @Override
    public double calcularBonificacao() 
    {
        return this.salario * 0.15;
    }
    
    @Override
    public void escrever()
    {
        super.escrever();
        System.out.println("Funcionarios Gerenciados: " + this.numeroDeFuncionariosGerenciados);
    }
    
    public boolean autentica(int senha) 
    {
        if (this.senha == senha) 
            return true;
        else 
            return false;
    }
    
    public int getSenha() 
    {
        return senha;
    }
    public void setSenha(int senha) 
    {
        this.senha = senha;
    }
    
    public int getNumeroDeFuncionariosGerenciados() 
    {
        return numeroDeFuncionariosGerenciados;
    }
    public void setNumeroDeFuncionariosGerenciados(int numeroDeFuncionariosGerenciados) 
    {
        this.numeroDeFuncionariosGerenciados = numeroDeFuncionariosGerenciados;
    }
}
