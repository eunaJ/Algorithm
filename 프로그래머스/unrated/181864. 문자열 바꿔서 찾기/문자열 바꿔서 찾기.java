class Solution {
    public int solution(String myString, String pat) {
        return myString.replaceAll("A", "C").replaceAll("B", "A").replaceAll("C", "B").contains(pat) ? 1 : 0;
    }
}