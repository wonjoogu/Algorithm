package algorithm_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2072_홀수만더하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[10];

		for (int tc = 1; tc <= T; tc++) {
			int sum = 0;//sum계속 초기화 해줘야하니까
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (arr[i] % 2 == 1) {
					sum += arr[i];
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}
