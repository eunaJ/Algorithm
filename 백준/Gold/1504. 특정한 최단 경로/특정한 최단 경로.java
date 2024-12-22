import java.util.*;
import java.io.*;

class Main {
    public static class Node implements Comparable<Node>{
        int idx;
        int distance;

        Node(int idx, int distance){
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o){
            return this.distance - o.distance;
        }
    }

    static final int INF = 200000000;
    static int n, e, answer;
    static ArrayList<Node>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        e = Integer.parseInt(sa[1]);
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<e; i++){
            sa = br.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            int c = Integer.parseInt(sa[2]);
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        sa = br.readLine().split(" ");
        int v1 = Integer.parseInt(sa[0]);
        int v2 = Integer.parseInt(sa[1]);
        int[] d1 = dijkstra(1);
        int[] dv1 = dijkstra(v1);
        int[] dv2 = dijkstra(v2);
        int sum1 = d1[v1] + dv1[v2] + dv2[n];
        int sum2 = d1[v2] + dv2[v1] + dv1[n];
        if(sum1 >= INF && sum2 >= INF) System.out.println(-1);
        else System.out.println(Math.min(sum1, sum2));
    }

    public static int[] dijkstra(int s){
        int[] dist = new int[n+1];
        boolean[] visit = new boolean[n+1];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));
        while(!pq.isEmpty()){
            int curIdx = pq.poll().idx;
            if(visit[curIdx]) continue;
            visit[curIdx] = true;
            for(Node next : graph[curIdx]){
                if(dist[next.idx] > dist[curIdx]+next.distance){
                    dist[next.idx] = dist[curIdx] + next.distance;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        return dist;
    }
}