import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean b = false;
        for (String word : words) {
            if (word.equals(target)) {
                b = true;
                break;
            }
        }
        return b ? bfs(begin, target, words, new boolean[words.length]) : 0;
    }
    
    public int bfs(String begin, String target, String[] words, boolean[] visited){
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        while(!q.isEmpty()){
            int size = q.size();
            answer++;
            for(int i=0; i<size; i++){
                String now = q.poll();
                if(now.equals(target)) return answer-1;       
                for(int j=0; j<words.length; j++){
                    if(!visited[j] && isOneLetterDiff(now, words[j])){
                        visited[j] = true;
                        q.offer(words[j]);
                    }
                }
            }
        }
        return 0;
    }
    
    public boolean isOneLetterDiff(String s1, String s2) {
        int c = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) c++;
            if (c > 1) return false;
        }
        return c == 1;
    }
}