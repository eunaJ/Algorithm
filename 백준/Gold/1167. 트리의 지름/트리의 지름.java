import java.util.*;
import java.io.*;

class Main {
    static class Node{
        int v;
        int len;
        public Node(int v, int len){
            this.v = v;
            this.len = len;
        }
    }
    
    static ArrayList<Node>[] edges;
    static int answer, can;
    static boolean[] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        edges = new ArrayList[V+1];
        for(int i=0; i<=V; i++){
            edges[i] = new ArrayList<Node>();
        }
        visit = new boolean[V+1];
        for(int i=0; i<V; i++){
            String[] sa = br.readLine().split(" ");
            int v = Integer.parseInt(sa[0]);
            for(int j=1; j<sa.length-2; j+=2){
                int w = Integer.parseInt(sa[j]);
                int d = Integer.parseInt(sa[j+1]);
                edges[v].add(new Node(w, d));
            }
        }
        // 한 정점에서 멀리 -> 그 정점에서 멀리 = 가장 긴 거리
        dfs(1, 0);
        visit = new boolean[V+1];
        dfs(can, 0);
        System.out.println(answer);
    }

    public static void dfs(int v, int len){
        if(len > answer){
            answer = len;
            can = v;
        }
        visit[v] = true;
        for(int i=0; i<edges[v].size(); i++){
            Node n = edges[v].get(i);
            if(!visit[n.v]) dfs(n.v, len+n.len);
        }
    }
}