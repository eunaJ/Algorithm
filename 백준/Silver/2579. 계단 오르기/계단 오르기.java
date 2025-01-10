import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n+1];
        for(int i=1; i<=n; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n+1];
        dp[1] = stairs[1];
        for(int i=2; i<=n; i++){
            if(i == 2) dp[i] = stairs[1] + stairs[2];
            else if(i == 3) dp[i] = Math.max(stairs[1], stairs[2]) + stairs[3];
            else dp[i] = Math.max(dp[i-3] + stairs[i-1], dp[i-2]) + stairs[i];
        }
        System.out.println(dp[n]);
    }
}

// 연속된 3개의 계단을 밟으면 안 된다