import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public String solution(String n_str) {
        String[] s = n_str.split("");
        for(int i=0; i<s.length; i++){
            if(s[i].equals("0")) s[i] = "";
            else break;
        }
        return String.join("", s);
    }
}