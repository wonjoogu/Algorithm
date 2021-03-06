package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3499_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());// 테케

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());// 자연수
			String[] s1 = new String[N];
			String[] s2 = new String[N];
			

			int a = 0, b = 0;
			if (N % 2 == 1) {// 홀일때
				a = N / 2 + 1;// 짝
				b = N / 2;// 홀
			} else {// 짝일때
				a = N / 2;
				b = N / 2;
			}

			// st = new StringTokenizer(br.readLine(), " ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < a; i++) {
				s1[i] = st.nextToken();
			}

			for (int i = 0; i < b; i++) {
				s2[i] = st.nextToken();
			}

			String[] s3 = new String[N];

			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					s3[i] = s1[i / 2];
					sb.append(s3[i] + " ");

				} else {
					s3[i] = s2[i / 2];
					sb.append(s3[i] + " ");
				}
			}				sb.append("\n");

		}
		System.out.println(sb);
	}
}
