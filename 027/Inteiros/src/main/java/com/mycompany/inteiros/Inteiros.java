package com.mycompany.inteiros;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inteiros {

    public static String leiaEntradaUsuario() {
        System.out.println("O formato da entrada deve ser o seguinte:");
        System.out.println("[1, 2, 3, 4, ..., 30]");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma lista de inteiros: ");
        return scanner.nextLine();
    }

    public static String removeColcheteEspacosDaString(String entrada) {
        entrada = entrada.replace("]", "");
        entrada = entrada.replace("[", "");
        entrada = entrada.replace(" ", "");
        return entrada;
    }

    public static List<Integer> converteListaStringsParaInteiros(String entrada) {
        entrada = removeColcheteEspacosDaString(entrada);

        List<Integer> inteirosEntrada = new ArrayList<>();
        if (entrada.length() > 0) {
            String[] entradaArray = entrada.split(",");

            for (String palavra : entradaArray) {
                inteirosEntrada.add(Integer.parseInt(palavra));
            }
        }
        return inteirosEntrada;
    }

    public static void efetuaOperacoes(List<Integer> inteiros) {
        if (!inteiros.isEmpty()) {
            int soma = 0;
            int menor = inteiros.get(0);
            int maior = inteiros.get(0);

            for (int i : inteiros) {
                soma += i;
                if (i < menor) {
                    menor = i;
                }
                if (i > maior) {
                    maior = i;
                }
            }

            double media = (double) soma / inteiros.size();
            System.out.println("O maior valor é " + maior);
            System.out.println("O menor valor é " + menor);
            System.out.println("A média dos valores é " + media);

        } else {
            System.out.println("A lista está vazia");
        }
    }

    public static void main(String[] args) {
        String entrada = leiaEntradaUsuario();
        List<Integer> inteirosEntrada = converteListaStringsParaInteiros(entrada);
        efetuaOperacoes(inteirosEntrada);
    }
}

