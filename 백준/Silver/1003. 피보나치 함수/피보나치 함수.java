import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] dp0 = new int[n+1];
            int[] dp1 = new int[n+1];
            dp0[0] = 1;
            if(n > 0) dp1[1] = 1;
            for(int j=2; j<=n; j++){
                dp0[j] = dp0[j-2] + dp0[j-1];
                dp1[j] = dp1[j-2] + dp1[j-1];
            }
            System.out.println(dp0[n] + " " + dp1[n]);
        }
    }
}