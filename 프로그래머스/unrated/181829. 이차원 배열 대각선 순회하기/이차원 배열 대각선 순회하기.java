class Solution {
    public int solution(int[][] board, int k) {
        int answer = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++) {
                if(j <= k - i){
                    answer += board[i][j];
                }
            }
            //j = 0;
        }
        return answer;
    }
}