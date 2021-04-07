package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//1. 공기 기준으로 작업
//2. 얘는 이따 녹을 애라고 표시만 해놓고 후에 작업하기
public class B2636_치즈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<Integer>();// 치즈가 있는 곳 저장
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());// 가로
		int C = Integer.parseInt(st.nextToken());// 세로
		int[][] map = new int[R][R];
		boolean[] visited = new boolean[R];// 녹지않은 것
		int sum = 0;
		
		for (int i = 0; i < R; i++) {// 간선 수 만큼 반복
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					sum++;
				}
			}
		}
		int count = 0;

		while (!q.isEmpty()) {
			int current = q.poll();// 요소 꺼내기
			for (int i = 1; i <= R; i++) {
				for (int j = 2; j <= C; j++) {
					if (map[current][i] != 0 && !visited[i]) {// 0이 아니고, 방문하지 않았으면
						q.add(i);// 큐에 추가
						visited[i] = true;
					}
				}
			}
		}
		int result = 0;

		for (int i = 2; i <= R; i++) {// 1을 제외하고
			for (int j = 2; j <= C; j++) {
				if (visited[i] == true) {// 방문한 노드들 카운트
					result++;
					// System.out.println(i);
				}
			}
		}
		System.out.println(result);
	}

}
