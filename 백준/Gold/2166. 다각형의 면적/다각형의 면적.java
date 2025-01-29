import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] x = new long[n+1];
        long[] y = new long[n+1];
        long sum1 = 0;
        long sum2 = 0;
        for(int i=0; i<n; i++){
            String[] sa = br.readLine().split(" ");
            x[i] = Long.parseLong(sa[0]);
            y[i] = Long.parseLong(sa[1]);
        }
        x[n] = x[0];
        y[n] = y[0];
        for(int i=0; i<n; i++){
            sum1 += x[i] * y[i+1];
            sum2 += x[i+1] * y[i];
        }
        System.out.println(String.format("%.1f", (Math.abs(sum1 - sum2) / 2.0)));
    }
}

// int 주의
// 신발끈 공식