import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
			String s = st.nextToken();
            if(s.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            } else if(s.equals("pop")) {
                if(stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.pop());
            } else if(s.equals("size")){
                System.out.println(stack.size());
            } else if(s.equals("empty")){
                if(stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if(s.equals("top")) {
                if(stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.peek());
            }
        }
    }
}