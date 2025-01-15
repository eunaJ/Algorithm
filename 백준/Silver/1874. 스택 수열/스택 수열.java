import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int last = 0;
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x > last){
                for(int j=last+1; j<=x; j++){
                    stack.push(j);
                    sb.append("+\n");
                }
                last = x;
            } 
            if(stack.get(stack.size()-1) == x){
                stack.pop();
                sb.append("-\n");
            }
        }
        if(stack.size() > 0) System.out.println("NO");
        else System.out.println(sb);
    }
}