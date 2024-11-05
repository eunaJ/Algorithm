import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] sa = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(String s : sa){
            int i = Integer.parseInt(s);
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        int m = Integer.parseInt(br.readLine());
        sa = br.readLine().split(" ");
        for(String s : sa){
            int num = Integer.parseInt(s);
            if(hm.containsKey(num)){
                sb.append(hm.get(num));
            } else {
                sb.append(0);
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }
}