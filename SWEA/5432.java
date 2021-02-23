package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea_5432_쇠막대기자르기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T;//테케 번호
	static String line;//테케 문자열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		input = new BufferedReader(input);
		
		T = Integer.parseInt(input.readLine());

		for (int tc = 1; tc <= T; tc++) {
			line = input.readLine();
			int stickCnt = 0;//막대기 수
			int pieces = 0;//조각
			char pre = '\u0000';//이전 문자
			
			for (int i = 0; i < line.length(); i++) {
				Stack<Integer> stack = new Stack<>();
				
				if(line.charAt(i) == '(') {// 열린괄호가 나오면
					stack.push(stickCnt++);//막대기 수 1증가
				}else {//닫는 괄호이면
					stack.push(stickCnt--);//막대기 수 1감소
					if(pre == '(') {//그 전 문자가 열린 괄호이면
						stack.push(pieces += stickCnt);//조각에 막대기 수 누적
					}else {//
						stack.push(pieces++);
					}
				}
				pre = line.charAt(i);
			}
			output.append(String.format("#%d %d%n", tc, pieces));
		}
	System.out.println(output);
	}
}
