package algorithm_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9251_LCS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int cnt = 0;
		int[][] LCS = new int[a.length() + 1][b.length() + 1];
		
		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				if(a.charAt(i - 1) == b.charAt(j - 1)) {// 값이 같을 때
					LCS[i][j] = LCS[i - 1][j - 1] + 1;//좌측에서 위쪽의 값에서 + 1
					//cnt = Math.max(cnt, LCS[i][j]);
				}else {// 값이 다를 때
					LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);// 좌측 또는 위쪽의 값 중 최대값
				}
			}
		}
		System.out.println(LCS[a.length()][b.length()]);
	}

}
