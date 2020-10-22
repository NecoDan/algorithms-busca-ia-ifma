package br.com.ifma.edu.br.ia.grafos.algorithms.busca.profundidade_limitada.busca;

import java.util.Stack;

public class DepthLimitedSearch {

    private Stack<Integer> stack;
    private int numberOfNodes;
    private static final int MAX_DEPTH = 3;

    public DepthLimitedSearch(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        this.stack = new Stack<Integer>();
    }

    public void depthLimitedSearch(int adjacencyMatrix[][], int source) {
        int visited[] = new int[numberOfNodes + 1];
        int element, destination;
        int depth = 0;

        System.out.println(source + " em profundidade " + depth);
        stack.push(source);
        visited[source] = 1;
        depth = 0;

        while (!stack.isEmpty()) {
            element = stack.peek();
            destination = element;
            while (destination <= numberOfNodes) {
                if (depth < MAX_DEPTH) {
                    if (adjacencyMatrix[element][destination] == 1 && visited[destination] == 0) {
                        stack.push(destination);
                        visited[destination] = 1;
                        depth++;
                        System.out.println(destination + " em profundidade " + depth);
                        element = destination;
                        destination = 1;
                    }
                } else {
                    return;
                }
                destination++;
            }
            stack.pop();
            depth--;
        }
    }
}
