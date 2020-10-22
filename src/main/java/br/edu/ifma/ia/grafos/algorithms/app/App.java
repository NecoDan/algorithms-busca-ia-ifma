package br.edu.ifma.ia.grafos.algorithms.app;
import br.edu.ifma.ia.grafos.algorithms.busca.BuscaEmLargura;
import br.edu.ifma.ia.grafos.algorithms.grafo.Grafo;
import br.edu.ifma.ia.grafos.algorithms.grafo.Vertice;

public class App {
    public static void main(String[] args) {
        Grafo g = new Grafo();
        Vertice destino;
/*** TESTE BUSCA EM LARGURA ***/
    //cria os vertices
        Vertice vA = new Vertice();
        Vertice vB = new Vertice();
        Vertice vC = new Vertice();
        Vertice vD = new Vertice();
        Vertice vE = new Vertice();
    //adiciona vertices no grafo
        g.addVertice(vA);
        g.addVertice(vB);
        g.addVertice(vC);
        g.addVertice(vD);
        g.addVertice(vE);
    //inicializar atributos de vertices
        g.iniciaVertices();
    //Preenche os atributos nome e vizinhos dos vertices
        vA.setValor("A");
        vA.setDistancia(1);

        vB.setValor("B");
        vB.setDistancia(1);

        vC.setValor("C");
        vC.setDistancia(1);

        vD.setValor("D");
        vD.setDistancia(1);

        vE.setValor("E");

        vA.addVizinho(vB);
        vA.addVizinho(vC); //   B
                           //  /|\
        vB.addVizinho(vA); // A | D
        vB.addVizinho(vC); //  \|/ \
        vB.addVizinho(vD); //   C---E

        vC.addVizinho(vA);
        vC.addVizinho(vB);
        vC.addVizinho(vD);
        vC.addVizinho(vE);

        vD.addVizinho(vB);
        vD.addVizinho(vC);
        vD.addVizinho(vE);

        vE.addVizinho(vC);
        vE.addVizinho(vD);

        BuscaEmLargura bl = new BuscaEmLargura();
        destino = bl.busca(vB, vA);
        bl.imprimeBusca(destino);
        g.imprimeVerticesDoGrafo(g);
    }
}
