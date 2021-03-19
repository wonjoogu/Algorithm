package com.algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_8382_방향전환 {

	static int T;
	static int x1, y1, x2, y2;//시작점, 끝점
	static int[] dr = {-1,0,1,0};//짝수, 홀수를 만들어주기 위해서 (상좌하우), 0 1 2 3(상,하:짝, 좌,우:홀)
	static int[] dc = {0,-1,0,1};//짝수, 홀수를 만들어주기 위해서
	static int[][][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken()) + 100;
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100; //(x1,y1,x2,y2)순서 중요!
			
			visited = new int[201][201][2];//0부터 200까지니까, 2가지로 갔나 안갔나 확인
			Queue<int[]> que = new LinkedList<int[]>();
			que.offer(new int[] {x1, y1, 0, 0});//시작, 거리, 방향을 넣어줌
			que.offer(new int[] {x1, y1, 0, 1});//시작, 거리, 방향을 넣어줌
			int val = -1;//안됐다는 얘기
			while(!que.isEmpty()) {//안 비었냐 ~?
				int[] current = que.poll();//그럼 현재 값 하나 받아
				int r = current[0]; // x
				int c = current[1];	// y
				int cnt = current[2]; // 이동 회수
				int dir = current[3]; // 방향
				if(r == x2 && c == y2) {//r이 x2에 도달했거나 c가 y2에 도달했을 때
					val = cnt;//간 거리를 올려주고 
					break;
				}
				// dir 0, 2 => +d(홀수) 일때 홀수가 되야함(만약 짝수가 들어오면 홀수로 만들어줘야함)
				// dir 1, 3 => +d(홀수) 일때 짝수가 되야함(만약 홀수가 들어오면 짝수로 만들어줘야함)
				for (int d = 1; d < 4; d+=2) {//2개의 방향
					int s = (dir + d) % 4;//범위를 벗어날 수 없게하려고 사용
					int u = (dir + d) % 2;//짝수, 홀수 알아서 방향 바꿔줌(들어왔던 dir의 반대방향으로 가게해줌)
					int nr = r + dr[s];
					int nc = c + dr[s];
					if(!check(nr, nc)) {//없냐~? 없으면 continue
						continue;
					}
					if(visited[nr][nc][u] == 0) {//짝수로 되있는 좌표의 새로운 좌표에 방문 안했으면~
						visited[nr][nc][u] = 1;//왔다고 표시, 반복하면서 홀수도 체크 !
						que.offer(new int[] {nr, nc, cnt + 1, s});
					}
				}
			}
			System.out.println("#" + tc + " " + val);
		} 
		
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < 201 && c >= 0 && c < 201;
	}

}
