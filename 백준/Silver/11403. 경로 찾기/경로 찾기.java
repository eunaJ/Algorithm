import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        for(int i=0; i<n; i++){
            String[] sa = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(sa[j]);
            }
        }
        floyd(graph, n);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void floyd(int[][] graph, int n){
        // 경출도
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    // 갈 수 있는지만 확인
                    if(graph[i][k] == 1 && graph[k][j] == 1) graph[i][j] = 1;
                }
            }
        }
    }
}