package com.mycompany.calculadoradiastrabalhados;
import java.util.Scanner;

public class CalculadoraDiasTrabalhados {
    public static void main(String[] args) {
        int diasTrabalhados = obterQuantidadeDiasTrabalhados();
        calcularAnosMesesDias(diasTrabalhados);
    }

    public static int obterQuantidadeDiasTrabalhados() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade de dias trabalhados: ");
        int diasTrabalhados = -1;
        while (diasTrabalhados <= 0) {
            diasTrabalhados = scanner.nextInt();
        }
        return diasTrabalhados;
    }

    public static void calcularAnosMesesDias(int diasTrabalhados) {
        int anos = 0;
        while ((diasTrabalhados - 365) >= 0) {
            diasTrabalhados -= 365;
            anos++;
        }

        int meses = 0;
        while ((diasTrabalhados - 30) >= 0) {
            diasTrabalhados -= 30;
            meses++;
        }

        System.out.printf("%d anos, %d meses, %d dias", anos, meses, diasTrabalhados);
    }
}

