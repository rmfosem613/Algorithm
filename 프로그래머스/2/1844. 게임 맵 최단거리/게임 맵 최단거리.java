import java.util.*;

class Solution {
    // 방향 벡터 (상, 우, 하, 좌)
    private static final int[] dx = { -1, 0, 1, 0 };
    private static final int[] dy = { 0, 1, 0, -1 };

    public int solution(int[][] maps) {
        int N = maps.length;     // 행의 길이
        int M = maps[0].length;  // 열의 길이

        int[][] visited = new int[N][M];
        for (int[] v : visited) {
            Arrays.fill(v, 0);
        }

        return bfs(0, 0, maps, visited, N, M);
    }

    private int bfs(int x, int y, int[][] maps, int[][] visited, int N, int M) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { x, y });
        visited[x][y] = 1;  // 시작 위치 방문 처리 및 거리 1로 초기화

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int curX = temp[0];
            int curY = temp[1];

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 맵 경계를 벗어나지 않도록 체크
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    // 다음 위치가 길이고 방문하지 않은 곳인 경우
                    if (maps[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
                        visited[nextX][nextY] = visited[curX][curY] + 1;  // 거리 업데이트
                        queue.add(new int[] { nextX, nextY });
                    }
                }
            }
        }
        
        // 목표 지점 (N-1, M-1) 에 도달할 수 있는지 확인
        if (visited[N-1][M-1] != 0) {
            return visited[N-1][M-1];  // 최단 거리 반환
        } else {
            return -1;  // 도달할 수 없는 경우
        }
    }
}
