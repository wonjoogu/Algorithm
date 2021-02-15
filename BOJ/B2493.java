package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//탑
public class B2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Tower> stack = new Stack<>();//탑 저장
		int height, no;
		
		//int T = Integer.parseInt(br.readLine());
		//6,9,5,7,4
		int N = Integer.parseInt(br.readLine());//탑 갯수
		StringTokenizer st = new StringTokenizer(br.readLine());//탑 높이가 N개 들어온다.
		
		//입력받은 탑 높이를 하나씩 체크
		for (no = 1; no <= N; no++) {
			height = Integer.parseInt(st.nextToken());//st에 저장되어있던 높이 중 맨 처음 값이 나온다.
			
			//stack 안 체크
			while(!stack.isEmpty()) {//stack이 안비었다면
				//비교: height(오른쪽 탑) : 현재 높이, stack.peek().height()(왼쪽탑): stack 안에 있던 탑
				if(stack.peek().height >= height) {//스택 안에 있던 탑이 신호를 받아줌
					System.out.print(stack.peek().no + " ");//갖고있던 Top 번호를 갖고옴
					break;//찾았으니까 
				}
				
				//더 낮은 탑이면 어차피 앞으로도 계속 신호를 못 받으니까  삭제
				stack.pop();
			}
			
			//맨 처음이거나 위에서 작업 중 스택이 비었거나 한 경우
			if(stack.isEmpty()) {//stack이 비었다면
				System.out.print(0 + " ");
			}
			//뒤에 오는 다른애의 신호를 받을 수 있으므로 스택에 넣음(모든 탑 객체가 한번씩은 다 들어감)
			stack.push(new Tower(height, no));
		}
	}
	
	static class Tower{
		int height;//탑 높이
		int no;//탑 위치 번호
		
		public Tower(int height, int no) {
			this.height = height;
			this.no = no;
		}
	}
}
