package com.mycompany.eleicaopresidencial;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EleicaoPresidencial {
    private static final Map<Integer, Map<String, Object>> votacao = new HashMap<>();
    private static int votosNulos = 0;
    private static int votosTotais = 0;

    public static void main(String[] args) {
        votacao.put(19, criarCandidato("Leonardo"));
        votacao.put(27, criarCandidato("Luizinho"));
        votacao.put(33, criarCandidato("Alfredo"));
        votacao.put(42, criarCandidato("Eymael"));
        votacao.put(500, criarCandidato("Branco"));

        boolean continuaVotacao = true;
        while (continuaVotacao) {
            int numeroVotado = leVotoEleitor();
            continuaVotacao = numeroVotado != 0;
            if (continuaVotacao) {
                contabilizaVoto(numeroVotado);
                System.out.println("Voto contabilizado!");
                pressioneEnterParaContinuar();
            }
        }

        imprimeRelatorioEleicao();
    }

    private static Map<String, Object> criarCandidato(String nome) {
        Map<String, Object> candidato = new HashMap<>();
        candidato.put("nome", nome);
        candidato.put("quantidade", 0);
        return candidato;
    }

    private static void pressioneEnterParaContinuar() {
        System.out.println("Pressione ENTER para continuar...");
        new Scanner(System.in).nextLine();
    }

    private static void imprimeMenu() {
        System.out.println("---------------------------------------------------");
        System.out.println("        Sistema de eleições presidenciais          ");
        System.out.println("---------------------------------------------------");
        System.out.println("Vote em um dos candidatos: ");
        System.out.println("   19 - Leonardo");
        System.out.println("   27 - Luizinho");
        System.out.println("   33 - Alfredo");
        System.out.println("   42 - Eymael");
        System.out.println("  500 - Voto em Branco");
        System.out.println("---------------------------------------------------");
    }

    private static boolean confirmaVoto(int numeroVotado) {
        if (votacao.containsKey(numeroVotado)) {
            String nome = (String) votacao.get(numeroVotado).get("nome");
            System.out.println("O seu voto é no candidato: " + nome);
        } else {
            System.out.println("Candidato inválido!");
        }
        System.out.print("Deseja confirmar? [s]im/[n]ão: ");
        String confirmacao = new Scanner(System.in).nextLine();
        return confirmacao.equalsIgnoreCase("s");
    }

    private static void contabilizaVoto(int numeroVotado) {
        votosTotais++;
        if (votacao.containsKey(numeroVotado)) {
            int quantidade = (int) votacao.get(numeroVotado).get("quantidade");
            votacao.get(numeroVotado).put("quantidade", quantidade + 1);
        } else {
            votosNulos++;
        }
    }

    private static void imprimeRelatorioEleicao() {
        if (votosTotais > 0) {
            int votosBrancos = (int) votacao.get(500).get("quantidade");
            int votosInvalidos = votosBrancos + votosNulos;
                        int votosValidos = votosTotais - votosInvalidos;
            clearConsole();
            System.out.println("--------------------------------------");
            System.out.println("     Votos válidos por candidato");
            System.out.println("--------------------------------------");
            for (Map.Entry<Integer, Map<String, Object>> entry : votacao.entrySet()) {
                int numero = entry.getKey();
                if (numero != 500) {
                    String nome = (String) entry.getValue().get("nome");
                    int quant = (int) entry.getValue().get("quantidade");
                    double porc = quant * 100.0 / votosValidos;
                    String msg = nome + " - " + quant + " - " + String.format("%.2f", porc) + "%";
                    System.out.println(msg);
                }
            }

            double porcBrancos = votosBrancos * 100.0 / votosTotais;
            double porcNulos = votosNulos * 100.0 / votosTotais;
            System.out.println("--------------------------------------");
            System.out.println("Votos Brancos: " + votosBrancos + " - " + String.format("%.2f", porcBrancos) + "%");
            System.out.println("Votos Nulos: " + votosNulos + " - " + String.format("%.2f", porcNulos) + "%");
        }
    }

    private static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final IOException | InterruptedException e) {
            System.out.println("Erro ao limpar o console: " + e.getMessage());
        }
    }

    private static int leVotoEleitor() {
        boolean votacaoEmAndamento = true;
        int numeroVotado = 0;
        while (votacaoEmAndamento) {
            clearConsole();
            imprimeMenu();
            System.out.print("Digite o número do candidato: ");
            numeroVotado = new Scanner(System.in).nextInt();
            boolean votoConfirmado = (numeroVotado != 0) ? confirmaVoto(numeroVotado) : true;
            votacaoEmAndamento = !votoConfirmado;
        }
        return numeroVotado;
    }
}
