package cupomsupermercadoencapsulamento;

public class CupomSupermercadoEncapsulamento 
{
    public static void print_item(Item i)
    {
        String preco_bruto = String.format("%.2f", i.calcular_valor_bruto());
        String desconto = String.format("%.2f", i.calcular_desconto());
        String valor_final = String.format("%.2f", i.calcular_valor_final());
        
        
        System.out.println(
                i.getCodigo() + "\t" + i.getDescricao() + "\t\t" + i.getQuantidade() + "\t\t" + i.getDesconto() + "\t\t" + 
                i.getPrecoUnitario() + "\t\t\t" + preco_bruto + "\t\t\t" + desconto+ "\t\t" + valor_final
        );  
    }
    
    public static double calcula_valor_total(Item[] itens)
    {
        double valor_total = 0;
        for (Item it : itens)
            valor_total += it.calcular_valor_final(); 
        
        return valor_total;
    }
    
    public static void print_cupom(Item[] itens)
    {
        System.out.println("========================================================== CUPOM DO SUPERMERCADO ==========================================================");
        System.out.println("Codigo\tDescricao\tQuantidade\tDesconto (%)\tPreco Unitario (R$)\tValor bruto (R$)\tDesconto (R$)\tValor Final (R$)");
        
        for (Item i : itens)
            print_item(i);
        
        double valor_total = calcula_valor_total(itens);
        
        System.out.println("TOTAL DA COMPRA: " + String.format("%.2f", valor_total) + " reais");
        System.out.println("===========================================================================================================================================\n");
    }
    
    public static void main(String[] args) 
    {
        Item i1; // declarando
        i1 = new Item("001", "Pao", 6, 7.0, 1.05); // instanciando
        
        Item i2 = new Item("002", "Carne", 3, 10.0, 30);
        Item i3 = new Item("003", "Sorvete", 1, 20.0, 3.99);
        Item i4 = new Item("004", "Livros", 5, 15.0, 119.99);
        
        Item[] cupom1 = {i1, i2, i3, i4};
        
        print_cupom(cupom1);
        
        // ----------------------------------------------------------------------------------------------------------
        
        i1.setDesconto(30.0);
        i1.setPrecoUnitario(1.5);
        i1.setQuantidade(9);
        
        i2.setDescricao("Cafe");
        i2.setDesconto(15.0);
        i2.setPrecoUnitario(4);
        i2.setQuantidade(30);
        
        i3.setDescricao("Mouse");
        i3.setDesconto(20);
        i3.setPrecoUnitario(30.5);
        i3.setQuantidade(10);
        
        i4.setDescricao("Teclado");
        i4.setDesconto(15);
        i4.setPrecoUnitario(500);
        i4.setQuantidade(1);
        
        print_cupom(cupom1);
        
        // ----------------------------------------------------------------------------------------------------------
        
        Item i5 = new Item();
        i5.setCodigo("100");
        i5.setDescricao("Carne");
        i5.setQuantidade(3);
        i5.setDesconto(50.0);
        i5.setPrecoUnitario(29.90);
        
        Item i6;
        i6 = new Item();
        
        Item i7 = i6; // i7 apontanda para o mesmo objeto que i6
        
        i6.setDescricao("Teste");
        i6.setPrecoUnitario(10.0);
        
        Item[] cupom2 = {i1, i5, i6, i7};
        print_cupom(cupom2);
        
        System.out.println(i6.getPrecoUnitario());
        System.out.println(i7.getPrecoUnitario()); // ambos sao iguais
        
        if (i6 == i7)
            System.out.println("i6 e i7 apontam para o mesmo objeto na memoria!");
        
        // ----------------------------------------------------------------------------------------------------------
        
        Item teste1 = new Item("TESTE", "Oi", 10, 10, 10);
        Item teste2 = new Item("TESTE", "Oi", 10, 10, 10);
        
        if (teste1 == teste2)  // nao sera executado
               System.out.println("teste1 e teste2 sao iguais");
    }
}
