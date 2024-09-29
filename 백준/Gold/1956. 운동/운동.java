import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int V, E;
    static int dist[][];
    static int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        V = Integer.parseInt(split[0]);
        E = Integer.parseInt(split[1]);

        dist = new int[V + 1][V + 1];

        // 거리 초기화
        for (int i = 1; i <= V; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;  // 자기 자신으로 가는 거리는 0
        }

        // 간선 입력
        for (int i = 0; i < E; i++) {
            split = br.readLine().split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            int distance = Integer.parseInt(split[2]);

            dist[from][to] = distance;
        }

        // 플로이드-워셜 알고리즘 적용
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (i == j) continue;  // 자기 자신으로의 경로는 계산하지 않음
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int result = INF;

        // 최소 사이클 계산
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) continue;

                // i -> j로 가는 경로와 j -> i로 가는 경로가 모두 존재하면 사이클 형성
                if (dist[i][j] != INF && dist[j][i] != INF) {
                    result = Math.min(result, dist[i][j] + dist[j][i]);
                }
            }
        }

        // 결과 출력
        if (result == INF) {
            result = -1;  // 사이클이 없는 경우
        }

        System.out.println(result);
    }
}
