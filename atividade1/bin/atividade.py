from collections import deque

def main():
    lista = deque()
    try:
        with open("/Users/luisfelipedearrudagomes/Documents/GitHub/analise-de-desempenho./atividade1/src/arq-novo.txt", "r") as file:
            # Lê a primeira linha e adiciona os números na lista
            numeros = file.readline().strip().split(" ")
            lista.extend(map(int, numeros))

            # Lê o número de operações
            num_operacoes = int(file.readline().strip())

            # Executa cada operação
            for _ in range(num_operacoes):
                operacao = file.readline().strip().split(" ")
                comando = operacao[0]
                
                if comando == "A":  # Adiciona um valor em uma posição específica
                    valor = int(operacao[1])
                    posicao = int(operacao[2])
                    if 0 <= posicao <= len(lista):
                        lista.insert(posicao, valor)
                    else:
                        print(f"Posição inválida: {posicao}")
                
                elif comando == "R":  # Remove todos os números especificados
                    for numero_str in operacao[1:]:
                        numero = int(numero_str)
                        lista = deque([n for n in lista if n != numero])

                elif comando == "P":  # Imprime a lista atualizada
                    print("Lista atualizada:", list(lista))
                
                else:
                    print(f"Comando inválido: {comando}")

    except FileNotFoundError:
        print("Erro: Arquivo 'arq.txt' não encontrado.")
    except ValueError:
        print("Erro ao converter número.")

if __name__ == "__main__":
    main()
