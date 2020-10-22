package br.com.ifma.edu.br.ia.grafos.algorithms.busca.largura.grafo;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private List<Vertice> vertices = new ArrayList<>();

    private List<Vertice> getVertices() {
        return this.vertices;
    }

    public void addVertice(Vertice vertice) {
        this.vertices.add(vertice);
    }

    public void iniciaVertices() {
        for(Vertice vertice : vertices) {
            vertice.setValor(null);
            vertice.setCor(Color.WHITE);
            vertice.setPai(null);
            vertice.setDistancia(-1);
        }
    }
    //Calcula a distancia percorrida em razão do caminho feito
    public void imprimeVerticesDoGrafo(Grafo grafo) {
        for(int i=0; i < grafo.getVertices().size(); i++) {
            System.out.println(
                "\nValor: " + grafo.getVertices().get(i).getValor()+
                "\nCor: " + grafo.getVertices().get(i).getCor().toString()+
                "\nPai: " + grafo.getVertices().get(i).getPai().getValor()+
                "\nDistancia: " + grafo.getVertices().get(i).getDistancia()
            );
            if(grafo.getVertices().get(i).getVizinhos() != null) {
                for(int j=0; j<grafo.getVertices().get(i).getVizinhos().size(); j++) {
                    System.out.print("Vizinhos: " + grafo.getVertices().get(i).getVizinhos().get(j).getValor() + "\n");
                }
            }else {
                System.out.println("Vizinhos: " + grafo.getVertices().get(i).getVizinhos() + "\n");
            }
        }
    }
}
