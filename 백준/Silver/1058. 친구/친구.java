import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] map;
//	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < N; j++) {

				// i == j 이면 자기 자신이므로 0
				if (i == j) {
					map[i][j] = 0;
				}

				if (split[j].equals("Y")) {
					map[i][j] = 1;
				} else {
					map[i][j] = 99;
				}
			}
		}

		// 플로이드-워셜 알고리즘: 모든 쌍에 대한 최소 거리 계산
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i == j) continue;
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

		int result = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i != j && map[i][j] <= 2) {
                	cnt++;
                }
            }
            result = Math.max(result, cnt);  // 최대 2-친구 수 계산
        }

		System.out.println(result);
	}
}
