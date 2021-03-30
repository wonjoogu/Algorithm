package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1753_최단경로 {
	static int start, end, w;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());//정점개수
		int E = Integer.parseInt(st.nextToken());//간선개수
		
		int[][] adjMatrix = new int[V-1][V-1];//인접행렬
		int[] distance = new int[V];//D배열(시작점부터 자신으로 오는 최소 비용)
		boolean[] visited = new boolean[V];//하나씩 관리하는 배열
		
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < E; j++) {
				start = Integer.parseInt(st.nextToken());//임의의 시작 정점
				end = Integer.parseInt(st.nextToken());//임의의 도착 정점(마지막 번호 정점으로 가정)
				w = Integer.parseInt(st.nextToken());
				adjMatrix[start][end] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;//출발지를 0으로 놓고 출발
		
		for (int i = 0; i < V; i++) {
			int min = Integer.MAX_VALUE;
			int current = 0;// min 최소비용에 해당하는 정점 번호
			// step1. : 처리하지 않은 정점 중에 출발지에서 가장 가까운(최소비용) 정점 선택(방문하지 않은 정점들 중 최소가중치의 정점 선택)  // 최소값을 더 빠르게 찾기 위해 Priority Queue를 사용해본다.!pq.poll()로 확인하고, pq.offer로 업데이트
			for (int j = 0; j < E; j++) {// 모든 정점 중에서 시작점에서 가장 가까운 (가장 짧은) 정점번호와 그 거리를 저장해 놓음
				if(!visited[j] && min > distance[j]) { //아직 방문하지 않았고
					min = distance[j];//비용 저장
					current = j;//현재 최소값 기억하기 위해 저장, 정점 번호 저장
				}
			}//여기서 무조건 distance[start] = 0이 시작된다. 
			
			visited[current] = true;//고려한 정점이니까 true로 바꿔준다. // 가장 짧은 선택 정점 방문 처리
			if(current == end) break;//선택 정점이 도착 정점이면 탈출
			
			// step2. : 선택된 current를 경유지로 하여 아직 처리하지 않은 다른 정점으로의 최소비용 따져본다.
			// current 정점을 경유지로 하여 갈 수 있는 다른 방문하지 않은 정점들에 대한 처리
			for (int j = 0; j < V; j++) {
				if(!visited[j] && adjMatrix[current][j] != 0 && distance[j] > min + adjMatrix[current][j]) {//선택한 current 정점에서 , adjMatrix[current][j]->current에서 j까지 가는 비용
					distance[j] = min + adjMatrix[current][j];// 더 작은 값(경유해서 가는 값)으로 업데이트
				}
			}
		}
		System.out.println(distance[end]);//end 비용 출력하면 끝 !

		
	}

}
