import java.util.*;
import java.io.*;

class Main {
    static int[] check;
    static int n, k, answer;
    static Queue<Integer> q;
    static int max = 100001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        k = Integer.parseInt(sa[1]);
        check = new int[max];
        answer = 0;
        q = new LinkedList<>();
        q.add(n);
        bfs(n, 0);
        System.out.println(answer);
    }

    public static void bfs(int x, int c){
        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == k) {
                answer = check[cur];
                return;
            }
            int[] next = {cur-1, cur+1, 2*cur};
            for(int nxt : next){
                if(nxt >= 0 && nxt < max && check[nxt] == 0){
                    q.add(nxt);
                    check[nxt] = check[cur] + 1;
                }
            }
        }
    }
}