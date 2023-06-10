package com.mycompany.medianotas;
import java.util.Scanner;

public class MediaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nota primeiro Bimestre: ");
        double notaB1 = scanner.nextDouble();

        System.out.print("Nota segundo Bimestre: ");
        double notaB2 = scanner.nextDouble();

        System.out.print("Nota terceiro Bimestre: ");
        double notaB3 = scanner.nextDouble();

        System.out.print("Nota Quarto Bimestre: ");
        double notaB4 = scanner.nextDouble();

        double somaNotas = notaB1 + notaB2 + notaB3 + notaB4;
        double media = somaNotas / 4;
        System.out.println("Sua média final é: " + media);

        double mediaMinima = 6.0;
        if (media >= mediaMinima) {
            System.out.println("Você foi APROVADO!");
        } else {
            System.out.println("Você está REPROVADO!");
        }

        scanner.close();
    }
}
