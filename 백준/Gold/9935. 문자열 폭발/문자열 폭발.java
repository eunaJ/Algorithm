import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();
        if(s.length() < bomb.length()){
            System.out.println(s);
            return;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            stack.add(s.charAt(i));
            if(stack.size() >= bomb.length() && stack.peek() == bomb.charAt(bomb.length()-1)){
                boolean b = false;
                for(int j=0; j<bomb.length(); j++){
                    if(stack.get(stack.size()-bomb.length()+j) != bomb.charAt(j)){
                        b = true;
                        break;
                    }
                }
                if(!b){
                    for(int j=0; j<bomb.length(); j++){
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for(Character c : stack){
            answer.append(c);
        }
        if(answer.length() <= 0) System.out.println("FRULA");
        else System.out.println(answer);
    }
}

// Stack