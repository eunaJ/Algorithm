import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int[][] g, dist;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);
        g = new int[n+1][m+1];
        dist = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            sa = br.readLine().split("");
            for(int j=1; j<=m; j++){
                g[i][j] = Integer.parseInt(sa[j-1]);
            }
        }
        bfs(1, 1);
        System.out.println(dist[n][m]+1);
    }

    public static void bfs(int sx, int sy){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx > 0 && nx <= m && ny > 0 && ny <= n && g[ny][nx] == 1 && dist[ny][nx] == 0){
                    q.add(new int[]{nx, ny});
                    dist[ny][nx] = dist[y][x] + 1;
                }
            }
        }
    }
}