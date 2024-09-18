class Solution {
    private static int[] board;
    private static int answer;

    public static int solution(int n) {
        board = new int[n];
        
        backTracking(0, n);

        return answer;
    }

    private static void backTracking(int cnt, int n) {
        if (cnt == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[cnt] = i; 
            if (valid(cnt)) {
                backTracking(cnt + 1, n);
            }
        }
    }

    private static boolean valid(int i) {
        for (int j = 0; j < i; j++) { 
            if (board[i] == board[j]) return false;
            if (Math.abs(i - j) == Math.abs(board[i] - board[j])) 
                return false;
        }
        return true;
    }
}