class Solution {
    static boolean isNotMinLevel(int[] diffs, int[] times, long limit, long level){
        long t = (long)times[0];
        for(int i=1; i<times.length; i++){
            if(diffs[i] > level) t += ((long)times[i-1]+(long)times[i])*((long)diffs[i]-level);
            t += (long)times[i];
        }
        return limit < t;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        long left = 1;
        long right = limit;
        while(left < right){
            long mid = (left + right) / 2;
            if(isNotMinLevel(diffs, times, limit, mid)){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int)left;
    }
}

// Binary Search