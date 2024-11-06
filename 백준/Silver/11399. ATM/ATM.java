import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] sa = br.readLine().split(" ");
        int[] line = new int[n];
        int[] arr = new int[n];
        int answer = 0;
        for(int i=0; i<n; i++){
            line[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(line);
        arr[0] = line[0];
        answer = arr[0];
        for(int i=1; i<n; i++){
            arr[i] = arr[i-1] + line[i];
            answer += arr[i];
        }
        System.out.println(answer);
    }
}