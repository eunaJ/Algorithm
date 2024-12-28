import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] sa = br.readLine().split(" ");
        long[] arr = new long[n];
        int[] answer = new int[3];
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(sa[i]);
        }
        Arrays.sort(arr);
        long min = Long.MAX_VALUE;
        int start, mid, end;
        for(int i=0; i<n-2; i++){ // start는 for문, mid와 end는 투포인터
            start = i;
            mid = i + 1;
            end = n - 1;
            while(mid < end){
                long sum = arr[start] + arr[mid] + arr[end];
                if(min > Math.abs(sum)){
                    min = Math.abs(sum);
                    answer[0] = start;
                    answer[1] = mid;
                    answer[2] = end;
                }
                if(sum == 0) break;
                else if(sum > 0) end--;
                else mid++;
            }
        }
        System.out.println(arr[answer[0]] + " " + arr[answer[1]] + " " + arr[answer[2]]);
    }
}

// 투포인터