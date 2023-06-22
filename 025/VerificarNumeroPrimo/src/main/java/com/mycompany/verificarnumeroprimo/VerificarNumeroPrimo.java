package com.mycompany.verificarnumeroprimo;
import java.util.Scanner;

public class VerificarNumeroPrimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------------------");
            int n = leiaValorPositivo(scanner, "Digite um número:");
            implementa(n);
            System.out.println("------------------------------------");

            System.out.print("Deseja continuar? [s]im ou [n]ão: ");
            String sair = scanner.next();
            if (sair.equals("n")) {
                break;
            }
        }

        scanner.close();
    }

    private static int leiaValorPositivo(Scanner scanner, String mensagem) {
        int valor = -1;
        while (valor < 0) {
            System.out.print(mensagem);
            valor = scanner.nextInt();
        }
        return valor;
    }

    private static void implementa(int n) {
        if (n == 2) {
            System.out.println("2 é primo");
        } else if (n % 2 == 0) {
            System.out.println(n + " não é primo, pois 2 é o único número par primo.");
        } else {
            int x = 3;
            while (x < n) {
                if (n % x == 0) {
                    break;
                }
                x = x + 2;
            }
            if (x == n) {
                System.out.println(n + " é primo");
            } else {
                System.out.println(n + " não é primo, pois é divisível por " + x);
            }
        }
    }
}

