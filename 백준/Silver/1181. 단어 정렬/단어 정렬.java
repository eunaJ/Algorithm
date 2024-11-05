import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<n; i++){
            hs.add(br.readLine());
        }
        ArrayList<String> li = new ArrayList<>(hs);
        Collections.sort(li, (o1, o2)->{
            if(o1.length() != o2.length()) return o1.length()-o2.length();
            else return o1.compareTo(o2);
        });
        for(String s : li){
            System.out.println(s);
        }
    }
}