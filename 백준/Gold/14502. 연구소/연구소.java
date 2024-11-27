import java.util.*;
import java.io.*;

class Main {
    static int n, m, answer;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);
        map = new int[n][m];
        for(int i=0; i<n; i++){
            sa = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(sa[j]);
            }
        }
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int w){
        if(w == 3){
            bfs();
            return;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(w+1);
                    map[i][j] = 0;;
                }
            }
        }
    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int[][] vm = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                vm[i][j] = map[i][j];
                if(vm[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && vm[ny][nx] == 0){
                    vm[ny][nx] = 2;
                    q.add(new int[]{ny, nx});
                }
            }
        }
        int c = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vm[i][j] == 0){
                    c++;
                }
            }
        }
        answer = Math.max(answer, c);
    }
}