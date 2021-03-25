package com.algo.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_1681_해밀턴순환회로 {
	static int N;
	static boolean [] visit;
	static int INF = Integer.MAX_VALUE;
	static int[][] matrix;
	
	public static void dfs(int x, int idx, int cost){
		if(cost >= INF) {
			return;
		}
		if(idx == N - 1) {
			if(matrix[x][0] != 0) {
				INF = Math.min(INF, cost + matrix[x][0]);
			}
			return;
		}
		for (int i = 1; i < N; i++) {//0은 회사니까 1부터 출발
			if(!visit[i] && matrix[x][i] != 0) {//방문한 적 없고, 0이 아니면
				visit[i] = true;//방문처리 해준다
				dfs(i, idx+1, matrix[x][i] + cost);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());//정점 수

		matrix = new int[N][N];
		visit = new boolean[N];
		StringTokenizer st = null;
		for (int i = 0; i <= N ; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,0);
		System.out.println(INF);
	}
}
