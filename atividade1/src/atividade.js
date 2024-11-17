const fs = require('fs');

function main() {
    let lista = [];

    try {
        const filePath = "/Users/luisfelipedearrudagomes/Documents/GitHub/analise-de-desempenho./atividade1/src/arq-novo.txt";
        const data = fs.readFileSync(filePath, 'utf8');
        const lines = data.split('\n');
        if (lines.length > 0) {
            const numeros = lines[0].split(" ");
            lista = numeros.map(Number);
        }
        const numOperacoes = parseInt(lines[1], 10);
        for (let i = 0; i < numOperacoes; i++) {
            const operacao = lines[i + 2].split(" ");
            const comando = operacao[0];

            switch (comando) {
                case "A": 
                    const valor = parseInt(operacao[1], 10);
                    const posicao = parseInt(operacao[2], 10);

                    if (posicao >= 0 && posicao <= lista.length) {
                        lista.splice(posicao, 0, valor); 
                        console.log(`Adicionado ${valor} na posição ${posicao}. Lista:`, lista);
                    } else {
                        console.log(`Posição inválida: ${posicao}`);
                    }
                    break;
                case "R": 
                    for (let j = 1; j < operacao.length; j++) {
                        const numero = parseInt(operacao[j], 10);
                        lista = lista.filter(n => n !== numero);
                        console.log(`Removido ${numero}. Lista:`, lista);
                    }
                    break;
                case "P": 
                    console.log("Lista atualizada:", lista);
                    break;
                default:
                    console.log(`Comando inválido: ${comando}`);
            }
        }
    } catch (err) {
        console.error("Erro ao processar o arquivo:", err.message);
    }
}
main();
