import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '+' || c == '-' || c == '*' || c == '/'){ 
                while(!stack.isEmpty() && pri(stack.peek()) >= pri(c)){ // 우선순위
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
            else if(c == '(') stack.push(c);
            else if(c == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){ // 괄호 처리
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else sb.append(c); // 알파벳인 경우
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    private static int pri(char c){
        if(c == '(' || c == ')') return 0;
        else if(c == '+' || c == '-') return 1;
        else if(c == '*' || c == '/') return 2;
        else return -1;
    }
}

// 핵심: 연산자만 스택