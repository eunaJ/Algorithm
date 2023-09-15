class Solution {
    public int solution(int n) {
        int answer = 0;
        int c = 0;
        if(n%2!=0){
            c += 1;
            while(c<=n){
                answer += c;
                c += 2;
            }
        }
        else{
            while(c<=n){
                answer += c*c;
                c += 2;
            }
        }
        return answer;
    }
}