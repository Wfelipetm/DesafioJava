package com.mycompany.calculadoradetroco;

import java.util.Scanner;

public class CalculadoraDeTroco {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Valor do produto: ");
            int valorProduto = scanner.nextInt();
            
            System.out.print("Valor do cliente: ");
            int valorCliente = scanner.nextInt();
            
            int troco = valorCliente - valorProduto;
            
            if (valorCliente < valorProduto) {
                System.out.println("Valor insuficiente");
            } else {
                System.out.println("Seu troco: " + troco);
                System.out.println("Volte sempre");
            }
        }
    }
}
