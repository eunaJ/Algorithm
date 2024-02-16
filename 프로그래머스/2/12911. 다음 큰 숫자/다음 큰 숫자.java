class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toString(n, 2);
        int c = s.length() - s.replace("1", "").length();
        for(int i=n+1; i<=10000000; i++){
            s = Integer.toString(i, 2);
            if(s.length()-s.replace("1", "").length() == c) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}