import java.io.*;

public class FiltrarCaracteres {
    public static void main(String[] args) {
        String inputFile = "entrada.txt"; // Nome do arquivo de entrada
        String outputFile = "saida.txt"; // Nome do arquivo de saída

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Filtrar os caracteres alfabéticos e espaços
                StringBuilder filtrado = new StringBuilder();
                for (char ch : linha.toCharArray()) {
                    if (Character.isLetter(ch) || ch == ' ') {
                        filtrado.append(ch);
                    }
                }
                // Escrever a linha filtrada no arquivo de saída
                writer.write(filtrado.toString());
                writer.newLine(); // Adiciona quebra de linha
            }
            System.out.println("Arquivo processado com sucesso! Saída em: " + outputFile);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}
