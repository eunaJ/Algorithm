import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            String[] sa = br.readLine().split(" ");
            for(int j=0; j<sa.length; j++){
                arr[i][j] = Integer.parseInt(sa[j]);
            }
        }
        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];
        int answer = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<=i; j++){
                if(j == 0){ // 맨 왼쪽
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                } 
                else if(j == i){ // 맨 오른쪽
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
                }
            }
        }
        for(int i=0; i<n; i++){
            if(answer < dp[n-1][i]) answer = dp[n-1][i];
        }
        System.out.println(answer);
    }
}