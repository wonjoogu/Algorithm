package algorithm_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2293_동전1 {
/*
 * 1, 2, 5를 이용해서 만드는 경우의 수
 * 1 : 1 
 * 2 : 1 + 1, 2
 * 3 : 1 + 1 + 1, 1 + 2
 * 4 : 1 + 1 + 1 + 1, 1 + 1 + 2, 2 + 2
 * 5 : 1 + 1 + 1 + 1 + 1, 1 + 1 + 1 + 2, 1 + 2 + 2, 5
 * 2를 사용해서 5를 만드는 경우의 수는 1과 2를 사용해서 3을 만드는 경우의 수에서 더한 것
 * 따라서 2(A)를 사용해서 5(B)를 만드는 경우의 수는 5 - 2를 만드는 경우의 수 (B-A)
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());//동전의 종류 수
		int k = Integer.parseInt(st.nextToken());//동전의 가치
		int[] memo = new int[k + 1];
		int coin = 0;
		
		memo[0] = 1;
		for (int i = 0; i < n; i++) {
			coin = Integer.parseInt(br.readLine());
			for (int j = 1; j <= k; j++) {
				if(j >= coin) {
					memo[j] += memo[j - coin];
				}
			}
		}
		System.out.println(memo[k]);
	}

}
