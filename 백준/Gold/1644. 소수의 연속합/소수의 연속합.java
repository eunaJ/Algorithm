import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] primeArr = getPrime(n);
        int s = 0;
        int e = 0;
        int answer = 0;
        int sum = primeArr.length == 0 ? 0 : primeArr[0];
        while(s < primeArr.length){
            if(sum == n){
                answer++;
                sum -= primeArr[s];
                s++;
            } else if(sum > n){
                sum -= primeArr[s];
                s++;
            } else {
                if(e >= primeArr.length-1){
                    sum -= primeArr[s];
                    s++;
                } else {
                    e++;
                    sum += primeArr[e];
                }
            }
        }
        System.out.println(answer);
    }

    public static int[] getPrime(int n){
        if(n == 1) return new int[0];
        boolean[] isPrime = new boolean[n+1];
        int size = n - 1;
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        // 에라토스테네스의 체
        for(int i=2; i*i<=n; i++){
            if(!isPrime[i]) continue;
            for(int j=i*i; j<=n; j+=i){
                if(isPrime[j]){
                    isPrime[j] = false;
                    size--;
                }
            }
        }
        int idx = 0;
        int[] result = new int[size];
        for(int i=2; i<=n; i++){
            if(isPrime[i]) result[idx++] = i;
        }
        return result;
    }
}