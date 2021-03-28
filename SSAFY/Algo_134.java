package com.algo.study;

import java.util.Scanner;
//nPr 느낌
public class Algo_134_연구활동가는길 {
	static int N;
	static int M;
	static int[][] map;
	static int[][] newp;
	static boolean[] visited;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][M + 1];
		newp = new int[M][3];// s e w
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 3; j++) {
				newp[i][j] = sc.nextInt();
			}
			map[newp[i][0]][newp[i][1]] = newp[i][2];
			map[newp[i][1]][newp[i][0]] = newp[i][2]; // 양방향으로
		}
		min = Integer.MAX_VALUE;
		dfs(1,0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void dfs(int v, int w) {//v- vertex, w - weight
		
		if(N == v) {
			if(min > w) {
				min = w;
			}
			return;
		}
		
		for (int i = 1; i < N + 1; i++) {
			if(!visited[v] && map[v][i] != 0) {
				visited[v] = true;
				dfs(i, w + map[v][i]);
				visited[v] = false;
			}
		}
	}
}
