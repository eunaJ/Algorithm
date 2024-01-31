class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        int c = 0;
        for(String ss : arr){ 
            c = ss.contains(" ") ? 0 : c+1;
            answer += c%2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
        }
        return answer;
    }
}