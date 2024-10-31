import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int[] a = new int[8];
        int[] d = new int[8];
        String answer = "";
        for(int i=0; i<8; i++){
            a[i] = i+1;
            d[i] = 8-i;
        }
        boolean isA = true;
        boolean isD = true;
        for(int i=0; i<7; i++){
            if(isA && Integer.parseInt(sa[i]) == a[i]){
                answer = "ascending";
                isD = false;
            } else if(isD && Integer.parseInt(sa[i]) == d[i]){
                answer = "descending";
                isA = false;
            } else {
                answer = "mixed";
                break;
            }
        }
        System.out.println(answer);
    }
}

// boolean을 넣음으로 성공
// 1 2 3 4 5 6 7 8 이 한번씩만 나옴
// 직접 만들지 않고 정렬한 배열과 비교해도 될 듯rt java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int[] a = new int[8];
        int[] d = new int[8];
        String answer = "";
        for(int i=0; i<8; i++){
            a[i] = i+1;
            d[i] = 8-i;
        }
        boolean isA = true;
        boolean isD = true;
        for(int i=0; i<7; i++){
            if(isA && Integer.parseInt(sa[i]) == a[i]){
                answer = "ascending";
                isD = false;
            } else if(isD && Integer.parseInt(sa[i]) == d[i]){
                answer = "descending";
                isA = false;
            } else {
                answer = "mixed";
                break;
            }
        }
        System.out.println(answer);
    }
}

// boolean을 넣음으로 성공
// 1 2 3 4 5 6 7 8 이 한번씩만 나옴
