import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cl = new int[n][2];
        for(int i=0; i<n; i++){
            String[] sa = br.readLine().split(" ");
            cl[i][0] = Integer.parseInt(sa[0]);
            cl[i][1] = Integer.parseInt(sa[1]);
        }
        // 종료 시간 기준으로 정렬
        Arrays.sort(cl, (a, b) -> a[1]-b[1]);
        int now = cl[0][1];
        int answer = 1;
        for(int i=1; i<n; i++){
            if(now <= cl[i][0]) {
                answer++;
                now = cl[i][1];
            }
        }
        System.out.println(answer);
    }
}
