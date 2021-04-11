package algorithm_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B9205_맥주마시면서걸어가기 {
	static int t;// 테케
	static int n;// 편의점 개수
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			ArrayList<int[]> list = new ArrayList<int[]>();//좌표 저장할 리스트
			map = new int[n + 2][n + 2];

			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				list.add(new int[] { x, y });// 시작점 저장
			}
			for (int i = 0; i < n + 2; i++) {
				int[] s = list.get(i);// 출발점 

				for (int j = 0; j < n + 2; j++) {
					if (i == j)
						continue;
					int[] e = list.get(j);// 도착점
					int distance = Math.abs(s[0] - e[0]) + Math.abs(s[1] - e[1]);
					map[i][j] = distance <= 1000 ? distance : Integer.MAX_VALUE;
				}
			}

			for (int i = 0; i < n + 2; i++) {// 경유지
				for (int j = 0; j < n + 2; j++) {// 출발
					for (int j2 = 0; j2 < n + 2; j2++) {// 도착
						if (i == j)
							continue;
						if (map[j][i] == Integer.MAX_VALUE || map[i][j2] == Integer.MAX_VALUE)
							continue;
						map[j][j2] = Math.min(map[j][j2], map[j][i] + map[i][j2]);
					}
				}
			}
			System.out.println(map[0][n + 1] != Integer.MAX_VALUE ? "happy" : "sad");
		}
	}

}
