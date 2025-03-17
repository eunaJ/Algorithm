import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Queue<String> q = new LinkedList<>();
        q.add(words[0]);
        for(int i=1; i<words.length; i++){
            if(q.contains(words[i])){
                return new int[]{i%n+1, i/n+1};
            }
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                return new int[]{i%n+1, i/n+1};
            }
            q.add(words[i]);
        }
        return answer;
    }
}