import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[][] g;
    static boolean[][] visited;
    static ArrayList<Integer> li;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        g = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            String[] sa = br.readLine().split("");
            for(int j=0; j<n; j++){
                g[i][j] = Integer.parseInt(sa[j]);
            }
        }
        li = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && g[i][j] == 1){
                    int s = bfs(i, j);
                    li.add(s);
                }
            }
        }
        Collections.sort(li);
        System.out.println(li.size());
        for(int l : li){
            System.out.println(l);
        }
    }

    public static int bfs(int sy, int sx){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});
        visited[sy][sx] = true;
        int size = 1;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[ny][nx] && g[ny][nx] == 1){
                    q.add(new int[]{nx, ny});
                    visited[ny][nx] = true;
                    size++;
                }
            }
        }
        return size;
    }
}