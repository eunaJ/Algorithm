import java.util.Stack;
class Solution {
    boolean solution(String s) {
        Stack st = new Stack<>();
        if(s.charAt(0) == ')') return false;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') st.push(s.charAt(i));
            else if(s.charAt(i) == ')') {
                if(st.isEmpty()) return false;
                else st.pop();
            }
        }
        return st.isEmpty() ? true : false;
    }
}