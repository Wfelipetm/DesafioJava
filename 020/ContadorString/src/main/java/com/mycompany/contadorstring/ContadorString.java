package com.mycompany.contadorstring;
import java.util.Scanner;

public class ContadorString {
    public static int quantidadeString(String string) {
        return string.length();
    }

    public static int contaPontuacao(String string) {
        String pontuacao = ",!";
        int contador = 0;
        String lowerCaseString = string.toLowerCase();

        for (int i = 0; i < string.length(); i++) {
            if (pontuacao.contains(String.valueOf(lowerCaseString.charAt(i)))) {
                contador++;
            }
        }

        return contador;
    }

    public static int contaNumeros(String string) {
        String numeros = "0123456789";
        int contador = 0;
        String lowerCaseString = string.toLowerCase();

        for (int i = 0; i < string.length(); i++) {
            if (numeros.contains(String.valueOf(lowerCaseString.charAt(i)))) {
                contador++;
            }
        }

        return contador;
    }

    public static int contaVogais(String string) {
        String vogais = "aeiou";
        int contador = 0;
        String lowerCaseString = string.toLowerCase();

        for (int i = 0; i < string.length(); i++) {
            if (vogais.contains(String.valueOf(lowerCaseString.charAt(i)))) {
                contador++;
            }
        }

        return contador;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine();
        scanner.close();

        int q = quantidadeString(frase);
        int p = contaPontuacao(frase);
        int n = contaNumeros(frase);
        int v = contaVogais(frase);

        System.out.println("a) Quantidade de caracteres na string: " + q);
        System.out.println("b) Quantidade de caracteres de pontuação: " + p);
        System.out.println("c) Quantidade de caracteres numéricos: " + n);
        System.out.println("d) Quantidade de caracteres vogais: " + v);
    }
}
