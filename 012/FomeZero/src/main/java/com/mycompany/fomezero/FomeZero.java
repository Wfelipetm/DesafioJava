package com.mycompany.fomezero;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class FomeZero {
    private static final int prodStringSize = 20;
    private static final int[] codigos = {1, 2, 3, 4, 5, 6};
    private static final Map<Integer, Map<String, Object>> produtos = new HashMap<>();
    private static final Map<Integer, Integer> pedido = new HashMap<>();

    public static void main(String[] args) {
        initializeProdutos();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            imprimeMenu();
            opcao = leOpcaoDoUsuario(scanner);
            int quantidade = -1;

            if (opcao != 0) {
                quantidade = leQuantidade(scanner);
            }

            if (validaInformacoes(opcao, quantidade)) {
                registraPedido(opcao, quantidade);
            }
        }

        System.out.println("\n  Efetue o pagamento no caixa.");
        System.out.println("  Muito obrigado pelo seu pedido!");
    }

    private static void initializeProdutos() {
        produtos.put(codigos[0], Map.of("nome", "Cachorro Quente", "preco", 9.00));
        produtos.put(codigos[1], Map.of("nome", "X-Tudo", "preco", 15.00));
        produtos.put(codigos[2], Map.of("nome", "X-Infarto", "preco", 17.00));
        produtos.put(codigos[3], Map.of("nome", "Triplo X-EGG", "preco", 12.00));
        produtos.put(codigos[4], Map.of("nome", "Cheeseburguer", "preco", 7.00));
        produtos.put(codigos[5], Map.of("nome", "Refrigerante-Lata", "preco", 10.00));

        for (int codigo : codigos) {
            pedido.put(codigo, 0);
        }
    }

    private static void imprimeCardapio() {
        System.out.println("------------------------------------------");
        System.out.println("  Produto             |  Codigo  |  Preco ");
        System.out.println("------------------------------------------");

        for (int codigo : codigos) {
            Map<String, Object> produto = produtos.get(codigo);
            String nome = String.format("%-" + prodStringSize + "s", produto.get("nome"));
            double preco = (double) produto.get("preco");
            String msg = String.format("  %s|  %d     |  R$ %.2f", nome, codigo, preco);
            System.out.println(msg);
        }

        System.out.println("------------------------------------------");
    }

    private static void imprimePedido() {
    double precoTotal = 0.00;
    System.out.println("==========================================");
    System.out.println("               Seu pedido                 ");
    System.out.println("==========================================");
    System.out.println("  Produto             |  Quant   |  Preco ");
    System.out.println("------------------------------------------");

    for (int codigo : codigos) {
        int quantidade = pedido.get(codigo);

        if (quantidade > 0) {
            Map<String, Object> produto = produtos.get(codigo);
            String nome = String.format("%-" + prodStringSize + "s", produto.get("nome"));
            double preco = (double) produto.get("preco");
            String msg = String.format("  %s|  %d     |  R$ %.2f", nome, quantidade, quantidade * preco);
            System.out.println(msg);
            precoTotal += quantidade * preco;
        }
    }

    System.out.println("------------------------------------------");
    System.out.printf("  Preco Total: R$ %.2f%n", precoTotal);
    System.out.println("------------------------------------------");
}
private static void imprimeMenu() {
        imprimeCardapio();
        imprimePedido();
    }

    private static int leOpcaoDoUsuario(Scanner scanner) {
        System.out.print("Digite o codigo do produto (0 para sair): ");
        return scanner.nextInt();
    }

    private static int leQuantidade(Scanner scanner) {
        System.out.print("Digite a quantidade: ");
        return scanner.nextInt();
    }

    private static boolean validaInformacoes(int opcao, int quantidade) {
        boolean produtoExiste = containsCodigo(opcao);
        boolean quantidadeValida = quantidade > 0;

        if (!produtoExiste) {
            System.out.println("\n  Codigo de produto nao encontrado!\n");
        } else if (!quantidadeValida) {
            System.out.println("\n  Quantidade digitada eh invalida!\n");
        }

        return produtoExiste && quantidadeValida;
    }

    private static boolean containsCodigo(int codigo) {
        for (int c : codigos) {
            if (c == codigo) {
                return true;
            }
        }
        return false;
    }

    private static void registraPedido(int codigo, int quantidade) {
        pedido.put(codigo, pedido.get(codigo) + quantidade);
    }
}