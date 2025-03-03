import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] sa = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(sa[i]);
        }
        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        sa = br.readLine().split(" ");
        for(int i=0; i<m; i++){
            b[i] = Integer.parseInt(sa[i]);
        }
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += a[j];
                hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            }
        }
        long answer = 0;
        for(int i=0; i<m; i++){
            int sum = 0;
            for(int j=i; j<m; j++){
                sum += b[j];
                int k = t - sum;
                if(hm.containsKey(k)){
                    answer += hm.get(k);
                }
            }
        }
        System.out.println(answer);
    }
}