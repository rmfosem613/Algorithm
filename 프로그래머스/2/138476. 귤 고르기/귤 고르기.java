import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    static class Oranges implements Comparable<Oranges> {
        int size;
        int cnt;

        public Oranges(int size, int cnt) {
            super();
            this.size = size;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Oranges o) {
            return o.cnt - this.cnt;
        }
    }
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        // HashMap을 사용하여 사이즈별 카운트를 기록
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }

        // map을 기반으로 Oranges 리스트 생성
        List<Oranges> list = new ArrayList<>();
        
        for (Integer key : map.keySet()) {
            list.add(new Oranges(key, map.get(key)));
        }
        
        Collections.sort(list);

        int temp = 0;
        
        // 리스트 내용 출력
        for (int i = 0; i < list.size(); i++) {
        	if(temp + list.get(i).cnt <= k) {
        		temp += list.get(i).cnt;
        		answer++;
        	} else {
                break;
            }
        }
        if(temp < k) {
        	answer++;
        }
        
        return answer;
    }
}