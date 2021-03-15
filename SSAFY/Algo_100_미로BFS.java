package algorithm_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_100_미로BFS {
	static int H, W;
	static char[][] map;
	static int[][] visited;
	static int sr, sc, er, ec;//start row, col, end row, col
	static int[] dr = {-1,1,0,0};//상하좌우
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		visited = new int[H][W];
		for (int i = 0; i < H; i++) {
			String input = br.readLine();
			map[i] = input.toCharArray();
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j] == 'S') {
					sr = i;
					sc = j;
				}else if(map[i][j] == 'G') {
					er = i;
					ec = j;
				}
			}
		}
		//로직
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {sr,sc});//시작점 2차원 배열 넣어줌
		visited[sr][sc] = 0;//자기자신을 0부터 시작하겠다
		while(!que.isEmpty()) {
			int[] cu = que.poll();
			if(cu[0] == er && cu[1] == ec) {
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = cu[0] + dr[d];
				int nc = cu[1] + dc[d];
				if(!check(nr, nc)) {
					continue;
				}
				if(visited[nr][nc] == 0 && (map[nr][nc] == '.' || map[nr][nc] == 'G')) {
					que.offer(new int[] {nr,nc});//시작점 2차원 배열 넣어줌
					visited[nr][nc] = visited[cu[0]][cu[1]]+1;//자기자신을 0부터 시작하겠다
				}
			}
		}
		//출력
		System.out.println(visited[er][ec]);
	}
	static boolean check(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}
}
