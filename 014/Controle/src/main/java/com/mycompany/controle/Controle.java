package com.mycompany.controle;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Controle {
    private static final int MEGABYTE = 1024 * 1024;
    private static final Map<String, Integer> usuarios = new HashMap<>();

    private static void preencheInformacoesUsuarios() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantidade de usuários: ");
        int quantidadeUsuarios = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= quantidadeUsuarios; i++) {
            System.out.print("Digite o nome do usuário " + i + ": ");
            String nomeUsuario = scanner.nextLine();

            System.out.print("Digite o espaço utilizado em MB pelo usuário " + i + ": ");
            int espacoUtilizado = scanner.nextInt();
            scanner.nextLine();

            usuarios.put(nomeUsuario, espacoUtilizado * MEGABYTE);
        }
    }

    private static double converteBytesParaMegabytes(int espacoEmBytes) {
        return (double) espacoEmBytes / MEGABYTE;
    }

    private static String criaRelatorio() {
        int quantidadeUsuarios = usuarios.size();
        int espacoTotal = calculaEspacoTotal();

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("ACME Inc.    Uso do espaço em disco pelos usuários\n");
        relatorio.append("----------------------------------------------------\n");
        relatorio.append("Nr.  Usuário        Espaço utilizado     % do uso\n");

        int numero = 1;
        for (Map.Entry<String, Integer> entry : usuarios.entrySet()) {
            String nomeUsuario = entry.getKey();
            int espacoDoUsuario = entry.getValue();
            double espacoEmMB = converteBytesParaMegabytes(espacoDoUsuario);
            double porcentagem = (double) espacoDoUsuario * 100 / espacoTotal;

            String textoNumero = String.valueOf(numero).trim();
            String textoNome = nomeUsuario.trim();
            String textoEspaco = String.format("%.2f", espacoEmMB) + " MB";
            String textoPorc = String.format("%.2f", porcentagem) + "%";

            String linha = String.format("%-5s%-15s%-20s%s\n", textoNumero, textoNome, textoEspaco, textoPorc);
            relatorio.append(linha);
            numero++;
        }

        double espacoTotalEmMB = converteBytesParaMegabytes(espacoTotal);
        relatorio.append("\nEspaco total ocupado: ").append(String.format("%.2f", espacoTotalEmMB)).append(" MB\n");
        relatorio.append("Espaco médio ocupado: ").append(String.format("%.2f", espacoTotalEmMB / quantidadeUsuarios)).append(" MB\n");

        return relatorio.toString();
    }

    private static int calculaEspacoTotal() {
        int espacoTotal = 0;
        for (int espacoDoUsuario : usuarios.values()) {
            espacoTotal += espacoDoUsuario;
        }
        return espacoTotal;
    }

   private static void escreveTextoNoArquivo(String texto, String nomeDoArquivo) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeDoArquivo))) {
        writer.write(texto);
        System.out.println("Relatório salvo no arquivo " + nomeDoArquivo);
    } catch (IOException e) {
        System.out.println("Ocorreu um erro ao salvar o relatório no arquivo:");
    }
}

    public static void main(String[] args) {
        preencheInformacoesUsuarios();
        String relatorio = criaRelatorio();

        String nomeArquivo;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o nome do arquivo para salvar o relatório: ");
            nomeArquivo = scanner.nextLine();
        }

        escreveTextoNoArquivo(relatorio, nomeArquivo);
    }
}