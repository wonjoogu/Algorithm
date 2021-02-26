package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10163_색종이 {
	static int x;
	static int y;
	static int w;
	static int h;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		map = new int[101][101];

		for (int tc = 1; tc <= N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			for (int i = x; i < x + w; i++) {
				for (int j = y; j < y + h; j++) {
					map[i][j] = tc;
				}
			}
		}

		for (int k = 1; k <= N; k++) {
			int cnt = 0;
			for (int i = 0; i < 101; i++) {
				for (int j = 0; j < 101; j++) {
					if (map[i][j] == k)
						cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//	int N = Integer.parseInt(br.readLine());// 색종이 수
//int[][] map = new int[101][101];// 좌표, 너비, 높이
//
//// x,y좌표 읽어서 a,b 만큼 더해주기
//	for(
//	int tc = 1;tc<=N;tc++)
//	{
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		int x = Integer.parseInt(st.nextToken());// 좌표
//		int y = Integer.parseInt(st.nextToken());// 좌표
//		int a = Integer.parseInt(st.nextToken());// 너비
//		int b = Integer.parseInt(st.nextToken());// 높이
//
//		for (int i = x; i < x + a; i++) {
//			for (int j = y; j < y + b; j++) {
//				map[i][j] = tc;
//			}
//		}
//	}for(
//	int k = 1;k<=N;k++)
//	{
//		int cnt = 0;
//		for (int i = 0; i < 101; i++) {
//			for (int j = 0; j < 101; j++) {
//				if (map[i][j] == k) {
//					cnt++;
//				}
//			}
//		}
//		System.out.println(cnt);
//	}
//}
