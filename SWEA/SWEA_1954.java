package algorithm;

import java.util.Scanner;

public class swea_1954_달팽이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();//배열크기
			int[][] map = new int[n][n];
			
			int cnt = 1;//배열 각 칸에 넣을 숫자
			int dir = 1;//진행방향 값. 1 or -1 (1:증가, -1:감소)
			int x = 0, y = -1;//시작점 (x, y) y가 -1인 이유는 우로 갔을 때 +1을 했을 때 0이 될 수 있게 0행 0열이 되야하니까 (첫번째칸 건너뛰면 안되니까)
			
			while(true) {
				//우->하->좌->상
				
				//우: y가 증가, 좌: y가 감소
				for (int k = 0; k < n; k++) {
					y = y + dir;//y값 증가
					map[x][y] = cnt;
					cnt++;
				}
				
				n--;//우->하, 좌->상 , 하나씩 숫자가 줄어드니까
				if(n == 0) //n이 출력하는 개수니까
					break;
				
				//하: x가 증가, 상: x가 감소
				for (int j = 0; j < n; j++) {
					x = x + dir;//x값 증가
					map[x][y] = cnt;
					cnt++;
				}
				//하에서 좌로 갈 때는 갯수가 안변하니까
				
				//while-for 순서 : 우로 y증가하고 하로 가면서 갯수 하나 줄고, x가 증가하고, 다음 위로 올라가서 좌로 갈때 갯수 안변하니까 dir로 방향값만 바꿔서 y가 감소하고, 상으로 가면서 x 감소!
				dir = dir * -1;//-1로 바뀐다. 방향값을 바꿔줌
				
			}//while
			
			System.out.println("#" + tc);
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			
		}//for
	}
}
