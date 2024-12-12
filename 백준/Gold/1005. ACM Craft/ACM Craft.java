import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            String[] sa = br.readLine().split(" ");
            int n = Integer.parseInt(sa[0]);
            int k = Integer.parseInt(sa[1]);
            sa = br.readLine().split(" ");
            int[] D = new int[n+1]; // 비용
            int[] N = new int[n+1]; // 진입 차수
            List<Integer>[] graph = new LinkedList[n+1];
            for(int j=1; j<=n; j++){
                D[j] = Integer.parseInt(sa[j-1]);
                graph[j] = new LinkedList<>();
            }
            for(int j=0; j<k; j++){
                sa = br.readLine().split(" ");
                int x = Integer.parseInt(sa[0]);
                int y = Integer.parseInt(sa[1]);
                graph[x].add(y);
                N[y]++;
            }
            int w = Integer.parseInt(br.readLine());
            long[] dp = new long[n+1]; 
            // 위상 정렬
            Queue<Integer> q = new LinkedList<>();
            for(int j=1; j<=n; j++){
                if(N[j] == 0){
                    q.offer(j);
                    dp[j] = D[j];
                }
            }
            while(!q.isEmpty()){
                int cur = q.poll();
                if(cur == w) break;
                for(int next : graph[cur]){
                    N[next]--;
                    dp[next] = Math.max(dp[next], dp[cur]+D[next]);
                    if(N[next] == 0) q.offer(next);
                }
            }
            sb.append(dp[w]).append("\n");
        }
        System.out.println(sb);
    }
}

// 위상정렬