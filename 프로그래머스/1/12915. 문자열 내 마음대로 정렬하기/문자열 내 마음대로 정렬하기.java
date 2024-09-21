import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    private static class WordList implements Comparable<WordList> {
        public String word;
        public Character alpha;

        public WordList(String word, Character alpha) {
            this.word = word;
            this.alpha = alpha;
        }

        @Override
        public int compareTo(WordList o) {
        	
        	if(this.alpha.equals(o.alpha)) {
        		return this.word.compareTo(o.word);
        	} else {
        		return this.alpha - o.alpha; 
        	}
        }
    }

    static List<WordList> list = new ArrayList<>();

    public String[] solution(String[] strings, int n) {
        for (int i = 0; i < strings.length; i++) {
            list.add(new WordList(strings[i], strings[i].charAt(n)));
        }

        Collections.sort(list);
        
        String[] answer = new String[strings.length];
        
        int cnt = 0;
        
        for (WordList wl : list) {
            answer[cnt++] = wl.word;
        }
        
        return answer;
    }
}