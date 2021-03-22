package com.algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1486_장훈이의높은선반 {
	
	static int T;
	static int N;
	static int B;
	static int[] p;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			p = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				p[i] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE / 1000;
			subset(0,0);
			System.out.println("#" + tc + " " + (min-B));
		}
	}

	private static void subset(int cnt, int sum) {
		
		if(cnt == N) {
			if(sum >= B) {
				min = Math.min(min, sum);
			}
			return;
		}
		
		subset(cnt + 1, sum + p[cnt]);//포함하고
		subset(cnt + 1, sum);//포함 안하고
	}

}
