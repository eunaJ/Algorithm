import java.util.*;
import java.io.*;

class Main {
    public static class City implements Comparable<City>{
        int idx;
        int cost;

        public City(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(City o){
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    static int n, m;
    static ArrayList<City>[] cities;
    static int INF = 100000000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        cities = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            cities[i] = new ArrayList<>();
        }
        String[] sa;
        for(int i=0; i<m; i++){
            sa = br.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            int cost = Integer.parseInt(sa[2]);
            cities[a].add(new City(b, cost));
        }
        sa = br.readLine().split(" ");
        int s = Integer.parseInt(sa[0]);
        int e = Integer.parseInt(sa[1]);
        dijkstra(s, e);
    }

    public static void dijkstra(int s, int e){
        boolean[] visit = new boolean[n+1];
        int[] costs = new int[n+1];
        Arrays.fill(costs, INF);
        costs[s] = 0;
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(s, 0));
        while(!pq.isEmpty()){
            int curIdx = pq.poll().idx;
            if(visit[curIdx]) continue;
            visit[curIdx] = true;
            for(City city : cities[curIdx]){
                if(costs[city.idx] > costs[curIdx] + city.cost){
                    costs[city.idx] = costs[curIdx] + city.cost;
                    pq.offer(new City(city.idx, costs[city.idx]));
                }
            }
        }
        System.out.println(costs[e]);
    }
}