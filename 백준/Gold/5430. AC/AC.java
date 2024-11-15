import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            String[] p = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String[] sa = s.substring(1, s.length() - 1).split(",");
            Deque<Integer> deq = new LinkedList<>();
            if(n > 0) {
                for(String str : sa){
                    deq.add(Integer.parseInt(str));
                }
            }
            boolean r = false;
            boolean e = false;
            for(String pp : p){
                if(pp.equals("R")){
                    r = !r;
                } else if(pp.equals("D")){
                    if(deq.isEmpty()){
                        e = true;
                        break;
                    }
                    if(r) deq.pollLast();
                    else deq.poll();
                }
            }
            if(e){
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder("[");
                while (!deq.isEmpty()) {
                    sb.append(r ? deq.pollLast() : deq.poll());
                    if (!deq.isEmpty()) sb.append(",");
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}