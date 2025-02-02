import java.util.*;

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[adj.size()];
        q.add(new int[]{0, -1});
        while (!q.isEmpty()) {
            int[] point = q.remove();
            int parent = point[1];
            int node = point[0];
            if (visited[node]) {
                return true;
            }
            visited[node] = true;
            for (int i = 0; i < adj.get(node).size(); i++) {
                if (adj.get(node).get(i) != parent) {
                    q.add(new int[]{adj.get(node).get(i), node});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Graph with a cycle
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        adj1.add(new ArrayList<>(Arrays.asList(1, 2))); // Node 0
        adj1.add(new ArrayList<>(Arrays.asList(0, 2))); // Node 1
        adj1.add(new ArrayList<>(Arrays.asList(0, 1))); // Node 2
        System.out.println(solution.isCycle(adj1)); // Output: true

        // Test case 2: Graph without a cycle
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        adj2.add(new ArrayList<>(Arrays.asList(1)));    // Node 0
        adj2.add(new ArrayList<>(Arrays.asList(0, 2))); // Node 1
        adj2.add(new ArrayList<>(Arrays.asList(1)));    // Node 2
        System.out.println(solution.isCycle(adj2)); // Output: false

        // Test case 3: Disconnected graph (no cycle)
        ArrayList<ArrayList<Integer>> adj3 = new ArrayList<>();
        adj3.add(new ArrayList<>());                   // Node 0
        adj3.add(new ArrayList<>(Arrays.asList(2)));   // Node 1
        adj3.add(new ArrayList<>(Arrays.asList(1, 3))); // Node 2
        adj3.add(new ArrayList<>(Arrays.asList(2)));   // Node 3
        System.out.println(solution.isCycle(adj3)); // Output: false

        // Test case 4: Disconnected graph with a cycle
        ArrayList<ArrayList<Integer>> adj4 = new ArrayList<>();
        adj4.add(new ArrayList<>());                    // Node 0
        adj4.add(new ArrayList<>(Arrays.asList(2)));    // Node 1
        adj4.add(new ArrayList<>(Arrays.asList(1, 3))); // Node 2
        adj4.add(new ArrayList<>(Arrays.asList(2, 4))); // Node 3
        adj4.add(new ArrayList<>(Arrays.asList(3, 1))); // Node 4
        System.out.println(solution.isCycle(adj4)); // Output: true
    }
}
