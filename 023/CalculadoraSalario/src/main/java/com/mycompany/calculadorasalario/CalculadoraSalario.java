package com.mycompany.calculadorasalario;
import java.util.Scanner;

public class CalculadoraSalario {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("--------------------------------------------");
            
            
            System.out.print("Digite o nome do funcionario: ");
            
            String nome_funcionario = scanner.nextLine();
            double dias_trabalhados = leiaValorPositivo(scanner, "Dias trabalhados: ");
            double dependente = leiaValorPositivo(scanner, "Quantos dependentes: ");
            
            double salario_bruto = calcularSalarioBruto(dias_trabalhados, dependente);
            double desconto_inss = calcularDescontoINSS(salario_bruto);
            double desconto_ir = calcularDescontoIR(salario_bruto);
            double salario_liquido = salario_bruto - desconto_inss - desconto_ir;
            
            System.out.println("-------------------------------------------");
            System.out.println("Nome do funcionario: " + nome_funcionario);
            System.out.printf("Salário bruto: R$ %.2f%n", salario_bruto);
            System.out.printf("Desconto INSS: R$ %.2f%n", desconto_inss);
            System.out.printf("Desconto IR: R$ %.2f%n", desconto_ir);
            System.out.printf("Salário Liquido: R$ %.2f%n", salario_liquido);
            System.out.println("-------------------------------------------");
        }
    }
    
    public static double leiaValorPositivo(Scanner scanner, String mensagem) {
        double valor = -1;
        while (valor < 0) {
            System.out.print(mensagem);
            valor = scanner.nextDouble();
        }
        return valor;
    }
    
    public static double calcularSalarioBruto(double dias_trabalhados, double dependente) {
        return 23.0 * dias_trabalhados + dependente * 34.0;
    }
    
    public static double calcularDescontoINSS(double salario_bruto) {
        return 0.085 * salario_bruto;
    }
    
    public static double calcularDescontoIR(double salario_bruto) {
        return 0.15 * salario_bruto;
    }
}
