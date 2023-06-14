package com.mycompany.embaralhapalavra;
import java.util.Random;
import java.util.Scanner;

public class EmbaralhaPalavra {

    public static String embaralhaPalavraMantendoPrimeiraUltima(String palavra) {
        int tamanhoPalavra = palavra.length();
        StringBuilder novaPalavra = new StringBuilder(palavra);
        if (tamanhoPalavra > 1) {
            String meio = palavra.substring(1, tamanhoPalavra - 1);
            char[] meioArray = meio.toCharArray();
            shuffleArray(meioArray);
            novaPalavra = new StringBuilder();
            novaPalavra.append(palavra.charAt(0)).append(meioArray).append(palavra.charAt(tamanhoPalavra - 1));
        }
        return novaPalavra.toString();
    }

    private static void shuffleArray(char[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite uma palavra: ");
            String palavra = scanner.nextLine();
            String palavraEmbaralhada = embaralhaPalavraMantendoPrimeiraUltima(palavra);
            System.out.println(palavraEmbaralhada);
        }
    }
}

