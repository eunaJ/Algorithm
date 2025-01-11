import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        int k = Integer.parseInt(sa[1]);
        int[] arr = new int[n];
        for(int i=n-1; i>=0; i--){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int money = k;
        int answer = 0;
        int idx = 0;
        while(money > 0){
            if(money >= arr[idx]){
                money -= arr[idx];
                answer++;
            }
            else idx++;
        }
        System.out.println(answer);
    }
}