public class TSP {
    static int tsp(int[][] graph, boolean[] visited, int pos, int count, int cost, int start, int n) {
        if (count == n && graph[pos][start] > 0) {
            return cost + graph[pos][start]; 
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && graph[pos][i] > 0) {
                visited[i] = true;
                int newCost = tsp(graph, visited, i, count + 1, cost + graph[pos][i], start, n);
                ans = Math.min(ans, newCost);
                visited[i] = false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
        int n = graph.length;
        boolean[] visited = new boolean[n];
        visited[0] = true; 

        int minCost = tsp(graph, visited, 0, 1, 0, 0, n);
        System.out.println("Minimum tour cost: " + minCost);
    }
}
