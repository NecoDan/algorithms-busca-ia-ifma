

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teste {

	public static void main(String... arg) {
		int number_of_nodes, source;
		Scanner scanner = null;
		try {
			System.out.println("\r\n" + "Insira o número de nós no gráfico");
			scanner = new Scanner(System.in);
			number_of_nodes = scanner.nextInt();

			int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
			System.out.println("Insira a matriz de adjacência");
			for (int i = 1; i <= number_of_nodes; i++)
				for (int j = 1; j <= number_of_nodes; j++)
					adjacency_matrix[i][j] = scanner.nextInt();

			System.out.println("Insira a fonte do gráfico");
			source = scanner.nextInt();

			System.out.println("\r\n" + "A pesquisa transversal limitada de profundidade máxima é");
			DepthLimitedSearch depthLimitedSearch = new DepthLimitedSearch(number_of_nodes);
			depthLimitedSearch.depthLimitedSearch(adjacency_matrix, source);

		} catch (InputMismatchException inputMismatch) {
			System.out.println("\r\n" + "Formato de entrada errado");
		}
		scanner.close();
	}
}
