import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int[][] g;
    static boolean[] visited;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);
        int v = Integer.parseInt(sa[2]);
        g = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=0; i<m; i++){
            sa = br.readLine().split(" ");
            int x = Integer.parseInt(sa[0]);
            int y = Integer.parseInt(sa[1]);
            g[x][y] = 1;
            g[y][x] = 1;
        }
        dfs(v);
        System.out.println(sb);
        sb.setLength(0);
        Arrays.fill(visited, false);
        bfs(v);
        System.out.println(sb);
    }

    public static void dfs(int sv){
        sb.append(sv).append(" ");
        visited[sv] = true;
        for(int i=1; i<=n; i++){
            if(!visited[i] && g[sv][i] == 1){
                dfs(i);
            }
        }
    }
    
    public static void bfs(int sv){
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv] = true;
        sb.append(sv).append(" ");
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=1; i<=n; i++){
                if(!visited[i] && g[cur][i] == 1){
                    q.add(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }
}