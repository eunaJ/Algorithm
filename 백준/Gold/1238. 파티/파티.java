import java.util.*;
import java.io.*;

class Main {
    static int n, m, x; 
    static ArrayList<int[]>[] goList, backList;

    public static int[] dijkstra(ArrayList<int[]>[] li){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;
        boolean[] visited = new boolean[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{x, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int num = cur[0];
            if(visited[num]) continue;
            visited[num] = true;
            for(int[] l : li[num]){
                if(!visited[l[0]] && dist[l[0]] > (dist[num]+l[1])){
                    dist[l[0]] = dist[num] + l[1];
                    pq.offer(new int[]{l[0], dist[l[0]]});
                }
            }
        }
        return dist;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);
        x = Integer.parseInt(sa[2]);
        goList = new ArrayList[n+1];
        backList = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            goList[i] = new ArrayList<>();
            backList[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            sa = br.readLine().split(" ");
            int v = Integer.parseInt(sa[0]);
            int w = Integer.parseInt(sa[1]);
            int t = Integer.parseInt(sa[2]);
            goList[v].add(new int[]{w, t});  
            backList[w].add(new int[]{v, t});
        }
        int[] goResult = dijkstra(goList);
        int[] backResult = dijkstra(backList);
        int answer = 0;
        for(int i=1; i<=n; i++){
            answer = Math.max(answer, goResult[i] + backResult[i]);
        }
        System.out.println(answer);
    }
}