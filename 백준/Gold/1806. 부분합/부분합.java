import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        int s = Integer.parseInt(sa[1]);
        sa = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int answer = 100001;
        while(true){
            if(sum >= s){
                sum -= arr[start];
                answer = Math.min(answer, end-start);
                start++;
            } else if(end == n){
                break;
            } else {
                sum += arr[end++];
            }
        }
        if(answer == 100001) System.out.println(0);
        else System.out.println(answer);
    }
}