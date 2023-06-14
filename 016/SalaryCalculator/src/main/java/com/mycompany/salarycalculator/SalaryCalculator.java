package com.mycompany.salarycalculator;
import java.util.Scanner;

public class SalaryCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o salario inicial: R$ ");
        float salarioInicial = scanner.nextFloat();
        
        System.out.print("Digite o ano de contratacao: ");
        int anoContratacao = scanner.nextInt();
        
        System.out.print("Digite o ano que voce quer saber o salario: ");
        int anoFinal = scanner.nextInt();
        
        int diferencaAnos = anoFinal - anoContratacao;
        float porcentagemAumento = 0.015f;
        float proporcaoAumentoTaxaAnual = 0.10f;
        float salario = salarioInicial;
        
        for (int i = 0; i < diferencaAnos; i++) {
            salario += salario * porcentagemAumento;
            porcentagemAumento += porcentagemAumento * proporcaoAumentoTaxaAnual;
        }
        
        System.out.printf("O salario do funcionario em %d sera R$ %.2f", anoFinal, salario);
    }
}
