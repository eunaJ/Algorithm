class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        if(yellow == 1){
            return new int[] {3, 3};
        }
        for(int i=1; i<=yellow/2; i++){
            if(yellow%i == 0){
                if(((yellow/i + 2) * (i + 2)) == (brown + yellow)){
                    
                    if(yellow/i > i){
                        answer[0] = yellow/i+2;
                        answer[1] = i+2;
                    } else {
                        answer[0] = i+2;
                        answer[1] = yellow/i+2;
                    }
                }
            }
        }
        return answer;
    }
}