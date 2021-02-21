package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_9229_한빈이와SpotMart {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());// 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {// 봉지 개수만큼 반복
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());// 봉지 개수
			int M = Integer.parseInt(st.nextToken());// 최대 봉지 무게 합
			int[] a = new int[N];
			int x = -1;// 무게 최대값 안될 때 변수
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(st.nextToken());// 각각의 과자 봉지 무게
			}
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (a[i] + a[j] <= M) {// 첫번째 무게와 다음 무게와의 합 비교하여 최대값이거나 이하이거나
						x = Math.max(x, a[i] + a[j]);//최대값에 못 미치면 -1 출력
					}
				}
			}

			System.out.println("#" + tc + " " + x);
		}
	}
}
