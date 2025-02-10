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
        for(int i=1; i<=m; i++){
            sa = br.readLine().split(" ");
            int num = Integer.parseInt(sa[0]);
            for(int j=1; j<num; j++){
                int now = Integer.parseInt(sa[j]);
                int next = Integer.parseInt(sa[j+1]);
                graph[now].add(next);
                degree[next]++;
            }
        }
        topologySort();
    }

    public static void topologySort(){
        Queue<Integer> answer = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1; i<=n; i++){
            if(degree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();
            answer.add(now);
            for(int v : graph[now]){
                degree[v]--;
                if(degree[v] == 0) q.offer(v);
            }
        }
        
        if(answer.size() != n) System.out.println(0);
        else {
            StringBuilder sb = new StringBuilder();
            while(!answer.isEmpty()){
                sb.append(answer.poll() + "\n");
            }
            System.out.println(sb);
        }
    }
}

// 위상정렬