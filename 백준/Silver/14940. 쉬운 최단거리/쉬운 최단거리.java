import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int[][] g;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);
        g = new int[n][m];
        int[] s = new int[2];
        for(int i=0; i<n; i++){
            sa = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                g[i][j] = Integer.parseInt(sa[j]);
                if(g[i][j] == 1) {
                    g[i][j] = -1;
                }
                else if(g[i][j] == 2) {
                    s = new int[] {i, j}; 
                    g[i][j] = 0;
                } else {
                    g[i][j] = -3;
                }
            }
        }
        bfs(s);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(g[i][j] == -3) sb.append(0);
                else sb.append(g[i][j]);
                sb.append(" ");
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }

    public static void bfs(int[] s){
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int nx = cur[1] + dx[i];
                int ny = cur[0] + dy[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && g[ny][nx] == -1) {
                    q.add(new int[] {ny, nx});
                    g[ny][nx] = g[cur[0]][cur[1]] + 1;
                }
            }
        }
    }
}