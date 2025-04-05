import java.util.*;

public class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(), e = sc.nextInt();
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < v; i++) g.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt(), w = sc.nextInt();
            g.get(u).add(w);
            g.get(w).add(u); 
        }

        int start = sc.nextInt();
        boolean[] vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");
            for (int nbr : g.get(cur)) {
                if (!vis[nbr]) {
                    vis[nbr] = true;
                    q.add(nbr);
                }
            }
        }
    }
}
