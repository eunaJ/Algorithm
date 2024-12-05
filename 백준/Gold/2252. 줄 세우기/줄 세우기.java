import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        int m = Integer.parseInt(sa[1]);
        List<Integer>[] graph = new ArrayList[n + 1];
        int[] degree = new int[n + 1]; // 진입 차수
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            sa = br.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            graph[a].add(b);
            degree[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(degree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            result.add(cur);
            for(int neigh : graph[cur]){
                degree[neigh]--;
                if(degree[neigh] == 0) q.offer(neigh); // 진입차수가 0이 되면 q에 삽입
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int r : result){
            sb.append(r).append(" ");
        }
        System.out.println(sb);
    }
}

// 위상정렬