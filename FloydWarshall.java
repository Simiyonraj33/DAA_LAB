import java.util.Scanner;

public class FloydWarshall {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int INF = 99999;

        // Input number of vertices
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        // Create matrices
        int graph[][] = new int[V][V];
        int dist[][] = new int[V][V];

        // Read adjacency matrix
        System.out.println("Enter adjacency matrix:");
        System.out.println("Use 99999 for INF");

        for (int i = 0; i < V; i++) {

            for (int j = 0; j < V; j++) {

                graph[i][j] = sc.nextInt();

                // Copy graph to dist matrix
                dist[i][j] = graph[i][j];
            }
        }

        // Floyd Warshall Algorithm
        for (int k = 0; k < V; k++) {

            for (int i = 0; i < V; i++) {

                for (int j = 0; j < V; j++) {

                    // Check shorter path through k
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {

                        dist[i][j] = dist[i][k] + dist[k][j];

                    }
                }
            }
        }

        // Print result
        System.out.println("\nShortest Distance Matrix:");

        for (int i = 0; i < V; i++) {

            for (int j = 0; j < V; j++) {

                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}