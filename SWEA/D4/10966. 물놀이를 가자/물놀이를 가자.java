import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static class L{
		int r;
		int c;
		int distance;
		public L(int r, int c, int distance) {
			this.r = r;
			this.c = c;
			this.distance = distance;
		}
	}
	static int [] dr=  {-1,0,1, 0};
    static int [] dc = { 0,1,0,-1};
    static int T, N, M;
    static int sum;
    static int[][] grid;
    static int Wa,La;
	static  Queue<L>  water;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            water=new LinkedList<>();
            grid=new int[N][M];
            // dijkstra 응용
            for (int i = 0; i < N; i++) {
				Arrays.fill(grid[i], 10000000);
			}
            
            for(int i = 0; i < N; i++) {
            	String ss=br.readLine();
            	char[] cs=ss.toCharArray();
                for(int j = 0; j < M; j++) {
                	if(cs[j]=='W') {
                		water.offer(new L(i, j,0));
                		grid[i][j]=0; //시작을 0으로 
                	}
                }
            }
            sum=0;
            bfs();
            for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sum+=grid[i][j];
				}
			}            
            System.out.println("#"+t+" "+sum);
        }
    }
    static void bfs() {
        while(!water.isEmpty()) {
            L cur= water.poll();
            int r = cur.r;
            int c = cur.c;
            int dis=cur.distance;
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(!check(nr,nc)) continue;
                if(grid[nr][nc]>dis+1) {  // 같은 레벨 x, 항상 감소하는것만
                	water.offer(new L (nr,nc, dis+1));
                	grid[nr][nc]=dis+1; //시작을 0으로 
                }
            }
        }
    }
    static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r< N && c< M;
    }
}