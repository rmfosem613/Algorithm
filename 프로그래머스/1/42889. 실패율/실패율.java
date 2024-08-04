import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        List<Integer> list = new ArrayList<>();
        double[] fail_p = new double[N + 1];
        int pass = stages.length;
        int fail = 0;
        
        for (int i = 1; i < N + 1; i++) {
            list.add(i);
            
            for (int stage : stages) {
                if (stage == i) {
                    fail += 1;
                }
            }
            fail_p[i] = fail / (double) pass;
            pass -= fail;
            fail = 0;
        }
        
        // Insertion sort
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            double keyFailRate = fail_p[key];
            int j = i - 1;
            
            // Compare fail rates and insert key in correct position
            while (j >= 0 && fail_p[list.get(j)] < keyFailRate) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
