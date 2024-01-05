class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        String[] s = my_string.split("");
        for(int i=0; i<indices.length; i++){
            s[indices[i]] = "";
        }
        for(int i=0; i<s.length; i++){
            answer += s[i];
        }
        return answer;
    }
}