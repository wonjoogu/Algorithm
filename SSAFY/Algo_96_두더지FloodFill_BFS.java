package algorithm_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_96_두더지FloodFill_BFS {
	static int N;
	static int[][] map;
	static int[] count; // 2~10그룹까지 있으면 2그룹에 몇개, 3에 몇개 이런식으로 카운트
	static int[][] visited;
	static int[] dr = { -1, 1, 0, 0 };// 상하좌우
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new int[N][N];
		count = new int[N * N / 2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 로직
		int cnt = 0; // 단지 개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visited[i][j] == 0) {
					cnt++;
					go(i, j, cnt + 1); // 2단지부터 시작
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}
		
		// 출력
		System.out.println(cnt);
		int[] nums = new int[cnt];//그룹이 cnt개, 그룹 갯수만큼 
		for (int k = 0; k < cnt; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == k + 2) {
						nums[k]++;
					}
				}
			}
		}
		System.out.println(Arrays.toString(nums));//몇개 들어갔는지 궁금하면 보기
	}

	private static void go(int r, int c, int g) {// g: 그룹
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { r, c });// 시작점 지정
		visited[r][c] = g;
		while (!que.isEmpty()) {
			int[] cu = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cu[0] + dr[d];
				int nc = cu[1] + dc[d];
				if (!check(nr, nc)) {
					continue;
				}
				if (visited[nr][nc] == 0 && map[nr][nc] == 1) {
					que.offer(new int[] { nr, nc });
					visited[nr][nc] = g;
				}
			}
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
