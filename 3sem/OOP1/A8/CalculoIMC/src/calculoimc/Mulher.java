package calculoimc;

public class Mulher extends PessoaIMC 
{
    public Mulher(String nome, String data_nasc, double peso, double altura)
    {
        super(nome, data_nasc, peso, altura);
    }
    
    public String resultIMC()
    {
        String result = "";
        double imc = calculaIMC();
        
        if (imc < 19)
            result = "Abaixo do peso normal";
        else if (imc < 25.8)
            result = "Peso ideal";
        else
            result = "Acima do peso";
        
        return result;
    }
}
