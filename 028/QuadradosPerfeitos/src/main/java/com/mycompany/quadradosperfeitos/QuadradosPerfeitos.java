package com.mycompany.quadradosperfeitos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class QuadradosPerfeitos {
    public static void main(String[] args) {
    String entrada = LeiaEntradaUsuario();
    List<Integer> inteirosEntrada = ConverteListaStringsParaInteiros(entrada);
    EfetuaOperacoes(inteirosEntrada);
}

public static String LeiaEntradaUsuario() {
    System.out.println("O formato da entrada deve ser o seguinte:");
    System.out.println("[1, 2, 3, 4, ..., 30]");
    System.out.print("Digite uma lista de inteiros: ");
    Scanner scanner = new Scanner(System.in);
    String entrada = scanner.nextLine();
    scanner.close();
    return entrada;
}

public static String RemoveColcheteEspacosDaString(String entrada) {
    entrada = entrada.replace("]", "");
    entrada = entrada.replace("[", "");
    entrada = entrada.replace(" ", "");
    return entrada;
}

public static List<Integer> ConverteListaStringsParaInteiros(String entrada) {
    entrada = RemoveColcheteEspacosDaString(entrada);
    List<Integer> inteirosEntrada = new ArrayList<>();
    if (entrada.length() > 0) {
        String[] numeros = entrada.split(",");
        for (String numero : numeros) {
            inteirosEntrada.add(Integer.parseInt(numero));
        }
    }
    return inteirosEntrada;
}

public static boolean EhQuadradoPerfeito(int i) {
    int raizQuadradaTruncada = (int) Math.sqrt(i);
    return i == raizQuadradaTruncada * raizQuadradaTruncada;
}

public static void EfetuaOperacoes(List<Integer> inteiros) {
    if (!inteiros.isEmpty()) {
        List<Integer> quadradosPerfeitos = new ArrayList<>();
        for (int i : inteiros) {
            if (EhQuadradoPerfeito(i)) {
                quadradosPerfeitos.add(i);
            }
        }
        System.out.println("Os valores da lista que são quadrados perfeitos:");
        System.out.println(quadradosPerfeitos);
    } else {
        System.out.println("Lista está vazia!");
    }
}

}
