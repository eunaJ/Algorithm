class Solution {
    public long solution(long n) {
        double s = Math.sqrt(n);
        if(s % 1 == 0) return (long)((s+1)*(s+1));
        return -1;
    }
}