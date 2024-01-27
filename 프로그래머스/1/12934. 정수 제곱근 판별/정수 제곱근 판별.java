class Solution {
    public long solution(long n) {
        double s = Math.sqrt(n);
        if(s % 1 == 0) return (long)((s+1)*(s+1));
        return -1;
    }
}

//
// if (Math.pow((int)Math.sqrt(n), 2) == n) {
//     return (long) Math.pow(Math.sqrt(n) + 1, 2);
// }    
// return -1;
