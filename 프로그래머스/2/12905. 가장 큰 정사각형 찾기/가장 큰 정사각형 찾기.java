class Solution{
    public int solution(int[][] board){
        int answer = 0;
        if (board.length == 1) {
            return board[0][0] == 1 ? 1 : 0;
        }
        for(int i=1; i<board.length; i++){
            for(int j=1; j<board[i].length; j++){
                int cur = board[i][j];
                if(cur == 1){
                    board[i][j] =
                        Math.min(board[i][j - 1], Math.min(board[i - 1][j - 1], board[i - 1][j]))
                            + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }
        return answer * answer;
    }
}