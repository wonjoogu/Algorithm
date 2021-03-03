package algorithm_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2070_큰놈작은놈같은놈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
				if (a < b)
					sb.append("<" + "\n");
				else if (a > b)
					sb.append(">" + "\n");
				else
					sb.append("=" + "\n");
			}

		System.out.println(sb);

	}

}
