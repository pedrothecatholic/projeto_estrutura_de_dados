public class ItemCompra {
    private Produto produto;
    private int quantidade;

    public ItemCompra(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double calcSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public void mostraItem() {
        double subtotal = calcSubtotal();
        System.out.println(produto.getDescricao() + " - R$" + produto.getPreco() + " - Quantidade: " + quantidade + " - Subtotal: R$" + subtotal);
    }
}


