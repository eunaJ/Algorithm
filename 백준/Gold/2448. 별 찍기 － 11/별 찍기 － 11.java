import java.util.*;
import java.io.*;

class Main {
    static char[][] stars;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stars = new char[n][2*n-1];
        for(int i=0; i<n; i++){
            Arrays.fill(stars[i], ' ');
        }
        star(0, n-1, n);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<2*n-1; j++){
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void star(int r, int c, int n){
        if(n == 3){ // 가장 작은 삼각형일 때 별 찍기
            stars[r][c] = '*';
            stars[r+1][c-1] = stars[r+1][c+1] = '*';
            stars[r+2][c-2] = stars[r+2][c-1] = stars[r+2][c] = stars[r+2][c+1] = stars[r+2][c+2] = '*';
            return;
        } else { // 삼각형 3개로 쪼개기
            int m = n / 2;
            star(r, c, m); // 위
            star(r+m, c-m, m); // 왼
            star(r+m, c+m, m); // 오
        }
    }
}

// 재귀