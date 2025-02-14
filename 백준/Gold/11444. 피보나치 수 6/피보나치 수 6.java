import java.util.*;
import java.io.*;

class Main {
    public static long mod = 1000000007;
    public static long[][] a = {{1, 1}, {1, 0}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(fibo(a, n-1)[0][0]);
    }

    public static long[][] fibo(long[][] matrix, long exp){
        if(exp == 0 || exp == 1) return matrix;
        long[][] answer = fibo(matrix, exp/2);
        answer = multiply(answer, answer);
        if(exp % 2 != 0L) answer = multiply(answer, a);
        return answer;
    }

    public static long[][] multiply(long[][] m1, long[][] m2){
        long[][] answer = new long[2][2];
        answer[0][0] = ((m1[0][0]*m2[0][0])+(m1[1][0]*m2[0][1]))%mod;
        answer[0][1] = ((m1[0][0]*m2[0][1])+(m1[0][1]*m2[1][1]))%mod;
        answer[1][0] = ((m1[1][0]*m2[0][0])+(m1[1][1]*m2[1][0]))%mod;
        answer[1][1] = ((m1[1][0]*m2[0][1])+(m1[1][1]*m2[1][1]))%mod;
        return answer;
    }
}

// 분할정복
// 행렬제곱
// U5 = a^5*U0