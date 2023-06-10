package com.mycompany.menormaior;
import java.util.Scanner;

public class MenorMaior {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro valor: ");
        int a = scanner.nextInt();

        System.out.print("Digite o segundo valor: ");
        int b = scanner.nextInt();

        System.out.print("Digite o terceiro valor: ");
        int c = scanner.nextInt();

        int menor = a;
        if (b < a && b < c) {
            menor = b;
        }
        if (c < a && c < b) {
            menor = c;
        }

        int maior = a;
        if (b > a && b > c) {
            maior = b;
        }
        if (c > a && c > b) {
            maior = c;
        }

        System.out.println("O menor valor foi " + menor);
        System.out.println("O maior valor foi " + maior);

        scanner.close();
    }
}

