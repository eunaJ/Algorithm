class Solution {
    public int solution(String s) {
        int answer = 0;
        int xi = 0;
        int oi = 0;
        char s1 = s.charAt(0);
        for(int i=0; i<s.length(); i++){
            if(xi == oi){
                answer++;
                s1 = s.charAt(i);
            }
            if(s.charAt(i) == s1) xi++;
            else oi++;
        }
        return answer;
    }
}