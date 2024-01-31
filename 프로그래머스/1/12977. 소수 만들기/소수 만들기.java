class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    int n = nums[i]+nums[j]+nums[k];
                    if(n >= 2) 
                        if(check(n))
                            answer++;                    
                }
            }
        }
        return answer;
    }
    public boolean check(int n) {
        if(n == 2) return true;
        else{
            for(int i=2; i<n; i++){ 
                if(n%i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}