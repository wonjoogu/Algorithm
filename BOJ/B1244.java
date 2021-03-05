package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1244_스위치켜고끄기 {
	static int N;
	static int[] light;
	static int student;
	static int gender;
	static int number;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		light = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			light[i] = Integer.parseInt(st.nextToken());
		}

		student = Integer.parseInt(br.readLine());
		for (int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			number = Integer.parseInt(st.nextToken());

			if (gender == 1) {
				for (int j = 0; j < N; j++) {
					if ((j + 1) % number == 0) {
						light[j] = light[j] == 0 ? 1 : 0;
					}
				}
			} else {
				light[number - 1] = light[number - 1] == 0 ? 1 : 0;
				for (int j = 1; j < N/2; j++) {
					if(number - 1 + j >= N || number - 1 - j < 0) {
						break;
					}
					if(light[number - 1 - j] == light[number - 1 + j]) {
						light[number - 1 - j] = light[number - 1 - j] == 0 ? 1 : 0;
						light[number - 1 + j] = light[number - 1 + j] == 0 ? 1 : 0;
					}
					else {
						break;
					}
				}
			}

		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(light[i] + " ");
			if((i+1) % 20 == 0) {
				System.out.println();
			}
		}
	}

}
