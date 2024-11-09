import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[][] g;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);
        g = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=0; i<m; i++){
            sa = br.readLine().split(" ");
            int x = Integer.parseInt(sa[0]);
            int y = Integer.parseInt(sa[1]);
            g[x][y] = 1;
            g[y][x] = 1;
        }
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int s){
        if(!visited[s]){
            visited[s] = true;
            for(int i=1; i<=n; i++){
                if(g[s][i] == 1 && !visited[i]){
                    dfs(i);
                }
            }
        }
    }
}