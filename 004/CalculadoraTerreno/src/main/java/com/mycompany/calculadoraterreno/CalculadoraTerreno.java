package com.mycompany.calculadoraterreno;
import java.util.Scanner;

public class CalculadoraTerreno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Qual a medida da frente do terreno? ");
        double frente = scanner.nextDouble();

        System.out.print("Qual o fundo do terreno? ");
        double fundos = scanner.nextDouble();

        double valorm2 = 7592.00;
        double area = calcularAreaTerreno(frente, fundos);
        double valorterreno = valorm2 * area;

        System.out.println("A área do terreno é: " + area);
        System.out.println("O valor do terreno é: " + valorterreno);

        scanner.close();
    }

    public static double calcularAreaTerreno(double frente, double fundos) {
        return frente * fundos;
    }
}
