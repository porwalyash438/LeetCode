import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        HashMap<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringBuilder curr = new StringBuilder();
            for (int j = i; j < n; j++) {
                if (curr.length() == 0 || curr.charAt(curr.length() - 1) == s.charAt(j)) {
                    curr.append(s.charAt(j));
                    String currStr = curr.toString();
                    mp.put(currStr, mp.getOrDefault(currStr, 0) + 1);
                } else {
                    break;
                }
            }
        }
        
        int result = -1;
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            String str = entry.getKey();
            int count = entry.getValue();
            if (count >= 3 && str.length() > result) {
                result = str.length();
            }
        }
        
        return result == -1 ? -1 : result;
    }
}
