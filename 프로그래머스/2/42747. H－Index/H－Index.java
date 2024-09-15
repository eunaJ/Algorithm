import java.util.*;
class Solution {
    public int solution(int[] citations) {        
        Arrays.sort(citations);
        int l = citations.length;
        for(int i=0; i<l; i++){
            if(citations[l-1-i] < i+1) return i;
        }
        return l;
    }
}