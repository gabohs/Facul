package testeinterface;

public class Pessoa implements Tributavel
{
    private double salario;
    
    public Pessoa(double salario)
    {
        this.salario = salario;
    }
    
    @Override
    public double calculaTributos() 
    {
        return this.salario * 11 / 100;
    }
    
    public double getSalario()
    {
        return this.salario;
    }
    
    public void setSalario(double valor)
    {
        this.salario = valor;
    }
    
}
