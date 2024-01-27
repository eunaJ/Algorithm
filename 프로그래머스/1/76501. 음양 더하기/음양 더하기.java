class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0; i<absolutes.length; i++){
            if(signs[i]) answer += absolutes[i];
            else answer -= absolutes[i];
        }
        return answer;
    }
}

//
// for (int i=0; i<signs.length; i++)
//     answer += absolutes[i] * (signs[i]? 1: -1);
