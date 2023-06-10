package com.mycompany.conversortemperatura;
import java.util.Scanner;

public class ConversorTemperatura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tc = leiaValorDaTemperatura(scanner, "Informe a temperatura em °C: ");
        double tf = tc * 1.8 + 32;
        System.out.printf("A temperatura de %.0f°C corresponde a %.0f°F!%n", tc, tf);

        scanner.close();
    }

    public static double leiaValorDaTemperatura(Scanner scanner, String mensagem) {
        double valor = -1;
        while (valor <= 0) {
            System.out.print(mensagem);
            valor = scanner.nextDouble();
        }
        return valor;
    }
}
