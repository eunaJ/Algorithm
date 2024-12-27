import java.util.*;
import java.io.*;

class Main {
    static int n;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
            parent[i] = i;
        }
        for(int i=1; i<n; i++){
            String[] sa = br.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1);
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=n; i++){
            sb.append(parent[i] + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int n){
        for(Integer cur : graph[n]){
            if(parent[cur] == cur){
                parent[cur] = n;
                dfs(cur);
            }
        }
    }
}