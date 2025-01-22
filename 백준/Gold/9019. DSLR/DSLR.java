import java.util.*;
import java.io.*;

class Main {
    public static StringBuilder sb;
    public static boolean[] visit;
    public static String[] answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int i=0; i<t; i++){
            String[] sa = br.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            visit = new boolean[10000];
            answer = new String[10000];
            bfs(a, b);
        }
        System.out.println(sb);
    }

    public static void bfs(int a, int b){
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        visit[a] = true;
        Arrays.fill(answer, "");
        while(!q.isEmpty()){
            int cur = q.poll();
            int d = (2 * cur) % 10000;
            int s = cur == 0 ? 9999 : cur - 1;
            int l = (cur % 1000) * 10 + cur / 1000;
            int r = (cur % 10) * 1000 + cur / 10;

            if(!visit[d]){
                q.add(d);
                visit[d] = true;
                answer[d] = answer[cur] + "D";
            }
            if(!visit[s]){
                q.add(s);
                visit[s] = true;
                answer[s] = answer[cur] + "S";
            }
            if(!visit[l]){
                q.add(l);
                visit[l] = true;
                answer[l] = answer[cur] + "L";
            }
            if(!visit[r]){
                q.add(r);
                visit[r] = true;
                answer[r] = answer[cur] + "R";
            }
        }
        sb.append(answer[b] + "\n");
    }
}