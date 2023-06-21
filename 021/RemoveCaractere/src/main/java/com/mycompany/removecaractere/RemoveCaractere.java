package com.mycompany.removecaractere;
import java.util.Scanner;

public class RemoveCaractere {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("--------------------------------------------------------");
                String string = getStringFromUser(scanner, "Digite uma string: ");
                String caractere = getStringFromUser(scanner, "Digite um caractere para remover: ");
                
                for (int i = 0; i < caractere.length(); i++) {
                    string = string.replace(Character.toString(caractere.charAt(i)), "");
                }
                
                System.out.println(string);
                
                String sair = getStringFromUser(scanner, "Deseja remover outro caractere? [s]im ou [n]ão: ");
                
                if (sair.equals("n")) {
                    break;
                }
            }
        }
    }
    
    private static String getStringFromUser(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}

// Eu tenho um coelho que se chama Anestor.