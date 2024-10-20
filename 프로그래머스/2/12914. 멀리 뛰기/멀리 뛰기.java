class Solution {
    public long solution(int n) {
        // 피보나치 스타일
        if(n <= 1) return n;
        int[] jump = new int[n+1];
        jump[1] = 1;
        jump[2] = 2;
        for(int i=3; i<=n; i++){
            jump[i] = (jump[i-2] + jump[i-1]) % 1234567;
        }
        return jump[n];
    }
}