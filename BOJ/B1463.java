package algorithm;

import java.util.Scanner;

public class B1463_1로만들기 {

	// 점화식 만들어가는게 중요
	static int[] memo;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		memo = new int[N + 1];//N을 1로 만들 때 필요한 최소 연산 횟수 저장 배열

		memo[1] = 0;//1을 1로 만들때 필요한 최소 연산 횟수 저장

		for (int i = 2; i <= N; i++) {
			memo[i] = memo[i - 1] + 1;//n -1 연산의 경우, + 1은 연산 횟수를 증가해주는 것
			
			if(i % 2 == 0 && memo[i] > memo[i / 2] + 1) {
				memo[i] = memo[i / 2] + 1;
			}
			if(i % 3 == 0 && memo[i] > memo[i / 3] + 1) {
				memo[i] = memo[i / 3] + 1;
			}
		}
		System.out.println(memo[N]);
	}

}
