import java.io.*;
import java.util.*;

public class ListaLigadaOperacoes {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        try {
            File file = new File("/Users/luisfelipedearrudagomes/Documents/GitHub/analise-de-desempenho./atividade1/src/arq-novo.txt");
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextLine()) {
                String[] numeros = scanner.nextLine().split(" ");
                for (String numero : numeros) {
                    lista.add(Integer.parseInt(numero));
                }
            }
            int numOperacoes = scanner.nextInt();
            scanner.nextLine(); 
            for (int i = 0; i < numOperacoes; i++) {
                String[] operacao = scanner.nextLine().split(" ");
                String comando = operacao[0];
                switch (comando) {
                    case "A": 
                        int valor = Integer.parseInt(operacao[1]);
                        int posicao = Integer.parseInt(operacao[2]);
                        if (posicao >= 0 && posicao <= lista.size()) {
                            lista.add(posicao, valor); 
                        } else {
                            System.out.println("Posição inválida: " + posicao);
                        }
                        break;
                    case "R": 
                        for (int j = 1; j < operacao.length; j++) {
                            int numero = Integer.parseInt(operacao[j]);
                            lista.removeIf(n -> n == numero);
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
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo 'arq.txt' não encontrado.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter número.");
            e.printStackTrace();
        }
    }
}
