import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        if(s.length() % 2 == 1) return answer;
        Queue<String> q = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            String str = s.substring(i, i+1);
            q.add(str);
        }
        for(int i=0; i<s.length(); i++){
            String str = q.poll();
            q.add(str);
            Stack<String> stack = new Stack<>();
            for(int j=0; j<s.length(); j++){
                String reStr = q.poll();
                q.add(reStr);
                if(stack.isEmpty()){
                    stack.push(reStr);
                } else if(reStr.equals(")") && stack.peek().equals("(")){
                    stack.pop();
                } else if(reStr.equals("]") && stack.peek().equals("[")){
                    stack.pop();
                } else if(reStr.equals("}") && stack.peek().equals("{")){
                    stack.pop();
                }else {
                    stack.push(reStr);
                }
            }
            if(stack.isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}