package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1974_스도쿠검증 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int T;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {

		T = Integer.parseInt(input.readLine());
		// map은 하나만 만들어도 되겠다.. - 매번 똑같은 사이즈니까.
		map = new int[9][9];
		for (int t = 1; t <= T; t++) {
			for (int r = 0; r < 9; r++) {
				tokens = new StringTokenizer(input.readLine());
				for (int c = 0; c < 9; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			/*
			 * for(int [] row: map) { System.out.println(Arrays.toString(row)); }
			 */
			// 입력 처리 완료

			int answer = 0;
			if (checkLine() && checkSquare()) {
				answer = 1;
			}
			output.append(String.format("#%d %d%n", t, answer));
		}
		System.out.println(output);
	}

	static boolean checkSquare() {
		boolean[] visited = new boolean[10];
		// 3칸씩 증가하는 형태로 가보자.!!!
		for (int r = 0; r < 9; r += 3) {
			for (int c = 0; c < 9; c += 3) {
				// 꼭지점이 발견 --> 가로 세로 3칸씩 가보자!!!
				Arrays.fill(visited, false);
				for (int r2 = r; r2 < r + 3; r2++) {
					for (int c2 = c; c2 < c + 3; c2++) {
						if (visited[map[r2][c2]]) {
							return false;
						} else {
							visited[map[r2][c2]] = true;
						}
					}
				}
			}
		}
		return true;
	}

	static boolean checkLine() {
		boolean[] visited = new boolean[10];
		for (int i = 0; i < 9; i++) {
			Arrays.fill(visited, false);
			// 세로로 먼저 찾아보고
			for (int c = 0; c < 9; c++) {
				// 기존에 그 숫자를 만난적이 있다면...
				if (visited[map[i][c]]) {
					return false;
				}
				// 처음 나온 녀석이면 표시해주기.
				else {
					visited[map[i][c]] = true;
				}
			}
			// 가로로 찾아보고.
			// 방문 표시 배열 초기화
			Arrays.fill(visited, false);
			for (int r = 0; r < 9; r++) {
				if (visited[map[r][i]]) {
					return false;
				} else {
					visited[map[r][i]] = true;
				}
			}
		}
		return true;
	}
}

