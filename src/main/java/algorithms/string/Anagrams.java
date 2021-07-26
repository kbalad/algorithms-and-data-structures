package algorithms.string;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {

    public static void main(String[] args) {
        System.out.println(makeAnagram("abc", "bca"));
    }

    public static int makeAnagram(String a, String b) {
        HashMap<String, Integer> cnt = new HashMap<>();
        for (char c: a.toCharArray()) {
            String k = String.valueOf(c);
            int v = cnt.computeIfAbsent(k, i -> 0);
            v++;
            cnt.put(k, v);
        }

        for (char c: b.toCharArray()) {
            String k = String.valueOf(c);
            int v = cnt.computeIfAbsent(k, i -> 0);
            v--;
            cnt.put(k, v);
        }

        int out = 0;
        for (Map.Entry<String, Integer> kv: cnt.entrySet()) {
            out += Math.abs(kv.getValue());
        }
        return out;
    }

}
