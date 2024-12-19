import java.util.*;
import java.io.*;

class Main {
    static ArrayList<int[]>[] graph;
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            String[] sa = br.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            int c = Integer.parseInt(sa[2]);
            graph[a].add(new int[]{b, c});
        }
        String[] sa = br.readLine().split(" ");
        int s = Integer.parseInt(sa[0]);
        int e = Integer.parseInt(sa[1]);
        dijkstra(s, e);
    }

    public static void dijkstra(int s, int e){
        boolean[] visit = new boolean[n+1];
        int[] cost = new int[n+1];
        int[] prev = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]);
        pq.offer(new int[]{s, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int to = cur[0];
            int w = cur[1];
            if(cost[to] < w) continue;
            for(int[] next : graph[to]){
                if(cost[next[0]] > cost[to]+next[1]){
                    cost[next[0]] = cost[to] + next[1];
                    prev[next[0]] = to;
                    pq.offer(new int[]{next[0], cost[next[0]]});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cost[e]+"\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(e);
        int cnt = 0;
        while(prev[e] != 0){
            stack.push(prev[e]);
            e = prev[e];
            cnt++;
        }
        cnt++;
        sb.append(cnt+"\n");
        while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
        System.out.println(sb);
    }
}

// dijkstra, stack