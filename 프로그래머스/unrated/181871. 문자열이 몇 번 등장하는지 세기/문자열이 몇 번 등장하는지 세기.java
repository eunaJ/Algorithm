class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int c = 0;
        while ((c = myString.indexOf(pat, c)) != -1) {
			answer++;
			c++;
		}
        return answer;
    }
}