package com.mycompany.deuman;

import java.util.Scanner;

public class DeUmAn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = -1;

        while (n <= 0) {
            System.out.print("Digite um número positivo: ");
            n = scanner.nextInt();
        }

        int soma = 0;
        for (int i = 1; i <= n; i++) {
            soma += i;
        }

        System.out.println("O valor da soma de 1 até " + n + " é " + soma);
    }
}
