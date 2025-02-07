import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        int m = Integer.parseInt(sa[1]);
        sa = br.readLine().split(" ");
        int[] memoryByte = new int[n];
        for(int i=0; i<n; i++){
            memoryByte[i] = Integer.parseInt(sa[i]);
        }
        sa = br.readLine().split(" ");
        int[] cost = new int[n];
        for(int i=0; i<n; i++){
            cost[i] = Integer.parseInt(sa[i]);
        }
        int answer = Integer.MAX_VALUE;
        // dp[i][j] : i번째 앱까지 비용 j로 확보 가능 최대 메모리
        int[][] dp = new int[n][10001]; // 앱 최대 100, 비용 최대 100
        for(int i=0; i<n; i++){
            int c = cost[i];
            int mem = memoryByte[i];
            for(int j=0; j<10001; j++){
                if(i == 0){
                    if(j >= c) dp[i][j] = mem;
                } else {
                    if(j >= c){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-c]+mem);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
                if(dp[i][j] >= m) answer = Math.min(answer, j);
            }
        }
        System.out.println(answer);
    }
}

// knapsnak