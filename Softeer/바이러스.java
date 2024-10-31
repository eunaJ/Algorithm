import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int k = Integer.parseInt(sa[0]);
        int p = Integer.parseInt(sa[1]);
        int n = Integer.parseInt(sa[2]);
        long answer = k;
        for(int i=1; i<=n; i++){
            answer = answer * p % 1000000007;
        }
        System.out.println(answer);
    }
}


// long을 int로 써서 시간 날림
