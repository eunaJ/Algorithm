class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] c = new char[s.length()];
        for(int i=0; i<c.length; i++){
            c[i] = s.charAt(i);
            if(c[i] == ' ') answer += ' ';
            else if(c[i] <= 'Z')
                answer = answer + (char)('A'+(c[i]+n-'A')%26);
            else
                answer = answer + (char)('a'+(c[i]+n-'a')%26);
        }        
        return answer;
    }
}