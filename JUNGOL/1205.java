package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class jungol_1205_조커 {
	static int N;
	static int[] arr;
	static int jokercnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(arr[i] == 0) {
				jokercnt++;
			}
		}
		Arrays.sort(arr);
		if(jokercnt == N) {
			System.out.println(N);
			return;
		}
		
		int result = 0, gap = 0;
		for (int i = jokercnt; i < N; i++) {
			int size = 1;
			int remainjoker = jokercnt;
			for (int j = i; j < N - 1; j++) {
				gap = arr[j + 1] - arr[j];
				
				if(gap == 1) {
					size++;
					continue;
				}else if(gap > 1) {
					if((gap - 1) > remainjoker) {
						size += remainjoker;
						remainjoker = 0;
						break;
					}else {
						size += gap;
						remainjoker -= (gap-1);
					}
				}
			}
			size += remainjoker;
			result = Math.max(result, size);
		}
		System.out.println(result);
			
	}

}
