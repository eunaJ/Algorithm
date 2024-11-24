import java.util.*;
import java.io.*;

class Main {
    static int n, answer;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int d){
        if(d == n){
            answer++;
            return;
        }
        for(int i=0; i<n; i++){
            arr[d] = i; // d행에 배치된 열 번호 i 저장
            if(possible(d)) dfs(d+1);
        }
    }

    public static boolean possible(int d){
        for(int i=0; i<d; i++){
            if(arr[i] == arr[d]) return false; // 같은 행
            else if(Math.abs(d-i) == Math.abs(arr[d]-arr[i])) return false; // 대각선(행 차이와 열 차이가 같으면 대각선)
        }
        return true;
    }
}