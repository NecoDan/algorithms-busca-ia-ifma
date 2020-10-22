package br.com.ifma.edu.br.ia.grafos.algorithms.busca.aprofundamento_interativo;

import br.com.ifma.edu.br.ia.grafos.algorithms.busca.aprofundamento_interativo.buscas.BuscaAprofundamentoIterativo;
import br.com.ifma.edu.br.ia.grafos.algorithms.busca.aprofundamento_interativo.problemas.ProblemaMapaRomenia;

public final class AppAprofundamentoInterativo {

    private AppAprofundamentoInterativo() {

    }

    public static void executarTesteBuscaAprofundamentoInterativo() {
        BuscaAprofundamentoIterativo agente = new BuscaAprofundamentoIterativo();
        ProblemaMapaRomenia problema = new ProblemaMapaRomenia("Oradea", "Iasi");

        agente.DFS_aprof_iter(problema);
    }
}
