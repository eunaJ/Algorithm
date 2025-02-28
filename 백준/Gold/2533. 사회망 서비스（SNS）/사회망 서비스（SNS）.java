import java.util.*;
import java.io.*;

class Main {
    public static List<List<Integer>> tree;
    public static boolean[] visit;
    public static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for(int i=0; i<=n; i++){
            tree.add(new LinkedList<>());
        }
        for(int i=1; i<n; i++){
            String[] sa = br.readLine().split(" ");
            int u = Integer.parseInt(sa[0]);
            int v = Integer.parseInt(sa[1]);
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        dp = new int[n+1][2];
        visit = new boolean[n+1];
        findMinEA(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    public static void findMinEA(int node){
        visit[node] = true;
        dp[node][1] = 1; // 얼리어댑터일 때 최솟값
        for(int next : tree.get(node)){
            if(visit[next]) continue;
            findMinEA(next);
            // 현재 얼리어댑터 아니면 자식은 반드시 얼리어댑터
            dp[node][0] += dp[next][1];
            // 현재 얼리어댑터면 자식은 여부 상관 없음
            dp[node][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}