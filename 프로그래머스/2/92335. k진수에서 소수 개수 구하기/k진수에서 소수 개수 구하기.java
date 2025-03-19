class Solution {
    public int solution(int n, int k) {
        int nn = n;
        StringBuilder kNum = new StringBuilder();
        while(n > 0){
            kNum.append(n % k);
            n /= k;
        }
        kNum.reverse();
        
        int answer = 0;
        String[] sa = kNum.toString().split("0");
        for(int i=0; i<sa.length; i++){
            if(!sa[i].isEmpty()){
                if(isPrime(Long.parseLong(sa[i]))) answer++;
            }
        }
        return answer;
    }
    
    public boolean isPrime(long num){
        if(num < 2) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        for(long i=3; i*i<=num; i+=2){
            if(num % i == 0) return false;
        }
        return true;
    }
}