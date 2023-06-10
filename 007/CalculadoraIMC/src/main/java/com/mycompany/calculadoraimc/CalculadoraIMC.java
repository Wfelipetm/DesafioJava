package com.mycompany.calculadoraimc;
import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double peso = leiaValorPositivo(scanner, "Digite seu peso: ");
        double altura = leiaValorPositivo(scanner, "Digite sua altura: ");

        double imc = peso / Math.pow(altura, 2);

        String mensagem = "";
        if (imc < 18.5) {
            mensagem = "Magreza";
        } else if (imc >= 18.5 && imc < 25.0) {
            mensagem = "Normal";
        } else if (imc >= 25.0 && imc < 30.0) {
            mensagem = "Sobrepeso";
        } else if (imc >= 30.0 && imc < 40.0) {
            mensagem = "Obesidade";
        } else {
            mensagem = "Obesidade grave";
        }

        System.out.printf("O valor do IMC calculado é: %.3f%n", imc);
        System.out.println("Sua categoria de IMC é: " + mensagem);
    }

    private static double leiaValorPositivo(Scanner scanner, String mensagem) {
        double valor = -1;
        while (valor <= 0) {
            System.out.print(mensagem);
            String input = scanner.nextLine();
            try {
                valor = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                valor = -1;
            }
        }
        return valor;
    }
}

