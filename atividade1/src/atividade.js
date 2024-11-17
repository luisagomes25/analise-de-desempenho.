const fs = require('fs');

function main() {
    let lista = [];

    try {
        const data = fs.readFileSync("/Users/luisfelipedearrudagomes/Documents/GitHub/analise-de-desempenho./atividade1/src/arq-novo.txt", "utf-8");
        const lines = data.split("\n");

        const numeros = lines[0].split(" ").map(Number);
        lista = lista.concat(numeros);

        const numOperacoes = parseInt(lines[1]);

        for (let i = 2; i < 2 + numOperacoes; i++) {
            const operacao = lines[i].split(" ");
            const comando = operacao[0];

            if (comando === "A") {  // Adicionar valor
                const valor = parseInt(operacao[1]);
                const posicao = parseInt(operacao[2]);
                if (posicao >= 0 && posicao <= lista.length) {
                    lista.splice(posicao, 0, valor);
                } else {
                    console.log(`Posição inválida: ${posicao}`);
                }
            } else if (comando === "R") {  // Remover valores
                for (let j = 1; j < operacao.length; j++) {
                    const numero = parseInt(operacao[j]);
                    lista = lista.filter(n => n !== numero);
                }
            } else if (comando === "P") {  // Imprimir lista
                console.log("Lista atualizada:", lista.join(" "));
            } else {
                console.log(`Comando inválido: ${comando}`);
            }
        }
    } catch (err) {
        if (err.code === 'ENOENT') {
            console.log("Erro: Arquivo 'arq-novo.txt' não encontrado.");
        } else if (err instanceof Error && err.message.includes('invalid') ) {
            console.log("Erro ao converter número.");
        } else {
            console.log(err.message);
        }
    }
}

main();
