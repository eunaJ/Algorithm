class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        for(int i=1; i<s.length(); i++){
            int c = s.substring(0, i).lastIndexOf(s.charAt(i));
            if(c == -1) answer[i] = -1;
            else answer[i] = i - c;
        }
        return answer;
    }
}