import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
		String s = st.nextToken();
		int i = Integer.parseInt(bf.readLine());
        System.out.println(s.charAt(i-1));
    }
}