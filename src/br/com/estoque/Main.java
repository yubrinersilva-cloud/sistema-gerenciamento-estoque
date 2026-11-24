
package br.com.estoque;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Primeiro passo: autenticação
        boolean acesso = Autenticacao.realizarLogin(entrada);

        // Se o login falhar, encerra o programa
        if (!acesso) {
            entrada.close();
            return;
        }

        // Cria o gerenciador de estoque
        GerenciadorEstoque estoque = new GerenciadorEstoque();

        // Inicializa a variável com valor 0
        int opcao = 0;

        // Menu principal
        do {

            System.out.println("\n========== SISTEMA DE ESTOQUE ==========");
            System.out.println("1 - Incluir produto");
            System.out.println("2 - Consultar produto");
            System.out.println("3 - Relatório de estoque");
            System.out.println("4 - Sair");
            System.out.println("========================================");

            System.out.print("Escolha uma opção: ");

            String escolha = entrada.nextLine();

            try {

                opcao = Integer.parseInt(escolha);

            } catch (NumberFormatException e) {

                System.out.println("\nOpção inválida! Digite um número de 1 a 4.");

                continue;
            }

            switch (opcao) {

                case 1:
                    estoque.cadastrarProduto(entrada);
                    break;

                case 2:
                    estoque.consultarProduto(entrada);
                    break;

                case 3:
                    estoque.gerarRelatorio();
                    break;

                case 4:
                    System.out.println("\nSistema encerrado. Obrigado por utilizar!");
                    break;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 4);

        entrada.close();

    }

}
