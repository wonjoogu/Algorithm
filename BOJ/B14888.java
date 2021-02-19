package algorithm;

import java.util.Scanner;

public class B14888_연산자끼워넣기 {
	static int N;
	static int[] input;
	static int[] cal = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();//수의 개수
		input = new int[N];//수
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		for (int i = 0; i < 4; i++) {
			cal[i] = sc.nextInt();
		}
		
		dfs(input[0], 1);
		System.out.println(max + "\n" + min);
		
	}
	
	private static void dfs(int inputnum, int idx) {
		if(idx == N) {
			max = Math.max(max, inputnum);
			min = Math.min(min, inputnum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(cal[i] != 0) {
				cal[i]--;
				switch (i) {
				case 0:
					dfs(inputnum + input[idx], idx + 1);
					break;
				case 1:
					dfs(inputnum - input[idx], idx + 1);
					break;
				case 2:
					dfs(inputnum * input[idx], idx + 1);
					break;
				case 3:
					dfs(inputnum / input[idx], idx + 1);
					break;
				}
				cal[i]++;//왜 빼주고 늘려주는지??
			}
		}
	}

}
