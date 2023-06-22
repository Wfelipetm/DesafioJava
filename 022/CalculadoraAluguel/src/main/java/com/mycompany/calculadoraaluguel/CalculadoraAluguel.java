package com.mycompany.calculadoraaluguel;
import java.util.Scanner;

public class CalculadoraAluguel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Digite o valor do aluguel: R$ ");
            double v_aluguel = scanner.nextDouble();
            
            System.out.print("Quantos dias de atraso: ");
            double dias_atraso = scanner.nextDouble();
            
            double valor_a_pagar = v_aluguel + multa_aluguel(v_aluguel) + multa_por_dia(v_aluguel, dias_atraso);
            
            System.out.printf("Valor a pagar com juros e multa: R$ %.2f%n", valor_a_pagar);
            
            System.out.print("Deseja calcular juros e multa novamente? [s]im ou [n]ão: ");
            String sair = scanner.next();
            
            if (sair.equalsIgnoreCase("n")) {
                break;
            }
        }
        
        scanner.close();
    }
    
    public static double multa_aluguel(double v_aluguel) {
        return 0.03 * v_aluguel;
    }
    
    public static double multa_por_dia(double v_aluguel, double dias_atraso) {
        return dias_atraso * 0.005 * v_aluguel;
    }
}
