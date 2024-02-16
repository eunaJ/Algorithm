class Solution {
    public int solution(int n) {
        String s = Integer.toString(n, 3);
        String r = "";
        for (int i=s.length()-1; i>=0; i--) {   
            r += s.charAt(i);       
        }
        int answer = 0;
        return Integer.valueOf(r, 3);
    }
}