package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_1863_종교 {
	static int N, M;
	static int i, j;
	static int[] parents;
	static int[] rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[50001];
		rank = new int[50001];

		for (int k = 1; k <= N; k++) {
			parents[k] = k;
			rank[k] = k;
		}

		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			parents[k] = Integer.parseInt(st.nextToken());
			i = parents[0];
			j = parents[1];

			union(i, j);
			// i = Integer.parseInt(st.nextToken());
			// j = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		for (int k = 1; k <= N; k++) {
			if (k == parents[k]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static int findSet(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}

	private static void union(int a, int b) {
		int iRoot = findSet(a);
		int jRoot = findSet(b);
		if (rank[iRoot] < rank[jRoot]) {
			parents[iRoot] = jRoot;
		} else {
			parents[jRoot] = iRoot;
			if(rank[iRoot] == rank[jRoot]) {
				rank[iRoot]++;
			}
		}

	}

}
