import java.util.*;
class Solution {
    List<Integer> li = new ArrayList<>();
    String[] num;
    boolean[] b;
    public int solution(String numbers) {
        num = numbers.split("");
        b = new boolean[numbers.length()];
        dfs("", num);
        return li.size();
    }
    
    public void dfs(String s, String[] num){
        if(!s.isEmpty()){
            int c = Integer.valueOf(s);
            if(isPrime(c) && !li.contains(c)) li.add(c);
        }
        for (int i=0; i < num.length; i++) {
            if (!b[i]) {
                b[i] = true;
                dfs(s + num[i], num);
                b[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if(n <= 1) return false;
        else {
            for(int ii=2; ii<=Math.sqrt(n); ii++){
                if(n % ii == 0) return false;
            }
        }
        return true;
    }
}