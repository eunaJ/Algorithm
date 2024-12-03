import java.util.*;
import java.io.*;

class Main {
    static int[] dpAsc, dpDesc, arr;
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] sa = br.readLine().split(" ");
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        // i 포함 가장 긴 수열
        dpAsc = new int[n];
        dpDesc = new int[n];
        asc();
        desc();
        int answer = -1;
        for(int i=0; i<n; i++){
            answer = Math.max(answer, (dpAsc[i]+dpDesc[i]-1));
        }
        System.out.println(answer);
    }

    public static void asc(){
        for(int i=0; i<n; i++){
            dpAsc[i] = 1;
            for(int j=0; j<i; j++){
                // 증가하는지, 더 긴 수열인지
                if(arr[j] < arr[i] && dpAsc[i] < dpAsc[j] + 1) dpAsc[i] = dpAsc[j] + 1;
            }
        }
    }

    public static void desc(){
        for(int i=n-1; i>=0; i--){
            dpDesc[i] = 1;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[i] && dpDesc[i] < dpDesc[j] + 1) dpDesc[i] = dpDesc[j] + 1;
            }
        }
    }
}