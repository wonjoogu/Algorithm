package algorithm_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2056_연월일달력 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();

			if(input.length() != 8) {
				System.out.println("#" + tc + " " + "-1");
			}
			
			String y = input.substring(0, 4);
			String m = input.substring(4, 6);
			String d = input.substring(6, 8);

			int year = Integer.parseInt(y);
			int month = Integer.parseInt(m);
			int day = Integer.parseInt(d);

			if (month < 1 || month > 12) {
				System.out.println("#" + tc + " " + "-1");
				continue;
			}

			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				if (day < 1 || day > 31) {
					System.out.println("#" + tc + " " + "-1");
					continue;
				}
			}

			if (month == 9 || month == 11 || month == 4 || month == 6) {
				if (day < 1 || day > 30) {
					System.out.println("#" + tc + " " + "-1");
					continue;
				}
			}

			if (month == 2) {
				if (day < 1 || day > 28) {
					System.out.println("#" + tc + " " + "-1");
					continue;
				}
			}
			System.out.println("#" + tc + " " + y + "/" + m + "/" + d);
		}
	}
}
