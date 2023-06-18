import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class App {
    public static String leTextoDoArquivo(String nomeDoArquivo) throws IOException {
        StringBuilder texto;
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeDoArquivo))) {
            texto = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                texto.append(line);
            }
        }
        return texto.toString();
    }
    
    public static void escreveTextoNoArquivo(String texto, String nomeDoArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeDoArquivo))) {
            writer.write(texto);
        }
    }
    
    public static String embaralhaPalavraMantendoPrimeiraUltima(String palavra) {
        int tamanhoPalavra = palavra.length();
        StringBuilder novaPalavra = new StringBuilder(palavra);
        if (tamanhoPalavra > 1) {
            String meio = palavra.substring(1, tamanhoPalavra - 1);
            char[] novoMeio = meio.toCharArray();
            Random random = new Random();
            for (int i = 0; i < novoMeio.length; i++) {
                int j = random.nextInt(novoMeio.length);
                char temp = novoMeio[i];
                novoMeio[i] = novoMeio[j];
                novoMeio[j] = temp;
            }
            novaPalavra = new StringBuilder(palavra.charAt(0) + new String(novoMeio) + palavra.charAt(tamanhoPalavra - 1));
        }
        return novaPalavra.toString();
    }
    
    public static void main(String[] args) {
        try {
            String texto = leTextoDoArquivo("entrada.txt");
            StringBuilder novoTexto = new StringBuilder();
            String[] palavras = texto.split(" ");
            for (String palavra : palavras) {
                novoTexto.append(embaralhaPalavraMantendoPrimeiraUltima(palavra)).append(" ");
            }
            escreveTextoNoArquivo(novoTexto.toString(), "saida.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
