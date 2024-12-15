import java.util.*;
import java.io.*;

class Main {
    public static int binarySearch(int[] lis, int left, int right, int target){
        int mid;
        while(left < right){
            mid = (left+right)/2;
            if(lis[mid] < target) left = mid + 1;
            else right = mid;
        }
        return right;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] sa = br.readLine().split(" ");
        int[] a = new int[n];
        int[] lis = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(sa[i]);
        }
        lis[0] = a[0];
        int answer = 1;
        for(int i=1; i<n; i++){
            if(lis[answer-1] < a[i]) lis[answer++] = a[i];
            else if(lis[answer-1] > a[i]){
                int idx = binarySearch(lis, 0, answer-1, a[i]);
                lis[idx] = a[i];
            }
        }
        System.out.println(answer);
    }
}

// binarysearch, lis