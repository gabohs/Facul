package psiquiatria;

public class Feliz extends Humor
{
    // 1o Tipo de polimorfismo: Polimorfismo de sobrescrita, dinamico (tempo de execucao)

    @Override
    protected String getHumor()
    {
        return "Feliz";
    }
    
    public void rir()
    {
        System.out.println("HAHAHAHAHAHAHHAHAHHAHAHAHHAHAHAHAHHAHAHAHHAHHAHHAHHAH");
    }
    
}
