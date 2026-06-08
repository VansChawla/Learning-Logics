import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingChar {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                if (ch == x) {
                    output.add(i);
                    break;
                }
            }
        }

        return output;
    }
}
