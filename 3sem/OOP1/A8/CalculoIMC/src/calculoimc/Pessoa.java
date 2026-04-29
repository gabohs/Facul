package calculoimc;

public class Pessoa 
{
    protected String nome;
    protected String data_nascimento;
    
    public Pessoa(String n, String dn)
    {
        this.nome = n;
        this.data_nascimento = dn;
    }
    
    public String toString()
    {
        return "Nome: " + this.nome + "\nData de Nascimento: " + this.data_nascimento;
    }
    
    // Getters e setters
    
    public String getNome()
    {
        return this.nome;
    }
    
    public String getDataNascimento()
    {
        return this.data_nascimento;
    }
    
    public void setNome(String n)
    {
        this.nome = n;
    }
    
    public void setDataNascimento(String dn)
    {
        this.data_nascimento = dn;
    }
}
