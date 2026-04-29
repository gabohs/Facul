package calculoimc;

public class CalculoIMC 
{
    public static void main(String[] args) 
    {
        Homem homem   = new Homem("Dario Adario Ernani Andre Gabriel da Silva", "21/03/1980", 80.0, 1.85);
        Mulher mulher = new Mulher("Luciane Noemi da Silva", "10/10/1995", 56.5, 1.62);
        
        System.out.println(homem.toString());
        System.out.println("IMC: " + homem.calculaIMC());
        System.out.println(homem.resultIMC());
        
        System.out.println("");
        
        System.out.println(mulher.toString());
        System.out.println("IMC: " + mulher.calculaIMC());
        System.out.println(mulher.resultIMC());
    }
}
