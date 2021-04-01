package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//배열돌리기
public class B16935_배열돌리기3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());;
    	int m = Integer.parseInt(st.nextToken());
    	int r = Integer.parseInt(st.nextToken());
    	
    	int map[][] = new int[n][m];
    	
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++)
    			map[i][j] = Integer.parseInt(st.nextToken());
    	}
    	
    	int[] value = new int[r];
    	st = new StringTokenizer(br.readLine());
    	
    	for(int i = 0; i < r; i++) {
    		value[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int tmp;
    	int[] temp1;
    	int[][] temp2;
    	
    	for(int v : value) {
    		switch(v) {
    		case 1://상하반전
    			for(int i = 0; i < n / 2; i++) {
    				temp1 = map[i];
    				map[i] = map[n - i - 1];
    				map[n - i - 1] = temp1;
    			}
    			break;
    		case 2://좌우반전
    			for(int i = 0; i < n; i++) {
    				for(int j = 0; j < m / 2; j++) {
    					tmp = map[i][j];
    					map[i][j] = map[i][m - j - 1];
    					map[i][m - j - 1] = tmp;
    				}
    			}
    			break;
    		case 3://오른쪽으로 90도 회전
    			temp2 = new int[n][m];
    			for(int i = 0; i < n; i++) {
    	    		temp2[i] = map[i];
    	    	}
    			map = new int[m][n];
    			for(int i = 0; i < n; i++) {
    				for(int j = 0; j < m; j++) {
    					map[j][n - i - 1] = temp2[i][j];
    				}
    			}
    			tmp = n;
    			n = m;
    			m = tmp;
    			break;
    		case 4://왼쪽으로 90도 회전
    			temp2 = new int[n][m];
    			for(int i = 0; i < n; i++) {
    	    		temp2[i] = map[i];
    	    	}
    			map = new int[m][n];
    			for(int i = 0; i < n; i++) {
    				for(int j = 0; j < m; j++) {
    					map[m - 1 - j][i] = temp2[i][j];
    				}
    			}
    			tmp = n;
    			n = m;
    			m = tmp;
    			break;
    		case 5:
    			temp2 = new int[n/2][m/2];
    			for(int i = 0; i < n/2; i++) {
    				for(int j = 0; j < m/2; j++) {
    					temp2[i][j] = map[i][j];				// 1 백업
    					map[i][j] = map[i + n/2][j];			// 4 -> 1
    					map[i + n/2][j] = map[i + n/2][j + m/2];// 3 -> 4
    					map[i + n/2][j + m/2] = map[i][j + m/2];// 2 -> 3
    					map[i][j + m/2] = temp2[i][j];			// 1 -> 2
    				}
    			}
    			break;
    		case 6:
    			temp2 = new int[n/2][m/2];
    			for(int i = 0; i < n/2; i++) {
    				for(int j = 0; j < m/2; j++) {
    					temp2[i][j] = map[i][j];				// 1 백업
    					map[i][j] = map[i][j + m/2];			// 2 -> 1
    					map[i][j + m/2] = map[i + n/2][j + m/2];// 3 -> 2
    					map[i + n/2][j + m/2] = map[i + n/2][j];// 4 -> 3
    					map[i + n/2][j] = temp2[i][j];			// 1 -> 4
    				}
    			}
    			break;
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int[] a : map) {
    		for(int v : a) {
    			sb.append(v).append(" ");
    		}
    		sb.append("\n");
    	}
    	System.out.println(sb.toString());
    	br.close();
    }

}
