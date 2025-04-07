class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        int idx = 0;
        for(long i=left; i<=right; i++){
            long r = i / n + 1;
            long c = i % n + 1;
            answer[idx] = (int)Math.max(r, c);
            idx++;
        }
        return answer;
    }
}

// r, c 중 가장 큰 값이 그 행열의 값