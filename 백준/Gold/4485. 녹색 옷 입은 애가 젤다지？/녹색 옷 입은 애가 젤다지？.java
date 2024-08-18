import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = Integer.MAX_VALUE; // 무한대
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int result = 1;
        StringTokenizer st;

        while (true) {
            int V = Integer.parseInt(in.readLine());
            if (V == 0)
                break;

            int[][] adjMatrix = new int[V][V];

            for (int i = 0; i < V; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < V; j++) {
                    adjMatrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 다익스트라 알고리즘에 필요한 것들
            int[][] distance = new int[V][V];
            boolean[][] visited = new boolean[V][V];
            for (int i = 0; i < V; i++) {
                Arrays.fill(distance[i], INF);
            }

            // 출발 지점 설정
            distance[0][0] = adjMatrix[0][0];

            while (true) {
                int min = INF;
                int currentX = -1, currentY = -1;

                // 방문하지 않은 노드 중에서 최소 거리를 가진 노드를 선택
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        if (!visited[i][j] && distance[i][j] < min) {
                            min = distance[i][j];
                            currentX = i;
                            currentY = j;
                        }
                    }
                }

                // 모든 노드를 방문했다면 종료
                if (currentX == V-1 && currentY == V-1) break;

                // 현재 노드를 방문 처리
                visited[currentX][currentY] = true;

                // 현재 노드에서 인접한 노드의 최소 비용 갱신
                for (int d = 0; d < 4; d++) {
                    int nextX = currentX + dx[d];
                    int nextY = currentY + dy[d];

                    if (nextX >= 0 && nextX < V && nextY >= 0 && nextY < V) {
                        if (!visited[nextX][nextY] 
                                && distance[nextX][nextY] > distance[currentX][currentY] + adjMatrix[nextX][nextY]) {
                            distance[nextX][nextY] = distance[currentX][currentY] + adjMatrix[nextX][nextY];
                        }
                    }
                }
            }

            // 결과 출력
            System.out.print("Problem " + result + ": ");
            System.out.println(distance[V - 1][V - 1]);
            result++;
        }
    }
}
