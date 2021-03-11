package leetcode;

import java.util.*;

/**
 * Group Anagrams
 * Medium
 *
 * 3256
 *
 * 169
 *
 * Add to List
 *
 * Share
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i =0; i < strs.length; i++){
            String value = strs[i];
            char tempArray[] = strs[i].toCharArray();
            Arrays.sort(tempArray);
            String key = new String(tempArray);
            if(map.containsKey(key)){
                map.get(key).add(value);
            } else {
                List<String> values = new ArrayList();
                values.add(value);
                map.put(key, values);
            }
        }

        return new ArrayList<>(map.values());
    }
}
