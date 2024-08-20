import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();

		for(int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            queue.offer(day);
        }
		
		// int result = 0;
		List<Integer> list = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			int ans = queue.poll();
			int cnt = 1;
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				if(queue.peek() <= ans) {
					queue.poll();
					cnt++;
				} else continue;
			}
            list.add(cnt);    
		}
		int[] answer = new int[list.size()];
		
		for(int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
}

// import java.util.*;

// class Solution {
//     public int[] solution(int[] progresses, int[] speeds) {
//         Queue<Integer> queue = new ArrayDeque<>();
        
//         // Calculate days required to complete each task and add to queue
//         for(int i = 0; i < progresses.length; i++) {
//             int day = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
//             queue.offer(day);
//         }
        
//         List<Integer> resultList = new ArrayList<>();
        
//         while(!queue.isEmpty()) {
//             int current = queue.poll();
//             int count = 1;
            
//             // Count how many features can be deployed together
//             while(!queue.isEmpty() && queue.peek() <= current) {
//                 queue.poll();
//                 count++;
//             }
            
//             resultList.add(count);
//         }
        
//         // Convert result list to array
//         int[] answer = new int[resultList.size()];
//         for(int i = 0; i < resultList.size(); i++) {
//             answer[i] = resultList.get(i);
//         }
        
//         return answer;
//     }
// }
