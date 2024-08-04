import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int p1[] = {1,2,3,4,5};
        int p2[] = {2,1,2,3,2,4,2,5};
        int p3[] = {3,3,1,1,2,2,4,4,5,5};
        
        int score[] = new int[3];
        
        // System.out.println(p1);
        
        // Set<Integer> cnt = new HashSet<>();
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == p1[i%5]) score[0] += 1;
            if(answers[i] == p2[i%8]) score[1] += 1;
            if(answers[i] == p3[i%10]) score[2] += 1;
        }
        
        int[] answer = new int[3];
        int max = score[0];
        int idx = 0;
        
        for(int i = 0; i < 3; i++){
            if(score[i] == max) {
                answer[idx] = i+1;
                idx += 1;
            } else if (score[i] > max) {
                idx = 0;
                max = score[i];
                answer[idx] = i+1;
                idx +=1;
            }
        }
        
        return Arrays.copyOfRange(answer,0,idx);
    }
}