import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Long[] dp = new Long[101];
        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            for(int j=4; j<=n; j++){
                dp[j] = dp[j-2] + dp[j-3];
            }
            sb.append(dp[n] + "\n");
        }
        System.out.println(sb);
    }
}