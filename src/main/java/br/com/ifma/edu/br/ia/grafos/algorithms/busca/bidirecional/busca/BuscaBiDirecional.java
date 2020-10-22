package br.com.ifma.edu.br.ia.grafos.algorithms.busca.bidirecional.busca;

import br.com.ifma.edu.br.ia.grafos.algorithms.busca.bidirecional.grafo.Aresta;
import br.com.ifma.edu.br.ia.grafos.algorithms.busca.bidirecional.grafo.Grafo;
import br.com.ifma.edu.br.ia.grafos.algorithms.busca.bidirecional.grafo.Vertice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BuscaBiDirecional {

    private BuscaBiDirecional() {

    }

    public static Vertice efetuarBuscar(Grafo grafo, Vertice v1, Vertice v2) {
        return null;
    }

    public static List<Vertice> buscar(Grafo grafo, Vertice v1, Vertice v2) {
        return encontrarMenorCaminhoDijkstra(grafo, v1, v2);
    }

    //metodo que retorna o caminho menos custoso entre dois vertices a partid do algoritmo de Dijkstra
    private static List<Vertice> encontrarMenorCaminhoDijkstra(Grafo grafo, Vertice v1, Vertice v2) {
        // Atributos usados na funcao encontrarMenorCaminho

        // Lista que guarda os vertices pertencentes ao menor caminho encontrado
        List<Vertice> menorCaminho = new ArrayList<>();

        // Variavel que recebe os vertices pertencentes ao menor caminho
        Vertice verticeCaminho;

        // Variavel que guarda o vertice que esta sendo visitado
        Vertice atual;

        // Variavel que marca o vizinho do vertice atualmente visitado
        Vertice vizinho;

        // Aresta que liga o atual ao seu vizinho;
        Aresta ligacao;

        // Lista dos vertices que ainda nao foram visitados
        ArrayList<Vertice> naoVisitados = new ArrayList<>();

        // Algoritmo de Dijkstra

        // Adiciona a origem na lista do menor caminho
        menorCaminho.add(v1);

        // Colocando a distancias iniciais
        for (int i = 0; i < grafo.getVertices().size(); i++) {
            // Vertice atual tem distancia zero, e todos os outros,
            // 9999("infinita")
            if (grafo.getVertices().get(i).getNome().equals(v1.getNome())) {
                grafo.getVertices().get(i).setDistancia(0);
            } else {
                grafo.getVertices().get(i).setDistancia(9999);
            }

            // Insere o vertice na lista de vertices nao visitados
            naoVisitados.add(grafo.getVertices().get(i));
        }

        Collections.sort(naoVisitados);

        // O algoritmo continua ate que todos os vertices sejam visitados
        while (!naoVisitados.isEmpty()) {
            // Toma-se sempre o vertice com menor distancia, que eh o primeiro
            // da
            // lista

            atual = naoVisitados.get(0);
            /*
             * Para cada vizinho (cada aresta), calcula-se a sua possivel
             * distancia, somando a distancia do vertice atual com a da aresta
             * correspondente. Se essa distancia for menor que a distancia do
             * vizinho, esta eh atualizada.
             */
            for (int i = 0; i < atual.getVizinhos().size(); i++) {

                vizinho = atual.getVizinhos().get(i);

                if (!vizinho.isVisitado()) {
                    // Comparando a distância do vizinho com a possível à distância
                    ligacao = grafo.acharAresta(atual, vizinho);

                    if (vizinho.getDistancia() > (atual.getDistancia() + ligacao.getPeso())) {
                        vizinho.setDistancia(atual.getDistancia() + ligacao.getPeso());
                        vizinho.setPai(atual);

                        /*
                         * Se o vizinho eh o vertice procurado, e foi feita uma
                         * mudanca na distancia, a lista com o menor caminho
                         * anterior eh apagada, pois existe um caminho menor
                         * vertices pais, ateh o vertice origem.
                         */
                        if (vizinho == v2) {
                            menorCaminho.clear();
                            verticeCaminho = vizinho;
                            menorCaminho.add(vizinho);
                            while (verticeCaminho.getPai() != null) {
                                menorCaminho.add(verticeCaminho.getPai());
                                verticeCaminho = verticeCaminho.getPai();

                            }
                            // Ordena a lista do menor caminho, para que ele seja exibido da origem ao destino.
                            Collections.sort(menorCaminho);
                        }
                    }
                }
            }
            // Marca o vertice atual como visitado e o retira da lista de nao visitados
            atual.setVisitado(true);
            naoVisitados.remove(atual);

            // Ordena a lista, para que o vertice com menor distancia fique na primeira posicao
            Collections.sort(naoVisitados);
        }

        grafo.limparVerticesPai();
        return menorCaminho;
    }
}
