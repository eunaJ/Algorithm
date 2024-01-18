class Solution {
    public String solution(String s) {
        String answer = "";
        int l = s.length();
        if(l % 2 != 0){
            return s.substring(l/2, l/2+1);
            }
        else{
            return s.substring(l/2-1, l/2+1);
        }
    }
}