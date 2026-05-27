package testeinterface;

public class TesteInterface 
{
    public static void main(String[] args) 
    {
        Pessoa p = new Pessoa(4500.00);
        SeguroDeVida s = new SeguroDeVida(36.00);
        ContaCorrente c = new ContaCorrente(500.00);
        
        GerenciadorDeImpostoDeRenda g = new GerenciadorDeImpostoDeRenda();
        g.adicionarTributos(p);
        g.adicionarTributos(s);
        g.adicionarTributos(c);
        
        System.out.println("Total de tributos: " + g.getTotalTributos());
        System.out.println("Tributo pessoa         = " + p.calculaTributos());
        System.out.println("Tributo seguro de vida = " + s.calculaTributos());
        System.out.println("Tributo conta corrente = " + c.calculaTributos());
    }
    
}
