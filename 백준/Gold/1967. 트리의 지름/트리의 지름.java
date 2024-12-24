import java.util.*;
import java.io.*;

class Main {
    public static class Node{
        int idx;
        int w;
        
        Node(int idx, int w){
            this.idx = idx;
            this.w = w;
        }
    }

    static ArrayList<Node>[] tree;
    static int answer;
    static boolean[] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=1; i<n; i++){
            String[] sa = br.readLine().split(" ");
            int pIdx = Integer.parseInt(sa[0]);
            int idx = Integer.parseInt(sa[1]);
            int w = Integer.parseInt(sa[2]);
            tree[pIdx].add(new Node(idx, w));
            tree[idx].add(new Node(pIdx, w));
        }
        visit = new boolean[n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(visit, false);
            dfs(i, 0);
        }
        System.out.println(answer);
    }

    public static void dfs(int idx, int sum){
        visit[idx] = true;
        answer = Math.max(answer, sum);
        for(Node n : tree[idx]){
            if(!visit[n.idx]){
                dfs(n.idx, sum + n.w);
            }
        }
    }
}