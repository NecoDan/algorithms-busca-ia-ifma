package br.com.ifma.edu.br.ia.grafos.algorithms.busca.profundidade;

public final class AppProfundidade {

    private AppProfundidade() {

    }

    public static void executarTesteBuscaEmProfundidade() {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(4, 0);

        System.out.println("Following is Depth First Traversal");

        g.DFS(4);

        System.out.println("\nFollowing is Depth First Traversal (Grafico desconectado)");

        g.DFS();
    }
}
