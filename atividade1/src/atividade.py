from collections import deque

def main():
    lista = deque()
    try:
        with open("/Users/luisfelipedearrudagomes/Documents/GitHub/analise-de-desempenho./atividade1/src/arq-novo.txt", "r") as file:
            numeros = file.readline().strip().split(" ")
            lista.extend(map(int, numeros))
            num_operacoes = int(file.readline().strip())
            for _ in range(num_operacoes):
                operacao = file.readline().strip().split(" ")
                comando = operacao[0]
                if comando == "A":  
                    valor = int(operacao[1])
                    posicao = int(operacao[2])
                    if 0 <= posicao <= len(lista):
                        lista.insert(posicao, valor)
                    else:
                        print(f"Posição inválida: {posicao}")
                elif comando == "R": 
                    for numero_str in operacao[1:]:
                        numero = int(numero_str)
                        lista = deque([n for n in lista if n != numero])
                elif comando == "P":  
                    print("Lista atualizada:", list(lista))
                else:
                    print(f"Comando inválido: {comando}")

    except FileNotFoundError:
        print("Erro: Arquivo 'arq.txt' não encontrado.")
    except ValueError:
        print("Erro ao converter número.")
if __name__ == "__main__":
    main()
