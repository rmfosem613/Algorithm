import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        
        int x = 5, y = 5;
        
        for (int i = 0; i < dirs.length(); i++) {
            int prevX = x, prevY = y;

            switch(dirs.charAt(i)) {
                case 'U':
                    if (x > 0) x--;
                    break;
                case 'D':
                    if (x < 10) x++;
                    break;
                case 'R':
                    if (y < 10) y++;
                    break;
                case 'L':
                    if (y > 0) y--;
                    break;
            }
            
            if (prevX != x || prevY != y) {
                String path1 = prevX + "," + prevY + "/" + x + "," + y;
                String path2 = x + "," + y + "/" + prevX + "," + prevY;
                set.add(path1);
                set.add(path2);
            }
        }
        
        return set.size() / 2; 
    }
}