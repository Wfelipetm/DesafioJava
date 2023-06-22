package com.mycompany.palavramaior;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PalavraMaior {
    public static void lerPalavra(List<String> palavras) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite uma palavra: ");
        String palavra = scanner.nextLine();
        palavras.add(palavra);
    }

    public static boolean perguntarContinuarLeitura() {
        Scanner scanner = new Scanner(System.in);
        String resposta;
        while (true) {
            System.out.print("Continuar lendo? [s]im/[n]ão: ");
            resposta = scanner.nextLine();
            if (resposta.equals("s") || resposta.equals("n")) {
                break;
            }
        }
        return resposta.equals("s");
    }

    public static void ordenaPalavrasPorTamanhoEmOrdemDescrescente(List<String> palavras) {
        Collections.sort(palavras, (a, b) -> Integer.compare(b.length(), a.length()));
    }

    public static void preencheMaioresPalavras(List<String> palavras, List<String> maioresPalavras) {
        int tamanhoMaiorPalavra = palavras.get(0).length();
        for (String palavra : palavras) {
            int tamanhoPalavra = palavra.length();
            if (tamanhoPalavra == tamanhoMaiorPalavra) {
                maioresPalavras.add(palavra);
            } else {
                break;
            }
        }
    }

    public static void imprimeResultado(List<String> maioresPalavras) {
        System.out.println("\n");
        boolean multiplasPalavras = maioresPalavras.size() > 1;
        if (multiplasPalavras) {
            System.out.print("As maiores palavras são: ");
        } else {
            System.out.print("A maior palavra é: ");
        }
        for (String palavra : maioresPalavras) {
            System.out.println(palavra);
        }
    }

    public static void palavraMaior() {
        List<String> palavras = new ArrayList<>();
        boolean continuarLendo = true;
        while (continuarLendo) {
            lerPalavra(palavras);
            continuarLendo = perguntarContinuarLeitura();
        }
        ordenaPalavrasPorTamanhoEmOrdemDescrescente(palavras);

        List<String> maioresPalavras = new ArrayList<>();
        preencheMaioresPalavras(palavras, maioresPalavras);
        imprimeResultado(maioresPalavras);
    }

    public static void main(String[] args) {
        palavraMaior();
    }
}

