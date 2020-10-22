package br.com.ifma.edu.br.ia.grafos.algorithms.busca.custo_uniforme;

import br.com.ifma.edu.br.ia.grafos.algorithms.busca.custo_uniforme.busca.BuscaCustoUniforme;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class AppCustoUniforme {

    public static final int MAX_VALUE = 999;

    private AppCustoUniforme() {

    }

    public static void executarTesteBuscaCustoUniforme() {
        int[][] matriz;
        int numeroVertices;
        int origem = 0;
        int destino = 0;
        int distancia;
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Entre com o numero de vertices");
            numeroVertices = scan.nextInt();

            matriz = new int[numeroVertices+1][numeroVertices+1];
            System.out.println("Insira a matriz para o grafico");
            for (int i = 1; i <= numeroVertices; i++) {
                for (int j=1; j <= numeroVertices; j++) {
                    matriz[i][j] = scan.nextInt();
                    if(i==j) {
                        matriz[i][j] = 0;
                        continue;
                    }
                    if (matriz[i][j] == 0) {
                        matriz[i][j] = MAX_VALUE;
                    }
                }
            }

            System.out.println("Insira a origem ");
            origem = scan.nextInt();
            System.out.println("Insira o destino ");
            destino = scan.nextInt();

            BuscaCustoUniforme buscaCustoUniforme = new BuscaCustoUniforme(numeroVertices);
            distancia = buscaCustoUniforme.buscaDeCustoUniforme(matriz, origem, destino);
            buscaCustoUniforme.imprimirCaminho();

            System.out.println("\nA distancia entre a origem " + origem +
                    " e o destino " + destino + " is " + distancia);
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Entrada inserida invalida");
        }
        scan.close();
    }
}
