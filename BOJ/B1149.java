package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] home = new int[N][3];
		int[][] memo = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			home[i][0] = Integer.parseInt(st.nextToken());
			home[i][1] = Integer.parseInt(st.nextToken());
			home[i][2] = Integer.parseInt(st.nextToken());
		}
		
		memo[0] = home[0];
		for (int i = 1; i < N; i++) {
			home[i][0] = Math.min(home[i-1][1], home[i-1][2]) + home[i][0];
			home[i][1] = Math.min(home[i-1][0], home[i-1][2]) + home[i][1];
			home[i][2] = Math.min(home[i-1][0], home[i-1][1]) + home[i][2];
		}
		
		int answer = Math.min(home[N-1][0], Math.min(home[N-1][1], home[N-1][2]));
		System.out.println(answer);
	}

}
