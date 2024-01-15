class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        int r = 0;
        int c = 0;
        for(int j=n; j>0; j-=2){
            for(int i=0; i<j; i++){
                answer[r][c] = num++;
                c++;
            }
            c--;
            r++;
            for(int i=0; i<j-1; i++){
                answer[r][c] = num++;
                r++;
            }
            c--;
            r--;
            for(int i=0; i<j-1; i++){
                answer[r][c] = num++;
                c--;
            }
            r--;
            c++;
            for(int i=0; i<j-2; i++){
                answer[r][c] = num++;
                r--;
            }
            r++;
            c++;
        }
        return answer;
    }
}