import java.util.*;
class Solution {
    List<String> li = new ArrayList<>();
    public int solution(String word) {
        dfs(0, "");
        return li.indexOf(word);
    }
    
    public void dfs(int n, String s){
        if(n > 5) return;
        li.add(s);
        for(int i=0; i<5; i++){
            dfs(n+1, s + "AEIOU".charAt(i));
        }
    }
}