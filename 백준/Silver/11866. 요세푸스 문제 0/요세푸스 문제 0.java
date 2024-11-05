import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        int k = Integer.parseInt(sa[1]);
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            q.add(i);
        }
        while(q.size() > 1){
            for(int i=0; i<k-1; i++){
                int t = q.poll();
                q.add(t);
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll());
        System.out.println("<"+sb+">");
    }
}