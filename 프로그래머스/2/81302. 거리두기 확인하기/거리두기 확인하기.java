import java.util.*;
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static char[][] map;
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        // Process each place
        for (int i = 0; i < places.length; i++) {
            // Convert the 1D place array to a 2D map array
            map = new char[5][5];
            for (int j = 0; j < 5; j++) {
                map[j] = places[i][j].toCharArray();
            }

            // Check social distancing for the place
            answer[i] = isPlaceValid() ? 1 : 0;
        }
        return answer;
    }
    private static boolean isPlaceValid() {
        // Check each position in the map
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 'P') {
                    if (!bfs(i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || (nx == x && ny == y)) {
                    continue;
                }

                int distance = Math.abs(nx - x) + Math.abs(ny - y);

                if (map[nx][ny] == 'P' && distance <= 2) {
                    return false;
                } else if (map[nx][ny] == 'O' && distance < 2) {
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return true;
    }
}