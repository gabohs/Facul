package calculoimc;

public class Homem extends PessoaIMC // classe concreta, filha da abstrata PessoaIMC
{
    public Homem(String nome, String data_nasc, double peso, double altura)
    {
        super(nome, data_nasc, peso, altura);
    }
    
    public String resultIMC()
    {
        String result = "";
        double imc = calculaIMC();
        
        if (imc < 20.7)
            result = "Abaixo do peso normal";
        else if (imc < 26.4)
            result = "Peso ideal";
        else
            result = "Acima do peso";
        
        return result;
    }
}
