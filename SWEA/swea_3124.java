package com.algo.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea_3124_최소스패닝트리 {

	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		
		public Edge() {
			
		}
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	static int TC;
	static int[] p;
	static int[] r;//rank
	static int V, E;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			makeSet();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				pq.offer(new Edge(from, to, weight));//집어넣는 순간 정렬됨
			}
			long sum = 0L;
			while(!pq.isEmpty()) {
				Edge me = pq.poll();
				if (!isConn(me.from, me.to)) {
					union(me.from, me.to);
					sum += me.weight;
				}
			}
			System.out.println("#" + t + " " + sum);
		}
	}
	static void makeSet() {
		p = new int[V];
		for (int i = 0; i < V; i++) {//make set
			p[i] = i;//자기 자신으로 초기화 
		}
		r = new int[V];
		for (int i = 0; i < V; i++) {//make set
			r[i] = 1;
		}
	}
	static int find(int x) {
		if(x == p[x]) return p[x];
		else return p[x] = find(p[x]);//부모의 부모의 부모를 올라가서 짱을 추적한다! 부모의 부모를 찾아라 !
	}
	static boolean isConn(int x, int y) {
		if(find(x) == find(y)) return true;
		else return false;
	}
	static void union(int x, int y) {//isConn과 비슷하다
		int px = find(x);
		int py = find(y);
		if(px == py) return;
		if(r[px] >= r[py]) {
			p[py] = px;//짱의 주소를 
			r[px] += r[py];
		}else {
			p[py] = px;
			r[px] = r[px];
		}
	}

}
