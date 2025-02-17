import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        int m = Integer.parseInt(sa[1]);
        HashSet<String> people = new HashSet<>();
        HashSet<String> nugu = new HashSet<>();
        for(int i=0; i<n; i++){
            people.add(br.readLine());
        }
        for(int i=0; i<m; i++){
            String p = br.readLine();
            if(people.contains(p)){
                nugu.add(p);
            }
        }
        List<String> answer = new ArrayList(nugu);
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size() + "\n");
        for(String s : answer){
            sb.append(s + "\n");
        }
        System.out.println(sb);
    }
}