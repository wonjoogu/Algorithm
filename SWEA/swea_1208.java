package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class swea_1208_Flatten {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//s = new Scanner(src);//미리 입력값 작성했을 때
		
		int t = 10;//테스트 케이스
		int diff = 0;
		
		//10번 입력
		for (int tc = 1; tc <= t; tc++) {//t++
			int cnt = sc.nextInt();//횟수
			int[] height = new int [100];//최대 상자는 100개까지 들어온다. 높이 배열	
			
			for (int i = 0; i < height.length; i++) {
				height[i] = sc.nextInt();
			}//입력받기
			 
			//입력 확인하기
			//System.out.println(Arrays.toString(height));//확인
			
			//Arrays.sort(height);
			
			//평탄화 완료 -> 언제 될지는 모름
			while(true) {
				
				//최고점, 최저점 알아야하므로 정렬되면 좋음
				Arrays.sort(height);//오름차순 정렬 //핵심 !!!!!!!!!
				
				//평탄화 완료 or 
				if(height[99] - height[0] <= 1 || cnt == 0) {//최대차이가 0 이거나 1 / dump를 다 했거나
					diff = height[99] - height[0];
					break;
				}
				
				//계속 dump 작업해야함
				cnt--;//10, 9, .. 0 까지
				height[99]--;
				height[0]++;
			}
		
//				for (int i = 0; i < cnt; i++) {
//					height[0]++;
//					height[99]--;
//					Arrays.sort(height);
//
//				}
//				int result = height[99] - height[0];
			
				System.out.println("#" + tc + " " + diff);
			
		}
		
	}

}
