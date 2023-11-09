class Solution {
    public int solution(String number) {
        int answer = 0;
        for(int i=0; i<number.length(); i++){
            answer += Integer.valueOf(number.substring(i, i+1));
        }
        
        answer = answer % 9;
        return answer;
    }
}