class Solution {
    public int solution(String s) {
        if(s.substring(0, 1).equals("+")){
            return Integer.parseInt(s.substring(1));
        }
        else if(s.substring(0, 1).equals("-")){
            return -(Integer.parseInt(s.substring(1)));
        }
        else return Integer.parseInt(s);
    }
}