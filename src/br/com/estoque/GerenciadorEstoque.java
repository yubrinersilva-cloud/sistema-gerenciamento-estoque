
package br.com.estoque;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorEstoque {

    // Lista que armazena os produtos
    private ArrayList<Produto> produtos = new ArrayList<>();

    // Método para cadastrar produtos
    public void cadastrarProduto(Scanner entrada) {

        System.out.println("\n========== CADASTRAR PRODUTO ==========");

        System.out.print("Código: ");
        int codigo = Integer.parseInt(entrada.nextLine());

        // Verifica se o código já existe
        for (Produto produto : produtos) {

            if (produto.getCodigo() == codigo) {
                System.out.println("\nJá existe um produto com esse código!");
                return;
            }
        }

        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        System.out.print("Categoria: ");
        String categoria = entrada.nextLine();

        System.out.print("Quantidade: ");
        int quantidade = Integer.parseInt(entrada.nextLine());

        System.out.print("Preço: R$ ");
        double preco = Double.parseDouble(
                entrada.nextLine().replace(",", "."));

        // Cria um novo objeto Produto
        Produto novoProduto = new Produto(
                codigo, nome, categoria, quantidade, preco);

        // Adiciona o produto à lista
        produtos.add(novoProduto);

        System.out.println("\nProduto cadastrado com sucesso!");
    }

    // Método para consultar produto pelo código
    public void consultarProduto(Scanner entrada) {

        System.out.println("\n========== CONSULTAR PRODUTO ==========");

        System.out.print("Digite o código do produto: ");
        int codigo = Integer.parseInt(entrada.nextLine());

        boolean encontrado = false;

        for (Produto produto : produtos) {

            if (produto.getCodigo() == codigo) {

                System.out.println("\nProduto encontrado!");
                System.out.println("Código: " + produto.getCodigo());
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Categoria: " + produto.getCategoria());
                System.out.println("Quantidade: " + produto.getQuantidade());
                System.out.printf("Preço: R$ %.2f%n", produto.getPreco());

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\nNenhum produto encontrado!");
        }
    }

    // Método para gerar relatório
    public void gerarRelatorio() {

        System.out.println("\n========== RELATÓRIO DE ESTOQUE ==========");

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto produto : produtos) {

            System.out.println("\n--------------------------------");
            System.out.println("Código: " + produto.getCodigo());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Categoria: " + produto.getCategoria());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.printf("Preço: R$ %.2f%n", produto.getPreco());
        }

        System.out.println("\n================================");
        System.out.println("TOTAL DE PRODUTOS CADASTRADOS: " + produtos.size());

        int totalUnidades = 0;
        double valorEstoque = 0;

        for (Produto produto : produtos) {

            totalUnidades += produto.getQuantidade();

            valorEstoque += produto.getQuantidade() * produto.getPreco();
        }

        System.out.println("TOTAL DE UNIDADES: " + totalUnidades);
        System.out.printf("VALOR TOTAL DO ESTOQUE: R$ %.2f%n", valorEstoque);

        System.out.println("================================");
    }
}
