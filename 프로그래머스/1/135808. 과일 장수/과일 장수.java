import java.util.Arrays;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int[] arr = {};
        for(int i=score.length; i>=0; i-=m){ 
            if(i < m) break;
            arr = Arrays.copyOfRange(score, i-m, i);
            answer += arr[0]*m*1;
            
        }
        return answer;
    }
}