package algorithm_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 12972kb	88ms
// 시간초과로 시뮬레이션으로 풀면 안됨. 수학적으로 그냥 계산하는 문제 
public class B10158_개미 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine()," ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(in.readLine());// t의 범위는 1 ≤ t ≤ 200,000,000이다. 
		
		p = (p+t)%(2*w); // 왕복을 제외한 나머지 시간으로 계산  (2*w시간이면 w기준 제자리임) 
		q = (q+t)%(2*h); // 왕복을 제외한 나머지 시간 (2*h시간이면 h기준 제자리임) 
		if(p>w)
			p = 2*w - p; // 왕복을 제외하고 난 위치가 w를 넘어가면 턴해서 돌아가야하므로 2w 에서 빼면 턴한 위치가 나옴.
		if(q>h) 
			q = 2*h - q;
		
		System.out.println(p+" "+q);
	}

}
