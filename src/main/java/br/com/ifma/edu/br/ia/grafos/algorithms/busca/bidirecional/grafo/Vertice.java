package br.com.ifma.edu.br.ia.grafos.algorithms.busca.bidirecional.grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertice implements Comparable<Vertice> {

    private String nome;
    private int distancia = 0;
    private Vertice pai;
    private List<Aresta> incidentes;
    private List<Vertice> vizinhos;
    private boolean visitado;
    private String cor;

    public Vertice(String nome) {
        inicializar();
        this.nome = nome;
    }

    public Vertice() {
        inicializar();
    }

    private void inicializar() {
        this.incidentes = new ArrayList<>();
        this.vizinhos = new ArrayList<>();
        this.visitado = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }

    public List<Aresta> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(List<Aresta> incidentes) {
        this.incidentes = incidentes;
    }

    public List<Vertice> getVizinhos() {
        return vizinhos;
    }

    public void setVizinhos(List<Vertice> vizinhos) {
        this.vizinhos = vizinhos;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void addIncidentes(Aresta incide) {
        if (Objects.isNull(incide))
            return;
        this.incidentes.add(incide);
        adicionarVizinhosToList(incide);
    }

    private void adicionarVizinhosToList(Aresta incide) {
        adicionarVizinhoDestino(incide);
        adicionarVizinhoOrigem(incide);
    }

    private void adicionarVizinhoDestino(Aresta incide) {
        if (isDeveAdicionarVizinhoDestino(incide))
            this.addVizinhos(incide.getDestino());
    }

    private boolean isDeveAdicionarVizinhoDestino(Aresta incide) {
        return (Objects.nonNull(incide) && incide.getOrigem().getNome().equals(this.getNome())) && (this.isVizinho(incide.getDestino()));
    }

    private void adicionarVizinhoOrigem(Aresta incide) {
        if (isDeveAdicionarVizinhoOrigem(incide))
            this.addVizinhos(incide.getOrigem());
    }

    private boolean isDeveAdicionarVizinhoOrigem(Aresta incide) {
        return (Objects.nonNull(incide) && incide.getDestino().getNome().equals(this.getNome())) && (this.isVizinho(incide.getOrigem()));
    }

    public void addVizinhos(Vertice vizinho) {
        this.vizinhos.add(vizinho);
    }

    public boolean isVizinho(Vertice vizinho) {
        return this.vizinhos.stream().filter(Objects::nonNull).noneMatch(vertice -> Objects.equals(vertice.getNome(), vizinho));
    }

    @Override
    public int compareTo(Vertice vertice) {
        if (this.getDistancia() < vertice.getDistancia())
            return -1;
        else if (this.getDistancia() == vertice.getDistancia())
            return 0;
        return 1;
    }

    @Override
    public String toString() {
        String s = " ";
        s += this.getNome();
        return s;
    }
}
