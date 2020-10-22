package br.com.ifma.edu.br.ia.grafos.algorithms.busca.largura.grafo;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private String valor;
    /**
     * <b>WHITE</b>: Vértice não visitado e não explorado/expandido<br>
     * <b>GRAY</b>: Vértice visitado, mas não explorado/expandido<br>
     * <b>BLACK</b>: Vértice  visitado e explorado/expandido<br>
     */
    private Color cor;
    private Vertice pai;
    private int distancia;
    private List<Vertice> vizinhos = new ArrayList<>();

    public void addVizinho(Vertice vertice) {
        this.vizinhos.add(vertice);
    }
    public List<Vertice> getVizinhos() {
        return vizinhos;
    }
    public Color getCor() {
        return cor;
    }
    public void setCor(Color cor) {
        this.cor = cor;
    }
    public int getDistancia() {
        return distancia;
    }
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public Vertice getPai() {
        return this.pai;
    }
    public void setPai(Vertice pai) {
        this.pai = pai;
    }
}
