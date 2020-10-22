package br.com.ifma.edu.br.ia.grafos.algorithms.busca.bidirecional.grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private List<Aresta> arestas;
    private List<Vertice> vertices;
    private boolean hasCycle;

    public Grafo() {
        inicializar();
    }

    public void inicializar() {
        this.arestas = new ArrayList<>();
        this.vertices = new ArrayList<>();
        this.hasCycle = false;
    }

    public void clearLists() {
        this.arestas.clear();
        this.vertices.clear();
        this.hasCycle = false;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public boolean isHasCycle() {
        return hasCycle;
    }

    public void addAresta(int peso, String origem, String destino) {
        int i, j, k;

        //adiciona vertices e retorna posicao
        i = this.addVertice(origem);
        j = this.addVertice(destino);

        //adiciona aresta na lista
        Aresta a = new Aresta(peso, this.vertices.get(i), this.vertices.get(j));

        temCiclo(a);
        this.arestas.add(a);
        k = this.arestas.size();

        //adiciona aresta na lista de arestas incidentes em cada vertice
        this.vertices.get(i).addIncidentes(this.arestas.get(k - 1));
        this.vertices.get(j).addIncidentes(this.arestas.get(k - 1));
    }

    public void setArestas(List<Aresta> arestas) {
        this.clearLists();

        for (Aresta aresta : arestas) {
            int peso = aresta.getPeso();
            String origemNome = aresta.getOrigem().getNome();
            String destinoNome = aresta.getDestino().getNome();
            this.addAresta(peso, origemNome, destinoNome);
        }
    }

    public void setVertices(List<Vertice> vertices) {
        this.clearLists();

        for (Vertice vertex : vertices) {
            //se ja existir na lista nao passara daqui
            if (this.posicaoVertice(vertex.getNome()) == this.vertices.size()) {
                //adicionando as arestas correspondentes a tais vertices
                for (int j = 0; j < vertex.getIncidentes().size(); j++) {

                    //se o adicionado for a origem desse seu incidente, e o seu destino estiver na lista de vertices
                    if ((vertex.getNome().equals(vertex.getIncidentes().get(j).getOrigem().getNome())) &&
                            (this.posicaoVertice(vertex.getIncidentes().get(j).getDestino().getNome()) != this.vertices.size())) {

                        this.addAresta(vertex.getIncidentes().get(j).getPeso(),
                                vertex.getIncidentes().get(j).getOrigem().getNome(),
                                vertex.getIncidentes().get(j).getDestino().getNome());

                        //se o adicionado for o destino desse seu incidente, e o sua origem estiver na lista de vertices
                    } else if ((vertex.getNome().equals(vertex.getIncidentes().get(j).getDestino().getNome())) &&
                            (this.posicaoVertice(vertex.getIncidentes().get(j).getOrigem().getNome()) != this.vertices.size())) {

                        this.addAresta(vertex.getIncidentes().get(j).getPeso(),
                                vertex.getIncidentes().get(j).getOrigem().getNome(),
                                vertex.getIncidentes().get(j).getDestino().getNome());

                    }
                }
                this.addVertice(vertex.getNome());
            }
        }
    }

    public int addVertice(String nome) {
        int i = this.posicaoVertice(nome);

        if (i == this.vertices.size()) {
            this.vertices.add(new Vertice(nome));
            return (this.vertices.size() - 1);
        }

        return i;
    }

    public void limparVerticesPai() {
        for (int i = 0; i < this.getVertices().size(); i++)
            this.getVertices().get(i).setPai(null);
    }

    public void limparVerticeVisitado() {
        for (int i = 0; i < this.getVertices().size(); i++)
            this.getVertices().get(i).setVisitado(false);
    }

    public void limparArestaVisitada() {
        for (int i = 0; i < this.getArestas().size(); i++)
            this.getArestas().get(i).setVisitado(false);
    }

    public void imprimeArvore() {
        for (Aresta aresta : arestas) {
            System.out.print(aresta.getOrigem().getNome() + aresta.getDestino().getNome() + " - " + aresta.getPeso() + " | ");
        }
        System.out.println();
    }

    public int posicaoVertice(String nome) {
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getNome().equals(nome))
                return i;
        }

        //se nao encontrar retorna o tamanho da lista vertices
        return this.vertices.size();
    }

    public Vertice acharVertice(String nome) {
        return this.vertices.get(this.posicaoVertice(nome));
    }

    public Aresta acharAresta(Vertice vet1, Vertice vet2) {
        for (Aresta aresta : this.arestas) {
            if (((aresta.getOrigem().getNome().equals(vet1.getNome())) &&
                    (aresta.getDestino().getNome().equals(vet2.getNome()))) ||
                    ((aresta.getOrigem().getNome().equals(vet2.getNome())) &&
                            (aresta.getDestino().getNome().equals(vet1.getNome())))) {
                return aresta;
            }
        }
        return null;
    }

    public boolean temCiclo(Aresta aresta) {
        Vertice anterior = aresta.getDestino();

        for (int j = 0; j < this.getArestas().size(); j++) {
            for (int i = 0; i < this.getArestas().size(); i++) {

                if ((aresta == this.getArestas().get(i)) && (!this.getArestas().get(i).isVisitado()))
                    this.getArestas().get(i).setVisitado(true);
                else if (aresta != this.getArestas().get(i)) {

                    if (anterior.getNome().equals(this.getArestas().get(i).getOrigem().getNome())) {

                        if (aresta.getOrigem().getNome().equals(this.getArestas().get(i).getDestino().getNome())) {
                            this.limparArestaVisitada();
                            this.hasCycle = true;
                            return true;
                        } else {
                            anterior = this.getArestas().get(i).getDestino();
                            this.getArestas().get(i).setVisitado(true);
                        }

                    } else if (anterior.getNome().equals(this.getArestas().get(i).getDestino().getNome())) {

                        if (aresta.getOrigem().getNome().equals(this.getArestas().get(i).getOrigem().getNome())) {
                            this.limparArestaVisitada();
                            this.hasCycle = true;
                            return true;
                        } else {
                            anterior = this.getArestas().get(i).getOrigem();
                            this.getArestas().get(i).setVisitado(true);
                        }
                    }
                }
            }
        }
        this.limparArestaVisitada();
        this.hasCycle = false;
        return false;
    }

    public Aresta menorPeso() {
        int j;

        for (j = 0; j < this.getArestas().size(); j++) {
            if ((!this.getArestas().get(j).isVisitado())) {
                this.getArestas().get(j).setVisitado(true);

                for (int i = (j + 1); i < this.getArestas().size(); i++) {
                    if (isArestaNaoVisitadaEPesoSuperiorOutroPeso(i, j)) {
                        this.getArestas().get(j).setVisitado(false);
                        j = i;
                        this.getArestas().get(j).setVisitado(true);
                    }
                }
                break;
            }
        }

        return this.getArestas().get(j);
    }

    private boolean isArestaNaoVisitadaEPesoSuperiorOutroPeso(int i, int j) {
        return (!this.getArestas().get(i).isVisitado()) && (this.getArestas().get(j).getPeso() > this.getArestas().get(i).getPeso());
    }
}
