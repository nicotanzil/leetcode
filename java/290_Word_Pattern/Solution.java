import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        int n = pattern.length();

        List<String> ar = Arrays.stream(s.split(" ")).collect(Collectors.toList());

        if (n != ar.size())
            return false;

        boolean out = true;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(ar.get(i)))
                    out = false;
            } else {
                if (map.containsValue(ar.get(i)) && getKeyByValue(map, ar.get(i)) != pattern.charAt(i)) {
                    return false;
                } else {
                    map.put(pattern.charAt(i), ar.get(i));
                }
            }
        }
        return out;
    }

    private Character getKeyByValue(Map<Character, String> map, String value) {
        for (Map.Entry<Character, String> e : map.entrySet()) {
            if (e.getValue().equals(value))
                return e.getKey();
        }
        return null;
    }

}
