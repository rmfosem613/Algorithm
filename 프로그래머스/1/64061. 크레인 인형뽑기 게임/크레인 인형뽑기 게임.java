import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int move : moves) {
            int column = move - 1;
            for (int i = 0; i < board.length; i++) {
                if (board[i][column] != 0) {
                    int doll = board[i][column];
                    board[i][column] = 0;
                    
                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        answer += 2;  // 인형이 쌍으로 사라지므로 2개 추가
                    } else {
                        stack.push(doll);
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
}
