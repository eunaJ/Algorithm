import java.util.*;
import java.io.*;

class Main {
    static int m, n, h, answer;
    static int[][][] map;
    static Queue<int[]> q;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        m = Integer.parseInt(sa[0]);
        n = Integer.parseInt(sa[1]);
        h = Integer.parseInt(sa[2]);
        map = new int[h][n][m];
        boolean b = true; // 처음부터 다 익었나?
        q = new LinkedList<>();
        for(int k=0; k<h; k++){
            for(int i=0; i<n; i++){
                sa = br.readLine().split(" ");
                for(int j=0; j<m; j++){
                    map[k][i][j] = Integer.parseInt(sa[j]);
                    if(map[k][i][j] == 1){
                        q.add(new int[]{k, i, j, 0});
                    }
                    else if(map[k][i][j] == 0) b = false;
                }
            }
        }
        if(b){
            System.out.println(0);
            return;
        }
        bfs();
        for(int k=0; k<h; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[k][i][j] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void bfs(){
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dh = {0, 0, 0, 0, 1, -1};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<6; i++){
                int nh = cur[0] + dh[i];
                int ny = cur[1] + dy[i];
                int nx = cur[2] + dx[i];
                answer = Math.max(answer, cur[3]);
                if(ny >= 0 && ny < n && nx >= 0 && nx < m && nh >= 0 && nh < h){
                    if(map[nh][ny][nx] == 0){
                        map[nh][ny][nx] = 1;
                        q.add(new int[]{nh, ny, nx, cur[3]+1});
                    }
                }
            }
        }
    }
}