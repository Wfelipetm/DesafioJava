package com.mycompany.despesasprojetos;
import java.util.Scanner;

public class DespesasProjetos {
    private static final int QUANTIDADE_PROJETOS = 10;
    private static double[] orcamentoProjetos = new double[QUANTIDADE_PROJETOS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int codigoProjeto = -1;

        while (codigoProjeto != 0) {
            int valor;
            String tipo;
            Object[] informacoes = leInformacoesDoUsuario();

            codigoProjeto = (int) informacoes[0];
            if (codigoProjeto == 0) {
                break;
            }
            valor = (int) informacoes[1];
            tipo = (String) informacoes[2];

            registraInformacoes(codigoProjeto, valor, tipo);
        }

        imprimeInformacoesProjeto();
    }

    private static int leCodigoProjeto() {
        Scanner scanner = new Scanner(System.in);
        int codigoProjeto = -1;
        boolean codigoProjetoValido = false;

        while (!codigoProjetoValido) {
            System.out.print("Digite o codigo do projeto[1-" + QUANTIDADE_PROJETOS + "] (ou 0 para sair): ");
            codigoProjeto = scanner.nextInt();
            codigoProjetoValido = codigoProjeto >= 0 && codigoProjeto <= QUANTIDADE_PROJETOS;
        }

        return codigoProjeto;
    }

    private static int leValor() {
        Scanner scanner = new Scanner(System.in);
        int valor = -1;
        boolean valorValido = false;

        while (!valorValido) {
            System.out.print("Digite o valor [>0]: ");
            valor = scanner.nextInt();
            valorValido = valor > 0;
        }

        return valor;
    }

    private static String leTipo() {
        Scanner scanner = new Scanner(System.in);
        String tipo = "";
        boolean tipoValido = false;

        while (!tipoValido) {
            System.out.print("Digite o tipo [R/D]: ");
            tipo = scanner.next().toUpperCase();
            tipoValido = tipo.equals("R") || tipo.equals("D");
        }

        return tipo;
    }

    private static Object[] leInformacoesDoUsuario() {
        Scanner scanner = new Scanner(System.in);
        Object[] informacoes = new Object[3];
        informacoes[0] = leCodigoProjeto();

        if ((int) informacoes[0] > 0) {
            informacoes[1] = leValor();
            informacoes[2] = leTipo();
        }

        return informacoes;
    }

    private static void registraInformacoes(int codigoProjeto, int valor, String tipo) {
        if (tipo.equals("R")) {
            orcamentoProjetos[codigoProjeto - 1] += valor;
        } else {
            orcamentoProjetos[codigoProjeto - 1] -= valor;
        }
    }

    private static void imprimeInformacoesProjeto() {
        System.out.println("------------------------");

        for (int i = 0; i < QUANTIDADE_PROJETOS; i++) {
            System.out.println("Projeto codigo " + (i + 1));
            System.out.printf("  Saldo: R$ %.2f\n", orcamentoProjetos[i]);
            System.out.println("------------------------");
        }
    }
}
