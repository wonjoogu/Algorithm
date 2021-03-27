package algorithm_practice;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
//높은 수의 방에서 낮은 수의 방으로도 갈 수 있다는 것을 생각해야함! (ex. 50 -> 10) 
public class swea_4408_자기방으로돌아가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 돌아가야할 학생들의 수, N명
			
			//복도 배열 준비(1,2->0 / 3,4->1 / 399,400 -> 1999)
			int[] map = new int[200];

			for (int i = 0; i < N; i++) {// 학생 수 만큼
				int r1 = (sc.nextInt() -1) / 2;
				int r2 = (sc.nextInt() -1) / 2;
				
				//방번호 정리 r1-> r2
				int min = Math.min(r1, r2);
				int max = Math.max(r1, r2);
				
				//방번호 -> 복도번호로 변환
				r1 = (min - 1) / 2;//1 2
				r2 = (max - 1) / 2;//1 2

				for (int j = r1; j <= r2; j++) {//작은 방번호에서부터 큰 방번호로 까지 (계속 지나가니까)
					map[j]++;
				}
			}
			Arrays.sort(map);
			System.out.println("#" + tc + " " + map[199]);
		}
	}
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Room implements Comparable<Room>{
   int min,max;
   Room(int m,int x){
      this.max=Math.max(m, x);
      this.min=Math.min(m, x);
   }
   @Override
   public int compareTo(Room o) {
      if(this.min==o.min)
      	return this.max-o.max;
      return this.min-o.min;
   }
}
public class SWEA4408 {
   static int T,N;
   static LinkedList<Room> list;
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      T=Integer.parseInt(br.readLine().trim());
      for(int t=1;t<=T;t++) {
         N=Integer.parseInt(br.readLine().trim());
         list=new LinkedList<>();
         StringTokenizer st;
         for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            list.add(new Room(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));;
         }
         Collections.sort(list);
         int hour=0;
         while(list.size()>0) {
            hour++;
            int min=list.get(0).min;
            int max=list.get(0).max;
            if((max&1)==1)max++;
            list.remove(0);
            for(int i=0;i<list.size();i++) {
               if(max<list.get(i).min) {
                  max=list.get(i).max;
                  list.remove(i);i--;
               }
            }
         }
         System.out.println("#"+t+" "+hour);
      }
   }
}
 * 	
 */
}
