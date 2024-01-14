class Solution {
    public String solution(int q, int r, String code) {
        String answer = "";
        int c = 0;
        if(code.length() % q <= r) c = code.length()/q;
        else c = code.length()/q+1;
        for(int i=0; i<c; i++){
            answer += code.substring(q*i+r, q*i+r+1);
        }
        return answer;
    }
}