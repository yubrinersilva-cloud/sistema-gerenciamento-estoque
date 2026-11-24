
package br.com.estoque;

import java.util.Scanner;

public class Autenticacao {

    // Credenciais de acesso
    private static final String USUARIO = "admin";
    private static final String SENHA = "1234";

    public static boolean realizarLogin(Scanner entrada) {

        int tentativas = 3;

        while (tentativas > 0) {

            System.out.println("\n========== LOGIN ==========");

            System.out.print("Digite o usuário: ");
            String usuario = entrada.nextLine();

            System.out.print("Digite a senha: ");
            String senha = entrada.nextLine();

            if (usuario.equals(USUARIO) && senha.equals(SENHA)) {

                System.out.println("\nLogin realizado com sucesso!");
                return true;

            } else {

                tentativas--;

                if (tentativas > 0) {
                    System.out.println("\nUsuário ou senha incorretos!");
                    System.out.println("Tentativas restantes: " + tentativas);
                } else {
                    System.out.println("\nACESSO BLOQUEADO!");
                    System.out.println("Limite de tentativas excedido.");
                }
            }
        }

        return false;
    }
}
