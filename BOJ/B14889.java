package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
4
0 1 2 3
4 0 5 6
7 1 0 2
3 4 5 0
*/
public class B14889_스타트와링크 {
	static int N;
	static int[][] map;
	static int[] team;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];// 1부터 시작하니까
		team = new int[N + 1];

		for (int i = 1; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combi(1, 0);// 1부터 시작
		System.out.println(min);
	}
	
	static int[] startT = new int[N/2];//팀원 번호 저장(N개의 수일 때 팀원 번호는 N/2의 수만큼)
	static int[] linkT = new int[N/2];
	static int s_cnt = 0, l_cnt = 0, s_sum = 0, l_sum = 0;//능력치의 합
	private static void combi(int start, int cnt) {
		if (cnt == N / 2) {
			for (int i = 1; i <= N; i++) {
				if (team[i] == 1) {//선택됐으면
					startT[s_cnt++] = i;//
				}else {
					linkT[l_cnt++] = i;
				}
			}
			
			for (int i = 0; i < N / 2; i++) {
				for (int j = i + 1; j < N / 2; j++) {
					s_sum += map[startT[i]][startT[j]] + map[startT[j]][startT[i]];//스타트 ij, ji의 합
					l_sum += map[linkT[i]][linkT[j]] + map[linkT[j]][linkT[i]];//링크 ij, ji의 합
				}
			}
			min = Math.min(min, Math.abs(s_sum - l_sum));//스타트와 링크의 차이
			return;
		}

		for (int i = start; i <= N; i++) {
			team[i] = 1;
			combi(i + 1, cnt + 1);
			team[i] = 0;
		}

	}

}
