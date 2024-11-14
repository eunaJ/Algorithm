import java.util.*;
import java.io.*;

class Main {
    static int n, r, c, answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        r = Integer.parseInt(sa[1]);
        c = Integer.parseInt(sa[2]);
        int size = (int)Math.pow(2, n);
        answer = 0;
        z(0, 0, size);
        System.out.println(answer);
    }

    public static void z(int y, int x, int size){
        while(size > 0){
            size /= 2;
            if(r < y + size && c < x + size){ // 1사분면
                answer += 0;
            } else if(r < y + size){ // 2사분면
                answer += size * size;
                x += size;
            } else if(c < x + size){ // 3사분면
                answer += size * size * 2;
                y += size;
            } else { // 4사분면
                answer += size * size * 3;
                x += size;
                y += size;
            }
            if(size == 1) break;
        }
    }
}