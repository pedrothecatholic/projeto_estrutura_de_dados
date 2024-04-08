import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Estoque {
    private ArrayList<Produto> listaProdutos;

    public Estoque(String nomeArquivo) {
        listaProdutos = new ArrayList<>();
        carregarProdutos(nomeArquivo);
    }

    private void carregarProdutos(String nomeArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                String codigo = partes[0];
                String descricao = partes[1];
                double preco = Double.parseDouble(partes[2].replace(",", "."));
                Produto produto = new Produto(codigo, descricao, preco);
                listaProdutos.add(produto);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public Produto getProdutoPorCodigo(String codigo) {
        for (Produto produto : listaProdutos) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }
}
