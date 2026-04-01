package sistemapessoa;

public class Empregado extends Pessoa
{
    private int    codigoSetor;
    private double salarioBase;
    private double pImposto;
    
    public Empregado(String nome, String endereco, String telefone, int codigoSetor, double salarioBase, double pImposto)
    {
        super(nome, endereco, telefone);
        
        this.codigoSetor = codigoSetor;
        this.salarioBase = salarioBase;
        this.pImposto    = pImposto;
    }
    
    public int getCodigoSetor()
    {
        return this.codigoSetor;
    }
    
    public double getSalarioBase()
    {
        return this.salarioBase;
    }
    
    public double getPImposto()
    {
        return this.pImposto;
    }
    
    public void setCodigoSetor(int cod)
    {
        this.codigoSetor = cod;
    }
    
    public void setSalarioBase(double valor)
    {
        this.salarioBase = valor;
    }
    
    public void setPImposto(double valor)
    {
        this.pImposto = valor;
    }
        
    public double calcularSalario()
    {
        return salarioBase - (salarioBase * (pImposto / 100));
    }
    
    @Override
    public void escrever()
    {
        super.escrever();
        System.out.println("Codigo do Setor:         " + this.codigoSetor);
        System.out.println("Salario Base (valor):    " + this.salarioBase);
        System.out.println("Imposto sobre o salario: " + this.pImposto);
        System.out.println("Salario final (valor):   " + this.calcularSalario());
    }
    
    @Override 
    public String toString()
    {
        return "Empregado{codSetor: " + this.codigoSetor + ", salBase: " + this.salarioBase + ", pImposto: " + this.pImposto + 
                ", sFinal: " + this.calcularSalario() + "}";
    }
}
