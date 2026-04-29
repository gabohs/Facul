package calculoimc;

abstract class PessoaIMC extends Pessoa 
{
    protected double peso;
    protected double altura;
    
    public PessoaIMC(String nome, String data_nasc, double peso, double altura)
    {
        super(nome, data_nasc);
        this.peso = peso;
        this.altura = altura;
    }
    
    public double calculaIMC()
    {
        return this.peso / (this.altura * this.altura);
    }
    
    abstract String resultIMC(); // metodo abstrato
    
    @Override
    public String toString()
    {
        return "Nome: " + this.nome + "\nData de Nascimento: " + this.data_nascimento
                + "\nPeso: " + this.peso + "\nAltura: " + this.altura;
    }
    
    // Getters e setters
    
    public double getPeso()
    {
        return this.peso;
    }
    
    public double getAltura()
    {
        return this.altura;
    }
    
    public void setPeso(double valor)
    {
        this.peso = valor;
    }
    
    public void setAltura(double valor)
    {
        this.altura = valor;
    }
}
