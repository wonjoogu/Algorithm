package algorithm_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2071_평균값구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[10];
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double sum = 0;//자료형 주의 !!!
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			System.out.println("#" + tc + " " + Math.round(sum / 10));
		}
	}

}
