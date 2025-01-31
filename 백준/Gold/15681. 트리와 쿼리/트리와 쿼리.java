import java.util.*;
import java.io.*;

class Main {
    public static int[] size, parent;
    public static ArrayList<Integer>[] graph, tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        int r = Integer.parseInt(sa[1]);
        int q = Integer.parseInt(sa[2]);
        graph = new ArrayList[n+1];
        tree = new ArrayList[n+1];
        size = new int[n+1];
        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }
        for(int i=1; i<=n-1; i++){
            sa = br.readLine().split(" ");
            int u = Integer.parseInt(sa[0]);
            int v = Integer.parseInt(sa[1]);
            graph[u].add(v);
            graph[v].add(u);
        }
        makeTree(r, -1);
        countSubtreeNodes(r);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=q; i++){
            int qn = Integer.parseInt(br.readLine());
            sb.append(size[qn] + "\n");
        }
        System.out.println(sb);
    }

    public static void makeTree(int cur, int p){
        for(int node : graph[cur]){
            if(node != p){
                tree[cur].add(node);
                parent[node] = cur;
                makeTree(node, cur);
            }
        }
    }

    public static void countSubtreeNodes(int cur){
        size[cur] = 1;
        for(int node : tree[cur]){
            countSubtreeNodes(node);
            size[cur] += size[node];
        }
    }
}

// 문제 힌트 그대로로