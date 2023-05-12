package caixa;

import java.util.Scanner;

public class CaixaEletronico {
    public static void main(String[] args) {
        // Criar objetos da classe Conta
        Conta conta1 = new Conta();

        conta1.setDono("Natalia");
        conta1.setSaldo(1000.0);

        System.out.println("-------------------------------");
        System.out.println("Bem vindo ao Banco Digital\n");
        System.out.println("Saldo de " + conta1.getDono() + ": " + conta1.getSaldo());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------------- ");
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sair");
            System.out.println(">>>");

            int opcao = 0;

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nOpção inválida. Tente novamente.\n");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("\nDigite o valor que deseja sacar: ");

                    int valorSaque = 0;

                    try {
                        valorSaque = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido. Tente novamente.");
                        continue;
                    }

                    if (valorSaque > conta1.getSaldo()) {
                        System.out.println("Saldo insuficiente.");
                    } else {
                        conta1.setSaldo(conta1.getSaldo() - valorSaque);
                        System.out.println("Saque realizado com sucesso!");
                        System.out.println("Saldo atual: " + conta1.getSaldo());
                    }
                    break;

                case 2:
                    System.out.println("Digite o valor que deseja depositar: ");

                    int valorDeposito = 0;

                    try {
                        valorDeposito = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido. Tente novamente.");
                        continue;
                    }

                    conta1.setSaldo(conta1.getSaldo() + valorDeposito);
                    System.out.println("Deposito realizado com sucesso!");
                    System.out.println("Saldo atual: " + conta1.getSaldo());
                    break;

                case 3:
                    System.out.println("------------------------------------");
                    System.out.println("Obrigado por utilizar nosso banco! ;)");
                    System.out.println("------------------------------------");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }

    }

}
