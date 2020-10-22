package br.com.ifma.edu.br.ia.grafos.algorithms.busca.custo_uniforme.busca;

import br.com.ifma.edu.br.ia.grafos.algorithms.busca.custo_uniforme.no.No;

import java.util.*;

public class BuscaCustoUniforme {

    private final PriorityQueue<No> filaPrioritaria;
    private final Set<Integer> visitado;
    private final int[] distancias;
    private final int numeroNos;
    private int[][] matriz;
    private final LinkedList<Integer> caminho;
    private final int[] pai;
    private int origem;
    private int destino;
    public static final int MAX_VALOR = 999;

    public BuscaCustoUniforme(int numeroNos) {
        this.filaPrioritaria = new PriorityQueue<>(numeroNos, new No());
        this.visitado = new HashSet<>();
        this.caminho = new LinkedList<>();
        this.numeroNos = numeroNos;
        this.matriz = new int[numeroNos + 1][numeroNos + 1];
        this.distancias = new int[numeroNos + 1];
        this.pai = new int[numeroNos + 1];
    }

    public int buscaDeCustoUniforme(int[][] matriz, int origem, int destino) {
        int noAtual;
        this.origem = origem;
        this.destino = destino;

        for (int i = 1; i <= numeroNos; i++) {
            distancias[i] = MAX_VALOR;
        }

        this.matriz = Arrays.stream(matriz).map(int[]::clone).toArray(int[][]::new);

        filaPrioritaria.add(new No(origem, 0));
        distancias[origem] = 0;

        while(!filaPrioritaria.isEmpty()) {
            noAtual = recuperarNoComAMenorDistancia();
            System.out.println("O no atual eh " + noAtual);
            if(noAtual == destino) {
                return distancias[destino];
            }
            visitado.add(noAtual);
            adicionarFronteirasNaFila(noAtual);
        }
        return distancias[destino];
    }

    private int recuperarNoComAMenorDistancia() {
        No no = filaPrioritaria.remove();
        return no.getNo();
    }

    private void adicionarFronteirasNaFila(int noAtual) {
        for (int destinacao = 1; destinacao <= numeroNos; destinacao++) {
            if (!visitado.contains(destinacao) && matriz[noAtual][destinacao] != MAX_VALOR) {
                if (distancias[destinacao] > matriz[noAtual][destinacao] + distancias[noAtual]) {
                    distancias[destinacao] = matriz[noAtual][destinacao] + distancias[noAtual];
                    pai[destinacao] = noAtual;
                }

                No no = new No(destinacao, distancias[destinacao]);
                filaPrioritaria.remove(no);
                filaPrioritaria.add(no);
            }
        }
    }

    public void imprimirCaminho() {
        caminho.add(destino);
        boolean encontrou = false;
        int vertice = destino;
        while(!encontrou) {
            if(vertice == origem) {
                encontrou = true;
                continue;
            }
            caminho.add(pai[vertice]);
            vertice = pai[vertice];
        }

        System.out.println("O caminho entre " + origem + " e " + destino+ " eh ");
        Iterator<Integer> iterator = caminho.descendingIterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");
        }
    }
}
