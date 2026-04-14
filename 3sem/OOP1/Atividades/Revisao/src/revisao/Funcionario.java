package revisao;

public class Funcionario 
{
    protected String nome;
    protected String cpf;
    protected double salario;

    public double calcularBonificacao() 
    {
        return this.salario * 0.10;
    }
    
    public void escrever()
    {
        System.out.println("Nome:        " + this.nome);
        System.out.println("CPF:         " + this.cpf);
        System.out.println("Salario:     " + this.salario);
        System.out.println("Bonificacao: " + this.calcularBonificacao());
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getCpf() 
    {
        return cpf;
    }

    public void setCpf(String cpf) 
    {
        this.cpf = cpf;
    }

    public double getSalario() 
    {
        return salario;
    }

    public void setSalario(double salario) 
    {
        this.salario = salario;
    }
}