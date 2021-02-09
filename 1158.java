package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//요세푸스 문제
public class B1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] a = new int[N];

		Queue<Integer> q = new LinkedList<>();// 넣어논 큐
		// Queue<int[]> q2 = new LinkedList<>();// 버려진 큐

		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		sb.append("<");

		while (q.size() != 1) {
			for (int i = 0; i < K - 1; i++) {//3에서 -1한 2랑 0의 자리인 1부터 삭제
				q.offer(q.poll());// 앞에서 두번째 값까지 뒤로 보내줌
			}
			sb.append(q.poll() + ", ");
		}
		sb.append(q.poll() + ">");
		System.out.println(sb);
	}
}
