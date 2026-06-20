import java.util.HashSet;

public class CheckSentenceIsPangram {
    //HashSet Approach
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();

        for(char ch : sentence.toCharArray()){
            set.add(ch);
        }

        if(set.size() != 26)
            return false;
        
        return true;
    }
    
    //Boolean Array Approach
    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];
        String lowerCaseSentence = sentence.toLowerCase();

        for (int i = 0; i < lowerCaseSentence.length(); i++) {
            char ch = lowerCaseSentence.charAt(i);

            if (ch <= 'z' && ch >= 'a') {
                int index = ch - 'a';
                seen[index] = true;
            }
        }

        for (boolean letterPresent : seen) {
            if (!letterPresent) {
                return false;
            }
        }

        return true;
    }
}
