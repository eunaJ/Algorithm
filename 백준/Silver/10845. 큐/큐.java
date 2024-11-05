import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int last = 0;
        for(int i=0; i<n; i++){
            String s = br.readLine();
            if(s.contains(" ")){
                last = Integer.parseInt(s.substring(5, s.length()));
                q.add(last);
            } else if(s.equals("pop")){
                if(q.isEmpty()) System.out.println(-1);
                else System.out.println(q.poll());
            } else if(s.equals("size")){
                System.out.println(q.size());
            } else if(s.equals("empty")){
                if(q.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if(s.equals("front")){
                if(q.isEmpty()) System.out.println(-1);
                else System.out.println(q.peek());
            } else if(s.equals("back")){
                if(q.isEmpty()) System.out.println(-1);
                else System.out.println(last);
            }
        }
    }
}