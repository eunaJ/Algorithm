import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] sa1 = br.readLine().split(" ");
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<sa1.length; i++){
            hm.put(Integer.parseInt(sa1[i]), i);
        }
        int m = Integer.parseInt(br.readLine());
        String[] sa2 = br.readLine().split(" ");
        int[] a2 = new int[m];
        for(int i=0; i<sa2.length; i++){
            a2[i] = Integer.parseInt(sa2[i]);
        }

        for(int i=0; i<m; i++){
            if(hm.containsKey(a2[i])) System.out.println(1);
            else System.out.println(0);
        }
    }
}