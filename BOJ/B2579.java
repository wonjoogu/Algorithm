package algorithm_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
6
10
20
15
25
10
20
 */
public class B2579_계단오르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int[] arr = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} 
		
		dp[0] = arr[0];
		dp[1] = arr[1];
		
		if(N >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
		}
		System.out.println(dp[N]);
	}

}
