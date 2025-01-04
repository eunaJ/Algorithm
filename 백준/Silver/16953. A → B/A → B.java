import java.util.*;
import java.io.*;

class Main {
    public static long a, b;
    public static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        a = Long.parseLong(sa[0]);
        b = Long.parseLong(sa[1]);
        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<Long> q = new LinkedList<>();
        q.add(a);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                long cur = q.poll();
                if(cur == b) return answer + 1;
                if(cur*2 <= b) q.add(cur*2);
                if(cur*10+1 <= b) q.add(cur*10+1);
            }
            answer++;
        }
        return -1;
    }
}