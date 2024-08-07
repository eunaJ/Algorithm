class Solution {
    public int solution(int n) {
        int answer = 0;
        int fn1 = 0;
        int fn2 = 1;
        for(int i=2; i<=n; i++){
            answer = (fn1 + fn2) % 1234567;
            fn1 = fn2;
            fn2 = answer;
        }
        return answer;
    }
}

// 오버플로우 피보나치 합동식