import java.util.*;
import java.io.*;

class Main {
    static int n, answer;
    static int[] stu;
    static boolean[] visit, finish;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            stu = new int[n+1];
            visit = new boolean[n+1];
            finish = new boolean[n+1];
            answer = 0;
            String[] sa = br.readLine().split(" ");
            for(int j=1; j<=n; j++){
                stu[j] = Integer.parseInt(sa[j-1]);
            }
            for(int j=1; j<=n; j++){
                if(!finish[j]) dfs(j);
            }
            sb.append(n - answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int idx){
        if(finish[idx]) return;
        if(visit[idx]){
            finish[idx] = true;
            answer++;
        }
        visit[idx] = true;
        dfs(stu[idx]);
        finish[idx] = true; // 사이클 아닌 것도 끝
        visit[idx] = false;
    }
}