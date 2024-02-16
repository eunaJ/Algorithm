class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;
        for(int i=2; i<=number; i++){
            int c = 0;
            for(int j=1; j<=Math.sqrt(i); j++){
                if(i%j == 0) {
                    if(j!=Math.sqrt(i)) c += 2;
                    else c++;
                }
            }
            if(c > limit) answer += power;
            else answer += c;
        }
        return answer;
    }
}