import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque("Produtos.txt");
        ArrayList<ItemCompra> carrinhoItens = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Digite o código do produto (ou '99999' para finalizar a inserção): ");
            String codigo = scanner.nextLine();

            if (codigo.equals("99999")) {
                break;
            }

            Produto produto = estoque.getProdutoPorCodigo(codigo);
            if (produto != null) {
                System.out.print("Digite a quantidade desejada: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine();

                ItemCompra item = new ItemCompra(produto, quantidade);
                carrinhoItens.add(item);
                System.out.println("Produto adicionado ao carrinho.");
            } else {
                System.out.println("Produto com código " + codigo + " não encontrado.");
            }
        }
        scanner.close();

        Carrinho carrinho = new Carrinho(carrinhoItens, 10);
        double soma = carrinho.somaValores();
        double desconto = carrinho.calcDesconto(soma);
        carrinho.mostraCarrinho();
        System.out.println("Desconto aplicado: R$" + desconto);
        System.out.println("Valor a pagar: R$" + (soma - desconto));
    }
}