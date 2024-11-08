
import java.io.*;
import java.util.*;

public class ListaLigadaOperacoes2 {
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<Integer> lista = new LinkedList<>();
        File file = new File("/Users/luisfelipedearrudagomes/Documents/GitHub/analise-de-desempenho./atividade1/src/arq2.txt");
        Scanner scanner = new Scanner(file);
        if (scanner.hasNextLine()) {
            String[] numeros = scanner.nextLine().split(" ");
            for (String numero : numeros) {
                if (!numero.trim().isEmpty()) { 
                    lista.add(Integer.parseInt(numero.trim()));
                }
            }
        }
        int numOperacoes = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numOperacoes; i++) {
            String[] operacao = scanner.nextLine().split(" ");
            String comando = operacao[0];     
            switch (comando) {
                case "A": 
                    for (int j = 1; j < operacao.length; j++) {
                        if (!operacao[j].trim().isEmpty()) { 
                            lista.add(Integer.parseInt(operacao[j].trim()));
                        }
                    }
                    break;
                case "R":
                    for (int j = 1; j < operacao.length; j++) {
                        if (!operacao[j].trim().isEmpty()) {
                            int numero = Integer.parseInt(operacao[j].trim());
                            lista.removeIf(n -> n == numero);
                        }
                    }
                    break;
                case "P":
                    System.out.println("Lista atualizada: " + lista);
                    break;
                default:
                    System.out.println("Comando inválido: " + comando);
            }
        }
        scanner.close();
    }
}
