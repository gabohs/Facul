package cupomsupermercado;


public class CupomSupermercado 
{
    public static void print_item(Item i)
    {
        String preco_bruto = String.format("%.2f", i.calcular_valor_bruto());
        String desconto = String.format("%.2f", i.calcular_desconto());
        String valor_final = String.format("%.2f", i.calcular_valor_final());
        
        
        System.out.println(
                i.codigo + "\t" + i.descricao + "\t\t" + i.quantidade + "\t\t" + i.desconto + "\t\t" + 
                i.preco_unitario + "\t\t\t" + preco_bruto + "\t\t\t" + desconto+ "\t\t" + valor_final
        );
    }
    
    public static void main(String[] args) 
    {
        Item i1; // declarando
        i1 = new Item("001", "Pao", 6, 7.0, 1.05); // instanciando
        
        Item i2 = new Item("002", "Carne", 3, 10.0, 30);
        Item i3 = new Item("003", "Sorvete", 1, 20.0, 3.99);
        Item i4 = new Item("004", "Livros", 5, 15.0, 119.99);
        
        Item[] itens = {i1, i2, i3, i4};
        
        double valor_total = 0;
        for (Item it : itens)
            valor_total += it.calcular_valor_final();
        
        
        System.out.println("========================================================== CUPOM DO SUPERMERCADO ==========================================================");
        System.out.println("Codigo\tDescricao\tQuantidade\tDesconto (%)\tPreco Unitario (R$)\tValor bruto (R$)\tDesconto (R$)\tValor Final (R$)");
        
        print_item(i1);
        print_item(i2);
        print_item(i3);
        print_item(i4);
        
        System.out.println("TOTAL DA COMPRA: " + String.format("%.2f", valor_total) + " reais");
        
        System.out.println("===========================================================================================================================================");
    }
    
}
