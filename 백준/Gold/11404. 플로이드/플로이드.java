import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m, max;
    static int[][] cities;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        cities = new int[n+1][n+1];
        max = 10000001;
        for(int[] c : cities) Arrays.fill(c, max);
        for(int i=1; i<=n; i++) cities[i][i] = 0;
        for(int i=0; i<m; i++){
            String[] sa = br.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            int c = Integer.parseInt(sa[2]);
            cities[a][b] = Math.min(cities[a][b], c);
        }
        fw();
        for(int i=1; i<=n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=1; j<=n; j++){
                if(cities[i][j] == max) cities[i][j] = 0;
                sb.append(cities[i][j]).append(" ");
            }
            System.out.println(sb);
        }
    }

    public static void fw(){
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    cities[i][j] = Math.min(cities[i][j], cities[i][k]+cities[k][j]);
                }
            }
        }
    }
}