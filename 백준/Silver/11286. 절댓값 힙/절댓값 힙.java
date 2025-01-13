import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
            if(Math.abs(a) == Math.abs(b)){
                if(a <= b) return -1;
                else return 1;
            } 
            else if(Math.abs(a) < Math.abs(b)) return -1; // x가 높
            else return 1;
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x != 0) pq.offer(x);
            else {
                if(pq.isEmpty()) sb.append(0 + "\n");
                else sb.append(pq.poll() + "\n");
            }
        }
        System.out.println(sb);
    }
}