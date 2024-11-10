import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] meeting = new int[n][2];
        for(int i=0; i<n; i++){
            String[] sa = br.readLine().split(" ");
            meeting[i][0] = Integer.parseInt(sa[0]);
            meeting[i][1] = Integer.parseInt(sa[1]);
        }
        Arrays.sort(meeting, (a, b) -> {
            if(a[1] == b[1]) return a[0]-b[0];
            else return a[1]-b[1];
        });
        int now = meeting[0][1];
        int answer = 1;
        for(int i=1; i<n; i++){
            if(now <= meeting[i][0]) {
                answer++;
                now = meeting[i][1];
            }
        }
        System.out.println(answer);
    }
}

// 사용할 수 있는 회의의 최대 개수
// greedy