package algorithm;

import java.util.Scanner;

//백설공주와 일곱 난쟁이
public class B3040 {
	static int[] people = new int[9];//입력 받은 난쟁이 수
	static int[] seven = new int[7];//7개의 값과 합이 100인 값 저장
	static int[] result = new int[7];//합이 100인 배열 값 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = 9;
		
		for (int i = 0; i < N; i++) {
			people[i] = sc.nextInt();
		}

		Combination(0, 0, 0);
		
		for (int i : result) {
			System.out.println(i);
		}
	}

	private static void Combination(int cnt, int start, int sum) {
		if (cnt == 7 && sum == 100) {//7개를 다 고르고, 합이 100이면 반환
			result = seven.clone();//배열 복사
			return;
		}else if(cnt == 7) {//7개 다 골랐으면 반환
			return;
		}

		for (int i = start; i < 9; i++) {
			seven[cnt] = people[i];
			Combination(cnt + 1, i + 1, sum + people[i]);
		}
	}
}
