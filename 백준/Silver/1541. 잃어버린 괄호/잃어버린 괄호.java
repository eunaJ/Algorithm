import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split("-");
        int answer = 0;
        for(int i=0; i<sa.length; i++){
            int temp = 0;
            String[] strArr = sa[i].split("\\+");
            for(int j=0; j<strArr.length; j++){
                temp += Integer.parseInt(strArr[j]);
            }
            if(i == 0) answer += temp;
            else answer -= temp;
        }
        System.out.println(answer);
    }
}

// 그리디, 문자열 파싱