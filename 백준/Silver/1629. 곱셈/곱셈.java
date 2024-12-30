import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        long a = Integer.parseInt(sa[0]);
        long b = Integer.parseInt(sa[1]);
        long c = Integer.parseInt(sa[2]);
        long answer = 1;
        if(a > c) a = a % c; // 분배법칙
        while(true){
            if(b == 1) break;
            if(b % 2 == 1){
                answer = (answer * a) % c; // 분배법칙
                b--;
            }
            a = (a * a) % c; // 분배법칙
            b /= 2;
        }
        answer = (answer * a) % c;
        System.out.println(answer);
    }
}

// 반복을 줄이는 방법 생각