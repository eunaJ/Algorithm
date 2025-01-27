import java.util.*;
import java.io.*;

class Main {
    public static class Node implements Comparable<Node> {
        int s;
        int e;
        int cost;

        Node(int s, int e, int cost){
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    public static int n, m, max, answer;
    public static ArrayList<Node> graph;
    public static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);
        graph = new ArrayList<>();
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
        for(int i=0; i<m; i++){
            sa = br.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            int cost = Integer.parseInt(sa[2]);
            graph.add(new Node(a, b, cost));
        }
        Collections.sort(graph);
        // kruskal
        answer = 0;
        max = 0;
        for(int i=0; i<graph.size(); i++){
            Node n = graph.get(i);
            if(find(n.s) != find(n.e)){
                union(n.s, n.e);
                answer += n.cost;
                max = n.cost;
            }
        }
        System.out.println(answer - max);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y) parent[y] = x;
    }

    public static int find(int x){
        if(x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
}