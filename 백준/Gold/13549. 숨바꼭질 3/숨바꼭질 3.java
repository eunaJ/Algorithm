import java.util.*;
import java.io.*;

class Main {
    static int k, answer;
    static boolean[] visited;
    static int max = 100000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        k = Integer.parseInt(sa[1]);
        visited = new boolean[max+1];
        answer = Integer.MAX_VALUE;
        bfs(n);
        System.out.println(answer);
    }

    public static void bfs(int s){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int time = cur[1];
            visited[x] = true;
            if(x == k) {
                answer = Math.min(answer, time);
            }
            if(x+1 <= max && !visited[x+1]) {
                q.add(new int[]{x+1, time+1});
            }
            if(x-1 >= 0 && !visited[x-1]){
                q.add(new int[]{x-1, time+1});
            }
            if(2*x <= max && !visited[2*x]) {
                q.add(new int[]{2*x, time});
            }
        }
    }
}