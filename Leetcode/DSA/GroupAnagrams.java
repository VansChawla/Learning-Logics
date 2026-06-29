import java.util.*;

class GroupAnagrams {
    //Optimized Approach: Using HashMap and Sorting
    public List<List<String>> groupAnagramsOtm(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedKey = String.valueOf(chars);
            
            if (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }
            
            map.get(sortedKey).add(s);
        }
        
        return new ArrayList<>(map.values());
    }

    //Brute Force Approach: Using isAnagram function
    public List<List<String>> groupAnagramsBF(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        for(int i=0; i<strs.length; i++){
            if(visited[i]) continue; 
            List<String> currentGroup = new ArrayList<>();
            
            for(int j=i; j<strs.length; j++){
                if(!visited[j] && isAnagram(strs[i], strs[j])) {
                    currentGroup.add(strs[j]);
                    visited[j] = true;
                }
            }
            result.add(currentGroup);
        }

        return result;
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                } else{
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }
}