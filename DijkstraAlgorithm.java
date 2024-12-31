import java.util.*;

public class DijkstraAlgorithm {

    public static int[] DijkstraAlgorithmShortestPath(List<List<int[]>> graph,int vertice){
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[1], b[1]));
        int[] dist_array=new int[graph.size()];
        dist_array[vertice]=0;
        for (int i = 0; i < dist_array.length; i++) {
            dist_array[i]=Integer.MAX_VALUE;
        }
        pq.add(new int[]{vertice,0});
        while(!pq.isEmpty()){
            int[] shortest_optimal=pq.poll();
            for (int i = 0; i <graph.get(shortest_optimal[0]).size(); i++) {
                if(
                    (dist_array[(shortest_optimal[0])] 
                        + graph.get(shortest_optimal[0]).get(i)[1] 
                        < dist_array[graph.get(shortest_optimal[0]).get(i)[0]])
                    || 
                    (dist_array[graph.get(shortest_optimal[0]).get(i)[0]] == Integer.MAX_VALUE)
                ) {
                    dist_array[graph.get(shortest_optimal[0]).get(i)[0]]=dist_array[(shortest_optimal[0])] 
                    + graph.get(shortest_optimal[0]).get(i)[1] ;
                }
            }
        }
            return dist_array;
    }
    public static void main(String[] args) {
        // Creating the adjacency list for the graph
        List<List<int[]>> graph = new ArrayList<>();

        // Initialize adjacency list for all 9 nodes (0 to 8)
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph (source, destination, weight)
        graph.get(0).add(new int[]{1, 4});
        graph.get(0).add(new int[]{7, 8});

        graph.get(1).add(new int[]{0, 4});
        graph.get(1).add(new int[]{2, 8});
        graph.get(1).add(new int[]{7, 11});

        graph.get(2).add(new int[]{1, 8});
        graph.get(2).add(new int[]{3, 7});
        graph.get(2).add(new int[]{5, 4});
        graph.get(2).add(new int[]{8, 2});

        graph.get(3).add(new int[]{2, 7});
        graph.get(3).add(new int[]{4, 9});
        graph.get(3).add(new int[]{5, 14});

        graph.get(4).add(new int[]{3, 9});
        graph.get(4).add(new int[]{5, 10});

        graph.get(5).add(new int[]{2, 4});
        graph.get(5).add(new int[]{3, 14});
        graph.get(5).add(new int[]{4, 10});
        graph.get(5).add(new int[]{6, 2});

        graph.get(6).add(new int[]{5, 2});
        graph.get(6).add(new int[]{7, 1});
        graph.get(6).add(new int[]{8, 6});

        graph.get(7).add(new int[]{0, 8});
        graph.get(7).add(new int[]{1, 11});
        graph.get(7).add(new int[]{6, 1});
        graph.get(7).add(new int[]{8, 7});

        graph.get(8).add(new int[]{2, 2});
        graph.get(8).add(new int[]{6, 6});
        graph.get(8).add(new int[]{7, 7});

        int[] dist=DijkstraAlgorithmShortestPath(graph,2);
        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i]);
        }
    }

}
