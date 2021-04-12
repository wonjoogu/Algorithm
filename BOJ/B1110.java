package algorithm_practice;

import java.io.IOException;
import java.util.Scanner;
/*
N = (N%10)*10	// T의 십의 자릿수
N = (N/10 + N%10)%10	// T의 일의 자릿수
N = ( (N%10)*10 ) + ( ((N/10) + (N%10))%10 )
*/
public class B1110 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		int copy = N;

		while (true) {
			N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
			cnt++;

			if (copy == N) {
				break;
			}
		}
		System.out.println(cnt);
	}
}
