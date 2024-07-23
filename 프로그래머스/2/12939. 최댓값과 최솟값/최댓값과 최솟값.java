class Solution {
    public String solution(String s) {
        String[] answer = s.split(" ");
        int max = Integer.parseInt(answer[0]);
        int min = Integer.parseInt(answer[0]);
        int n = 0;
        for(int i=1; i<answer.length; i++){
            n = Integer.parseInt(answer[i]);
            if(n > max) {
                max = n;
            }
            if(n < min) {
                min = n;
            }
        }
        return min + " " + max;
    }
}