package algorithm_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2050_알파벳을숫자로변환 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[26];
		String input = br.readLine();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.charAt(i) - 64; 
			System.out.print(arr[i] + " ");
		}
	}

}
