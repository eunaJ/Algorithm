import java.util.Arrays;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = 0;
        for(int i=0; i<sizes.length; i++){
            for(int j=0; j<2; j++){
                Arrays.sort(sizes[i]);
                if(sizes[i][0] > answer) answer = sizes[i][0];
                if(sizes[i][1] > max) max = sizes[i][1];
            }
        }
        return answer*max;
    }
}