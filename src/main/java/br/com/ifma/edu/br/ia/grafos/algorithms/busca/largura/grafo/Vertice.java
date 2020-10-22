package br.com.ifma.edu.br.ia.grafos.algorithms.busca.largura.grafo;
import java.awt.Color;
import java.util.ArrayList;

public class Vertice {
    private Color cor;
    private int distancia;
    private Vertice pai;
    private String valor;
    public ArrayList<Vertice> vizinhos = new ArrayList<>();

    public void addVizinho(Vertice v){
        this.vizinhos.add(v);
    }
    public ArrayList<Vertice> getVizinhos() {
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
        return pai;
    }
    public void setPai(Vertice pai) {
        this.pai = pai;
    }
}
