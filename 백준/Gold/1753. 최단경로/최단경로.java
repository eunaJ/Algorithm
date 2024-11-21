import java.util.*;
import java.io.*;

class Node {
    int v; // 노드 번호
    int w; // 비용

    Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int V = Integer.parseInt(sa[0]);
        int E = Integer.parseInt(sa[1]);
        int K = Integer.parseInt(br.readLine());
        ArrayList<Node>[] graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++){
            sa = br.readLine().split(" ");
            int u = Integer.parseInt(sa[0]);
            int v = Integer.parseInt(sa[1]);
            int w = Integer.parseInt(sa[2]);
            graph[u].add(new Node(v, w));
        }
        boolean[] visited = new boolean[V+1];
        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.w)); // 가중치 우선
        pq.add(new Node(K, 0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curNode = cur.v;
            int curCost = cur.w;
            if(curCost > dist[curNode]) continue;
            for(Node neighbor : graph[curNode]){
                int nextNode = neighbor.v;
                int nextCost = curCost + neighbor.w;
                if(nextCost < dist[nextNode]){
                    dist[nextNode] = nextCost;
                    pq.add(new Node(nextNode, nextCost));
                }
            }
        }
        for(int i=1; i<=V; i++){
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}