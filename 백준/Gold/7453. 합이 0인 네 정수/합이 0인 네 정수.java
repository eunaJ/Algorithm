import java.util.*;
import java.io.*;

class Main {
    static int[] a, b, c, d, arr1, arr2;
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[4001];
        b = new int[4001];
        c = new int[4001];
        d = new int[4001];
        arr1 = new int[n*n];
        arr2 = new int[n*n];
        for(int i=0; i<n; i++){
            String[] sa = br.readLine().split(" ");
            a[i] = Integer.parseInt(sa[0]);
            b[i] = Integer.parseInt(sa[1]);
            c[i] = Integer.parseInt(sa[2]);
            d[i] = Integer.parseInt(sa[3]);
        }
        int idx = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr1[idx] = a[i] + b[j];
                arr2[idx] = c[i] + d[j];
                idx++;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(sumZero());
    }

    public static long sumZero(){
        long answer = 0;
        int p1 = 0;
        int p2 = n * n - 1;
        while(p1 < n*n && p2 >= 0){
            int sum = arr1[p1] + arr2[p2];
            if(sum == 0){
                long c1 = 1;
                long c2 = 1;
                while(p1 < n*n-1 && arr1[p1] == arr1[p1+1]){
                    c1++;
                    p1++;
                }
                while(p2 > 0 && arr2[p2] == arr2[p2-1]){
                    c2++;
                    p2--;
                }
                answer += (c1 * c2);
                p1++;
                p2--;
            } else if(sum < 0){
                p1++;
            } else {
                p2--;
            }
        }
        return answer;
    }
}