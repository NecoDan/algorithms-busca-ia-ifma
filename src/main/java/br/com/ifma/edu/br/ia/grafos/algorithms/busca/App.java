package br.com.ifma.edu.br.ia.grafos.algorithms.busca;

import br.com.ifma.edu.br.ia.grafos.algorithms.busca.aprofundamento_interativo.AppAprofundamentoInterativo;
import br.com.ifma.edu.br.ia.grafos.algorithms.busca.bidirecional.AppBidirecional;
import br.com.ifma.edu.br.ia.grafos.algorithms.busca.custo_uniforme.AppCustoUniforme;
import br.com.ifma.edu.br.ia.grafos.algorithms.busca.largura.AppLargura;
import br.com.ifma.edu.br.ia.grafos.algorithms.busca.profundidade.AppProfundidade;
import br.com.ifma.edu.br.ia.grafos.algorithms.busca.profundidade_limitada.AppProfundidadeLimitada;

public class App {
    public static void main(String[] args) {
        System.out.println("Em execução....");

        /* Busca em Largura - Dev Jouglas Willians*/
        AppLargura.executaTesteBuscaEmLargura();

        /* Busca Custo Uniforme - Dev Jans*/
        AppCustoUniforme.executarTesteBuscaCustoUniforme();

        /* Busca Bidirecional - Dev Daniel Santos*/
        AppBidirecional.executarTesteBuscaBiDirecional();

        /* Busca em Profundidade e Profundidade Limitada - Dev Lucas Sousa*/
        AppProfundidade.executarTesteBuscaEmProfundidade();
        AppProfundidadeLimitada.executaTesteBuscaEmProfundidadeLimitada();

        /* Busca Aprofundamento interativo - Dev John*/
        AppAprofundamentoInterativo.executarTesteBuscaAprofundamentoInterativo();

        System.out.println("Finalizada a execução....");
    }
}
