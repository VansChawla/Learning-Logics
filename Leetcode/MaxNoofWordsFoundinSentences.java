public class MaxNoofWordsFoundinSentences {
    public int mostWordsFound(String[] sentences) {
        int max = 0;

        for (String sentence : sentences) {
            int count = 0;

            String[] words = sentence.split(" ");
            for (String word : words) {
                count++;
            }

            max = Math.max(count, max);
            count = 0;
        }

        return max;
    }
}
