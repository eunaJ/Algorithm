import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int answer = 0;
	    while(n > 0){
	        if(n % 5 == 0) {
                answer += n/5;
                break;
            } else { // n이 5로 안 나눠지면 3으로 나눠지거나 나누기X
                n -= 3;
                answer++;
	        }
            if(n < 0) answer = -1;
	    }
		System.out.println(answer);
    }
}