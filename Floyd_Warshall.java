import java.util.*;

public class Floyd_Warshall {
    public static int min(int x, int y) {
        return x < y ? x : y;
    }

    public static void print_graph(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] shortestPath(int[][] graph) {
        int n = graph.length;
        int[][] temp = new int[n][n];

        // Initialize the distance matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    temp[i][j] = 0; // Distance to itself is 0
                else if (graph[i][j] == 0)
                    temp[i][j] = Integer.MAX_VALUE; // No direct edge
                else
                    temp[i][j] = graph[i][j]; // Use the edge weight
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (temp[i][k] != Integer.MAX_VALUE && temp[k][j] != Integer.MAX_VALUE) {
                        temp[i][j] = min(temp[i][j], temp[i][k] + temp[k][j]);
                    }
                }
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 3, 0, 5},
            {2, 0, 0, 4},
            {0, 1, 0, 0},
            {0, 0, 2, 0}
        };

        System.out.println("Shortest Path Matrix:");
        int[][] distanceMatrix = shortestPath(graph);
        print_graph(distanceMatrix);
    }
}
