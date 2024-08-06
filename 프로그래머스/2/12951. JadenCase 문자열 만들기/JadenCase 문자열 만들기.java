class Solution {
    public String solution(String s) {
        String[] str = s.toLowerCase().split("");
        String answer = "";
        Boolean b = true;
        for(String ss : str){
            if(b){
                answer += ss.toUpperCase();
                b = false;
            }
            else {
                answer += ss;
            }
            if(ss.equals(" ")){
                b = true;
            }
        }
        return answer;
    }
}