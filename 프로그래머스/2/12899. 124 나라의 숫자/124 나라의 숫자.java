class Solution {
    public String solution(int n) {
        String[] s = {"4", "1", "2"};
        String answer = "";
        while(n != 0){
            int nn = n % 3;
            n /= 3;
            if(nn % 3 == 0) n--;
            answer = s[nn] + answer;   
        }
        return answer;
    }
}