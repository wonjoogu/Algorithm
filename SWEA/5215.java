package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5215_햄버거다이어트 {
	static int map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());// 재료 갯수
			int L = Integer.parseInt(st.nextToken());// 제한 열량
			
			map = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			int idx = 0;
			int score = 0;

			int max = find(idx, score, L);
			System.out.println("#" + tc + " " + max);

		}

	}

	private static int find(int idx, int score, int remain) {
		if (remain < 0) {
			return 0;
		}
		if (remain == 0) {
			return score;
		}
		if (idx == map.length) {
			return score;
		}

		int v1 = find(idx + 1, score, remain);
		int v2 = find(idx + 1, score + map[idx][0], remain - map[idx][1]);

		return Math.max(v1, v2);
	}

}
