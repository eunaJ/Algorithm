class Solution {
    public boolean isNumber(String s){
        return s.chars().allMatch(Character::isDigit);
    }
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() == 4 || s.length() == 6){
            if(isNumber(s)){
                return true;
            }
        }
        return false;
    }
}