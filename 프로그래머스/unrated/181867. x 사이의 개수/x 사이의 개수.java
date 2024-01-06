class Solution {
    public int[] solution(String myString) {
        String[] s = myString.split("x", myString.length());
        int[] answer = new int[s.length];
        for(int i=0; i<s.length; i++){
            answer[i] = s[i].length();
        }
        return answer;
    }
}