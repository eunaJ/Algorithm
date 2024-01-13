import java.util.Arrays;
class Solution {
    public String solution(String myString, String pat) {
        int s = myString.lastIndexOf(pat) + pat.length();
        return myString.substring(0, s);
    }
}