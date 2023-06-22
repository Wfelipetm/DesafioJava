package com.mycompany.jogoadivinhacao;
import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("--------------------------------------------");
        
        while (true) {
            int numero_secreto = random.nextInt(5) + 1;
            int total_de_tentativas = 4;
            int rodada = 1;
            
            while (total_de_tentativas > 0) {
                System.out.println("--------------------------------------------");
                System.out.printf("Tentativa %d de %d%n", rodada, total_de_tentativas);
                System.out.print("Tente adivinhar o número que eu pensei!: ");
                int chute = scanner.nextInt();
                
                boolean acertou = chute == numero_secreto;
                boolean maior = chute > numero_secreto;
                boolean menor = chute < numero_secreto;
                
                if (acertou) {
                    System.out.println("Parabéns, você acertou!");
                    break;
                } else if (maior) {
                    System.out.printf("O seu número é maior, tente um número menor que %d%n", chute);
                } else if (menor) {
                    System.out.printf("O seu número é menor, tente um número maior que %d%n", chute);
                }
                
                rodada++;
                total_de_tentativas--;
            }
            
            System.out.println("Fim do jogo");
            
            System.out.print("Deseja continuar no Game? [s]im ou [n]ão: ");
            String sair = scanner.next();
            
            if (sair.equals("n")) {
                break;
            }
        }
        
        scanner.close();
    }
}

