class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int c = n;
        while(c >= a){
            answer = answer + c / a * b;
            c = c/a*b + c%a;
        }
        return answer;
    }
}