package br.edu.ifma.ia.grafos.algorithms.grafo;
import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class Grafo {
    private ArrayList<Vertice> vertices = new ArrayList();

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }
    public void addVertice(Vertice v) {
        vertices.add(v);
    }
    public void iniciaVertices() {
        for(Vertice v : vertices) {
            v.setValor(null);
            v.setCor(Color.WHITE);
            v.setPai(null);
            v.setDistancia(-1);
        }
    }
    //Calcula a distancia percorrida em razÃ£o do caminho feito
    public void imprimeVerticesDoGrafo(Grafo g) {
        for(int i = 0; i<g.getVertices().size(); i++) {
            System.out.println(
                "\nValor: " + g.getVertices().get(i).getValor()+
                "\nCor: " + g.getVertices().get(i).getCor().toString()+
                "\nPai: " + g.getVertices().get(i).getPai().getValor()+
                "\nDistancia: " + g.getVertices().get(i).getDistancia()
            );
            if(g.getVertices().get(i).getVizinhos() != null) {
                for(int j=0; j<g.getVertices().get(i).getVizinhos().size(); j++) {
                    System.out.print("Vizinhos: " + g.getVertices().get(i).getVizinhos().get(j).getValor() + "\n");
                }
            }else {
                System.out.println("Vizinhos: " + g.getVertices().get(i).getVizinhos() + "\n");
            }
        }
    }
}