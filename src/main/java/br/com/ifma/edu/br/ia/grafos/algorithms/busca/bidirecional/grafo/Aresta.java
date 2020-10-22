package br.com.ifma.edu.br.ia.grafos.algorithms.busca.bidirecional.grafo;

import java.util.Objects;

public class Aresta {

    private int peso;
    private Vertice origem;
    private Vertice destino;
    private boolean visitado;

    public Aresta() {
        inicializar();
    }

    public Aresta(int peso, Vertice origem, Vertice destino) {
        inicializar();
        this.peso = peso;
        this.origem = origem;
        this.destino = destino;
    }

    private void inicializar() {
        this.peso = 0;
        this.visitado = false;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    private boolean isOrigemDestinoValidos() {
        return (Objects.nonNull(this.getOrigem()) && Objects.nonNull(this.getDestino()));
    }

    @Override
    public String toString() {
        return (isOrigemDestinoValidos()) ? this.getOrigem().getNome() + this.getDestino().getNome() : " ";
    }
}
