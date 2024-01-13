class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int s = intervals[0][1] - intervals[0][0] + intervals[1][1] - intervals[1][0] + 2;
        int c = 0;
        int[] answer = new int[s];
        for(int i=intervals[0][0]; i<=intervals[0][1]; i++){
            answer[c] = arr[i];
            c++;
        }
        for(int i=intervals[1][0]; i<=intervals[1][1]; i++){
            answer[c] = arr[i];
            c++;
        }
        return answer;
    }
}