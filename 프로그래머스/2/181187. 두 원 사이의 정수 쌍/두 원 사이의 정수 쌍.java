import java.lang.Math;
class Solution {
    public long solution(int r1, int r2) {
        // int 아님 주의
        // 원의 방정식 사용
        // n^2 시간초과
        long answer = 0;
        for(int i=1; i<=r2; i++){
            long a1 = (long)Math.ceil(Math.sqrt(1.0*r1*r1 - 1.0*i*i)); // 올림(최솟값)
            long a2 = (long)Math.floor(Math.sqrt(1.0*r2*r2 - 1.0*i*i)); // 내림(최댓값)
            answer += (a2 - a1 +1);
        }
        return answer * 4;
    }
}