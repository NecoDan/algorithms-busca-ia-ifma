package br.com.ifma.edu.br.ia.grafos.algorithms.busca.largura;
import br.com.ifma.edu.br.ia.grafos.algorithms.busca.largura.busca.BuscaEmLargura;
import br.com.ifma.edu.br.ia.grafos.algorithms.busca.largura.grafo.Grafo;
import br.com.ifma.edu.br.ia.grafos.algorithms.busca.largura.grafo.Vertice;

public final class AppLargura {

    private AppLargura() {
    }

    public static void executaTesteBuscaEmLargura() {
        Grafo grafo = new Grafo();
        //cria os vertices
        Vertice vA = new Vertice();
        Vertice vB = new Vertice();
        Vertice vC = new Vertice();
        Vertice vD = new Vertice();
        Vertice vE = new Vertice();
        //adiciona vertices no grafo
        grafo.addVertice(vA);
        grafo.addVertice(vB);
        grafo.addVertice(vC);
        grafo.addVertice(vD);
        grafo.addVertice(vE);
        //inicializa atributos dos vertices
        grafo.iniciaVertices();
        //preenche os atributos dos vertices
        vA.setValor("A");
        vA.setDistancia(0);

        vB.setValor("B");
        vB.setDistancia(0);

        vC.setValor("C");
        vC.setDistancia(0);

        vD.setValor("D");
        vD.setDistancia(0);

        vE.setValor("E");
        vE.setDistancia(0);

        vA.addVizinho(vB);
        vA.addVizinho(vC);

        vB.addVizinho(vA);
        vB.addVizinho(vC);
        vB.addVizinho(vD);

        vC.addVizinho(vA); //   B
        vC.addVizinho(vB); // / | \
        vC.addVizinho(vD); //A  |  D
        vC.addVizinho(vE); // \ | /  \
                           //   C --- E
        vD.addVizinho(vB);
        vD.addVizinho(vC);
        vD.addVizinho(vE);

        vE.addVizinho(vC);
        vE.addVizinho(vD);

        BuscaEmLargura algoritmo = new BuscaEmLargura();
        Vertice destino = algoritmo.busca(vB, vE);
        algoritmo.imprimeBusca(destino);
        //grafo.imprimeVerticesDoGrafo(grafo);
    }
}
