import java.util.*;

public class TreeDiameter {
    static List<List<Integer>> g = new ArrayList<>();
    static int dia = 0;

    static int dfs(int node, int par) {
        int h1 = 0, h2 = 0;
        for (int nbr : g.get(node)) {
            if (nbr != par) {
                int h = dfs(nbr, node);
                if (h > h1) { h2 = h1; h1 = h; }
                else if (h > h2) h2 = h;
            }
        }
        dia = Math.max(dia, h1 + h2);
        return h1 + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            g.get(u).add(v);
            g.get(v).add(u);
        }

        dfs(0, -1);
        System.out.println(dia);
    }
}
