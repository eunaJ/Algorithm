import java.util.*;
import java.io.*;

class Main {
    static int n, m, answer;
    static int[][] map;
    static boolean[][][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);
        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1][2];
        for(int i=1; i<=n; i++){
            String s = br.readLine();
            for(int j=1; j<=m; j++){
                map[i][j] = Integer.parseInt(s.substring(j-1, j));
            }
        }
        bfs();
        if(answer == 0) System.out.println(-1);
        else System.out.println(answer);
    }

    public static void bfs(){
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 1, 0, 0}); // y, x, count, 벽 뿌신 여부(O : 1, X : 0)
        visited[1][1][0] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == n && cur[1] == m){
                answer = Math.max(answer, cur[2]+1);
                return;
            }
            for(int i=0; i<4; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                int c = cur[2];
                int destroyed = cur[3];
                if(nx > 0 && nx <= m && ny > 0 && ny <= n){ // 아직 벽 안 뿌심
                    if(map[ny][nx] == 0){ // 벽이 아니면
                        if(destroyed == 0 && !visited[ny][nx][0]){ // 아직 벽 안 뿌심
                            q.add(new int[]{ny, nx, c+1, 0});
                            visited[ny][nx][0] = true;
                        } else if(destroyed == 1 && !visited[ny][nx][1]){ // 벽 뿌심
                            q.add(new int[]{ny, nx, c+1, 1});
                            visited[ny][nx][1] = true;
                        }
                    } else if(map[ny][nx] == 1){ // 벽이면
                        if(destroyed == 0){ // 한번도 뿌순 적 없다면
                            q.add(new int[]{ny, nx, c+1, 1});
                            visited[ny][nx][1] = true;
                        }
                    }
                }
            }
        }
    }
}