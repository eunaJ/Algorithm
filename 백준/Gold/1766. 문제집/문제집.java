import java.util.*;
import java.io.*;

class Main {
    public static int n;
    public static int[] degree;
    public static ArrayList<Integer>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        int m = Integer.parseInt(sa[1]);
        degree = new int[n+1];
        graph = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            sa = br.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            graph[a].add(b);
            degree[b]++;
        }
        topologySort();
    }

    public static void topologySort(){
        Queue<Integer> answer = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<=n; i++){
            if(degree[i] == 0) pq.add(i);
        }
        while(!pq.isEmpty()){
            int cur = pq.poll();
            answer.add(cur);
            for(int g : graph[cur]){
                degree[g]--;
                if(degree[g] == 0) pq.add(g);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!answer.isEmpty()){
            sb.append(answer.poll() + " ");
        }
        System.out.println(sb);
    }
}