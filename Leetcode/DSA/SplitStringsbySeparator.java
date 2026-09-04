import java.util.regex.Pattern;

class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        String regex = Pattern.quote(String.valueOf(separator));

        for(String word : words){
            String[] parts = word.split(regex);
            
            for (String part : parts) {
                if (!part.isEmpty()) {
                    ans.add(part);
                }
            }
        }

        return ans;
    }
}