import java.util.*;
import java.io.*;

class Main {
    static int m, n, k;
    static int[][] g;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            String[] sa = br.readLine().split(" ");
            m = Integer.parseInt(sa[0]);
            n = Integer.parseInt(sa[1]);
            k = Integer.parseInt(sa[2]);
            g = new int[n][m];
            visited = new boolean[n][m];
            for(int j=0; j<k; j++){
                sa = br.readLine().split(" ");
                int x = Integer.parseInt(sa[0]);
                int y = Integer.parseInt(sa[1]);
                g[y][x] = 1;
            }
            int answer = 0;
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(g[j][k] == 1 && !visited[j][k]){
                        dfs(j, k);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static void dfs(int y, int x){
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        visited[y][x] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && g[ny][nx] == 1 && !visited[ny][nx]){
                dfs(ny, nx);
            }
        }
    }
}