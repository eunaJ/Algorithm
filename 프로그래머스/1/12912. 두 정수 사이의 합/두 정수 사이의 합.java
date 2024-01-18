import java.lang.Math;
class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        for(int i=min; i<=max; i++){
            answer += i;
        }
        return answer;
    }
}

//
// (b - a + 1) * (a + b) / 2;
