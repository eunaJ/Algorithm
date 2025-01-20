import java.util.*;
import java.io.*;

class Main {
    public static int n, m, answer;
    public static boolean[] visit;
    public static HashMap<Integer, Integer> hm;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);
        hm = new HashMap<>();
        visit = new boolean[101];
        for(int i=0; i<n; i++){
            sa = br.readLine().split(" ");
            int x = Integer.parseInt(sa[0]);
            int y = Integer.parseInt(sa[1]);
            hm.put(x, y);
        }
        for(int i=0; i<m; i++){
            sa = br.readLine().split(" ");
            int x = Integer.parseInt(sa[0]);
            int y = Integer.parseInt(sa[1]);
            hm.put(x, y);
        }
        bfs(1);
        System.out.println(answer);
    }

    public static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visit[s] = true;
        while(!q.isEmpty()){
            answer++;
            int size = q.size();
            for(int i=0; i<size; i++){
                int cur = q.poll();
                for(int j=1; j<=6; j++){
                    int next = cur + j;
                    if(next == 100) return;
                    
                    if(next > 100) continue;
                    if(visit[next]) continue;
                    
                    visit[next] = true;
                    if(hm.containsKey(next)){
                        next = hm.get(next);
                    }
                    q.add(next);
                }
            }
        }
    }
}