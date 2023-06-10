package com.mycompany.calculator;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Digite um número: ");
                String num1Input = scanner.nextLine();
                System.out.print("Digite um operador: ");
                String operator = scanner.nextLine();
                System.out.print("Digite outro número: ");
                String num2Input = scanner.nextLine();
                
                if (!num1Input.matches("\\d+") || !num2Input.matches("\\d+")) {
                    System.out.println("Você precisa digitar um número.");
                    continue;
                }
                
                int num1 = Integer.parseInt(num1Input);
                int num2 = Integer.parseInt(num2Input);
                
                switch (operator) {
                    case "+" -> System.out.println(num1 + num2);
                    case "-" -> System.out.println(num1 - num2);
                    case "/" -> System.out.println((double) num1 / num2);
                    case "*" -> System.out.println(num1 * num2);
                    case "**" -> System.out.println(Math.pow(num1, num2));
                    default -> System.out.println("Operador inválido.");
                }
                
                System.out.print("Deseja sair? [s]im ou [n]ão: ");
                String sair = scanner.nextLine();
                if (sair.equalsIgnoreCase("s")) {
                    break;
                }
            }
        }
    }
}

