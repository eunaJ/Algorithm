import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int c = 0;
        for(int i=0; i<N; i++){
            boolean isPrime = true;
            int n = sc.nextInt();
            if(n == 1) continue;
            for(int j=2; j<=Math.sqrt(n); j++){
                if(n % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) c++;
        }
        System.out.println(c);
    }
}