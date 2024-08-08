class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int sum = sequence[0];
        int start = 0;
        int end = 0;
        int l = 1000000;
        while (start < sequence.length && end < sequence.length) {
            if (sum == k) {
                if ((end - start) < l) {
                    l = end - start;
                    answer[0] = start;
                    answer[1] = end;
                }
                sum -= sequence[start];
                start++;
            } else if (sum < k) {
                end++;
                if (end < sequence.length) {
                    sum += sequence[end];
                }
            } else {
                sum -= sequence[start];
                start++;
            }
        }
        return answer;
    }
}