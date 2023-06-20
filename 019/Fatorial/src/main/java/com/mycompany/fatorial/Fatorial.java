package com.mycompany.fatorial;
import java.util.Scanner;

public class Fatorial {
    public static void main(String[] args) {
        int numero = leiaNumeroInteiroPositivo();
        long fatorial = calculaFatorial(numero);
        long fatorialComLaco = calculaFatorialLaco(numero);

        System.out.println("Fatorial de " + numero + " é " + fatorial);
        System.out.println("Fatorial_com_laco de " + numero + " é " + fatorialComLaco);
    }

    public static int leiaNumeroInteiroPositivo() {
        Scanner scanner = new Scanner(System.in);
        int numero = -1;
        while (numero < 0) {
            System.out.print("Digite um número inteiro positivo: ");
            numero = scanner.nextInt();
        }
        return numero;
    }

    public static long calculaFatorial(int numero) {
        if (numero == 0) {
            return 1;
        }
        return numero * calculaFatorial(numero - 1);
    }

    public static long calculaFatorialLaco(int numero) {
        long fatorial = 1;
        for (int n = 1; n <= numero; n++) {
            fatorial *= n;
        }
        return fatorial;
    }
}

