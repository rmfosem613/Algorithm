import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // System.out.println(arr2.length);
        // [a0*c0 + ac*c1] + [b0*d0 + b0*d1]
        
        int[][] answer = new int[arr1.length][arr2[0].length];
        // System.out.println(answer);
        
        // cnt = 0;
        
        for(int i = 0; i < answer.length; i++) {
            for(int j = 0; j < answer[0].length; j++) {
                for(int k = 0; k < arr2.length; k++) {
                    answer[i][j] += arr1[i][k]*arr2[k][j];
                }
            }
        }
        System.out.println(answer);
        
        return answer;
    }
}