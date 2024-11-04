import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String str = br.readLine();
            boolean b = true;
            Stack<Character> stack = new Stack<>();
            for(char c : str.toCharArray()){
                if(c == '('){
                    stack.push(c);
                } else if(c == ')'){
                    if(stack.isEmpty() || stack.pop() != '('){
                        b = false;
                        break;
                    }
                }
            }
            if(b && stack.isEmpty()){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }        
    }
}