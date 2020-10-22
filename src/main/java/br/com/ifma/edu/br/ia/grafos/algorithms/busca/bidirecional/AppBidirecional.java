package br.com.ifma.edu.br.ia.grafos.algorithms.busca.bidirecional;

<<<<<<< HEAD
import br.com.ifma.edu.br.ia.grafos.algorithms.busca.bidirecional.busca.BuscaBiDirecional;
import br.com.ifma.edu.br.ia.grafos.algorithms.busca.bidirecional.grafo.Grafo;
import br.com.ifma.edu.br.ia.grafos.algorithms.busca.bidirecional.grafo.Vertice;
import br.com.ifma.edu.br.ia.grafos.algorithms.busca.util.Keyboard;

public final class AppBidirecional {

    private AppBidirecional() {

    }

    public static void executarTesteBuscaBiDirecional() {
        Grafo inicial = new Grafo();
        Grafo resultado = new Grafo();

        Vertice verticeAux1, verticeAux2;
        int opcao = 5, peso;
        String origem, destino;

        while (opcao != 0) {
            System.out.println("\n1 - Add vertices e aresta");
            System.out.println("2 - Imprimir Grafo dado");
            System.out.println("3 - Buscar o menor caminho via bidirecional");
            System.out.println("0 - fim");

            System.out.println("\nDigite a opção desejada:");
            opcao = Keyboard.readInt();

            //dando um reset no grafo de resultado
            resultado.clearLists();

            //limpando verificadores booleanos
            inicial.limparArestaVisitada();
            inicial.limparVerticeVisitado();

            switch (opcao) {
                case 1:
                    System.out.println("Qual o peso?");
                    peso = Keyboard.readInt();

                    System.out.println("Digite o valor de origem:");
                    origem = Keyboard.readString();

                    System.out.println("Digite o valor de destino:");
                    destino = Keyboard.readString();

                    inicial.addAresta(peso, origem, destino);
                    inicial.imprimeArvore();
                    break;
                case 2:
                    inicial.imprimeArvore();
                    break;
                case 3:
                    //Algoritmo de Dijkstra - Busca BiDirecional - Busca menor caminho
                    System.out.println("Digite o valor do nodo/vertice inicio:");
                    verticeAux1 = inicial.acharVertice(Keyboard.readString());

                    System.out.println("Digite o valor do nodo/vertice fim:");
                    verticeAux2 = inicial.acharVertice(Keyboard.readString());

                    resultado.setVertices(BuscaBiDirecional.buscar(inicial, verticeAux1, verticeAux2));
                    System.out.println(resultado.getVertices());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("invalido");
                    break;
            }
        }
    }
=======
public class AppBidirecional {

>>>>>>> master
}
