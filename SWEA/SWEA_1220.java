import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
 
        int T = 10;
        int[][] map = new int[100][100];
 
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#" + tc + " ");
            int N = Integer.parseInt(br.readLine());// 100
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            int ans = 0;
            boolean check = false;
            for (int j = 0; j < N; j++) {
                check = false;
                for (int i = 0; i < N; i++) {
                    if (check == false && map[i][j] == 1) {
                        check = true;
                        continue;
                    }
                    if (check == true && map[i][j] == 2) {
                        ans++;
                        check = false;
                        continue;
                    }
                }
            }
            sb.append(ans + "\n");
 
        }
        System.out.println(sb.toString());
 
    }
 
}
