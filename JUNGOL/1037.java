package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class jungol_1037_오류교정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1. 행, 열 한 줄 씩 읽으면서 합이 짝수이면 ok 출력
		// 2. 합이 홀수이면 홀수 좌표 받아오기
		// 3. 합이 홀수인게 2개 이상이면 Corrupt 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<Integer> vertical = new ArrayList<Integer>();
		ArrayList<Integer> horizontal = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			int sumRow = 0;
			int sumCol = 0;

			for (int j = 0; j < N; j++) {
				sumRow += arr[i][j];//행의 모든 열들에 대한 검사
				sumCol += arr[j][i];//열의 모든 행들에 대해 검사
			}
			if (sumRow % 2 == 1)
				horizontal.add(i);
			if (sumCol % 2 == 1)
				vertical.add(i);
		}
		int vSize = vertical.size();
		int hSize = vertical.size();
		if (vSize == 0 && hSize == 0) {
			System.out.println("OK");
		} else if (vSize == 1 && hSize == 1) {
			System.out.println("Change bit (" + (horizontal.get(0)+1) + "," + (vertical.get(0)+1) +")");
		}else {
			System.out.println("Corrupt");
		}
	}

}
