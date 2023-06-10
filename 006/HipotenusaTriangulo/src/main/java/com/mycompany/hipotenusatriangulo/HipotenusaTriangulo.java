package com.mycompany.hipotenusatriangulo;
import java.util.Scanner;

public class HipotenusaTriangulo {
    public static void main(String[] args) {
        double a = leiaValorCatetoPositivo("a");
        double b = leiaValorCatetoPositivo("b");

        double somaQuadradoCatetos = Math.pow(a, 2) + Math.pow(b, 2);
        double h = Math.sqrt(somaQuadradoCatetos);

        System.out.printf("O valor da hipotenusa do triângulo retângulo é %.2f%n", h);
    }

    public static double leiaValorCatetoPositivo(String nomeCateto) {
        Scanner scanner = new Scanner(System.in);
        double valorCateto = -1;

        while (valorCateto <= 0) {
            System.out.print("Digite o valor do cateto " + nomeCateto + ": ");
            valorCateto = scanner.nextDouble();
        }

        return valorCateto;
    }
}

