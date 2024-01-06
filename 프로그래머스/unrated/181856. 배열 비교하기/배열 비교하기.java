import java.util.Arrays;
class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length) return arr1.length > arr2.length ? 1 : -1;
        else {
            int s1 = Arrays.stream(arr1).sum();
            int s2 = Arrays.stream(arr2).sum();
            if(s1 == s2) return 0;
            else return s1 > s2 ? 1 : -1;
        }
    }
}