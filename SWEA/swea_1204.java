package algorithm_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea_1204_최빈수구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int[] input = new int[101];
			int t = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = 0;
			int result = 0;
			
			for (int i = 0; i < 1000; i++) {
				int score = Integer.parseInt(st.nextToken());
				input[score]++;
			}
			
			for (int i = 0; i < 101; i++) {
				if(max<=input[i]) {
					max = input[i];
					result = i;
				}
			}
			System.out.println("#" + tc + " " + result);
		}
		
	}

}
