import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            for(int j=0; j<k; j++){
                String[] sa = br.readLine().split(" ");
                String s = sa[0];
                int value = Integer.parseInt(sa[1]);
                if(s.equals("I")){
                    tm.put(value, tm.getOrDefault(value, 0)+1); // 입력받은 정수가 있다면 증가
                } else {
                    if(tm.isEmpty()) continue;
                    else {
                        int n = (value == 1) ? tm.lastKey() : tm.firstKey();
                        if(tm.put(n, tm.get(n)-1) == 1) tm.remove(n); // 해당 개수 0이면 삭제
                    }
                }
            }
            if(tm.isEmpty()) sb.append("EMPTY" + "\n");
            else sb.append(tm.lastKey() + " " + tm.firstKey() + "\n");
        }
        System.out.println(sb);
    }
}

// TreeMap 사용