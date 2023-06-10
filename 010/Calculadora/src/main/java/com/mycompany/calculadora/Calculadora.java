package com.mycompany.calculadora;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro valor: ");
        double n1 = scanner.nextDouble();

        System.out.print("Digite o segundo valor: ");
        double n2 = scanner.nextDouble();

        Calculos calculos = new Calculos();
        double a = calculos.adicao(n1, n2);
        double b = calculos.multiplicacao(n1, calculos.potencia(n2, 2));
        double c = calculos.potencia(n1, 2);
        double d = calculos.raizQuadrada(calculos.somaDosQuadrados(n1, n2));
        double e = calculos.seno(calculos.subtracao(n1, n2));

        System.out.println("a) " + a);
        System.out.println("b) " + b);
        System.out.println("c) " + c);
        System.out.println("d) " + d);
        System.out.println("e) " + e);
    }
}






