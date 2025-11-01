import java.util.HashSet;

public class RemoveAllDuplicatesFromAstring {
    String removeDuplicates(String s) {
       HashSet<Character>set = new HashSet<>();
       StringBuilder result = new StringBuilder();
       
       for(int i = 0;i<s.length();i++){
           char ch = s.charAt(i);
           if(!set.contains(ch)){
               set.add(ch);
               result.append(ch);
           }
       }
       
       return result.toString();
    }
}
