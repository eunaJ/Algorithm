import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int W = Integer.parseInt(sa[0]);
        int N = Integer.parseInt(sa[1]);
        ArrayList<int[]> li = new ArrayList<>();
        for(int i=0; i<N; i++){
            sa = br.readLine().split(" ");
            li.add(new int[]{Integer.parseInt(sa[0]), Integer.parseInt(sa[1])});
        }
        Collections.sort(li, (o1, o2) -> o2[1]-o1[1]);
        int answer = 0;
        for(int l[] : li){
            if(W == 0) break;
            if(W >= l[0]) {
                answer += (l[0] * l[1]);
                W -= l[0];
            } else {
                answer += (W * l[1]);
                W = 0;
            }
        }
        System.out.println(answer);
    }
}


// 무게 당 가격이 주어졌을 때 배낭을 채울 수 있는 가장 값비싼 가격은?
// 전동톱으로 잘려진 무게만큼 가격을 가진다.
