import java.util.ArrayList;

public class Carrinho {
    private ArrayList<ItemCompra> listaItens;
    private double totalCompra;
    private double porDesconto;
    private double valorPagar;

    public Carrinho(ArrayList<ItemCompra> listaItens, double porDesconto) {
        this.listaItens = listaItens;
        this.porDesconto = porDesconto;
        this.totalCompra = 0.0;
        this.valorPagar = 0.0;
    }

    public void mostraCarrinho() {
        System.out.println("Itens no carrinho:");
        for (int i = 0; i < listaItens.size(); i++) {
            System.out.print((i + 1) + ". ");
            listaItens.get(i).mostraItem();
        }
        System.out.println("Desconto: " + porDesconto + "%");
        System.out.println("Total da compra: R$" + totalCompra);
    }

    public double calcDesconto(double soma) {
        return (soma * porDesconto) / 100.0;
    }

    public double somaValores() {
        double soma = 0.0;
        for (ItemCompra item : listaItens) {
            soma += item.calcSubtotal();
        }
        totalCompra = soma;
        return soma;
    }
}
