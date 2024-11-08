import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x != 0) pq.add(x);
            else System.out.println(pq.isEmpty() ? 0 : pq.poll());
        }
    }
}