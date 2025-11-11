// Write an application that uses random number generation to create sentences. Use four arrays of strings named articles,nouns,verbs and prepositions.Create a sentence by selecting a word at random from each array in the following order:article,noun,verb,preposition,article and noun.As each word is picked,concatenate it with the previous words in the sentence.The words should be separated by spaces.When the final sentence is output,it should start with a capital letter and ends with a period.The application should generate 20 sentences.

import java.util.*;

public class SentenceGenerator {

    public static void main(String[] args) {

        // 1. Define the arrays of words [cite: 108, 114-116]
        String[] articles = { "a", "an", "the", "some", "one", "any" };
        String[] nouns = { "boy", "girl", "temple", "dog", "town", "car" };
        String[] verbs = { "drove", "jumped", "walked", "skipped", "ran" };
        String[] prepositions = { "to", "from", "over", "under", "on" };

        Random rand = new Random();

        System.out.println("--- 20 Random Sentences ---");

        // 2. Generate 20 sentences [cite: 112]
        for (int i = 0; i < 20; i++) {

            // 3. Select words at random from each array in order [cite: 109]
            String article1 = articles[rand.nextInt(articles.length)];
            String noun1 = nouns[rand.nextInt(nouns.length)];
            String verb = verbs[rand.nextInt(verbs.length)];
            String prep = prepositions[rand.nextInt(prepositions.length)];
            String article2 = articles[rand.nextInt(articles.length)];
            String noun2 = nouns[rand.nextInt(nouns.length)];

            // 4. Concatenate the words with spaces [cite: 110-111]
            String sentence = article1 + " " + noun1 + " " + verb + " " +
                    prep + " " + article2 + " " + noun2;

            // 5. Capitalize first letter and add a period [cite: 111]
            String formattedSentence = sentence.substring(0, 1).toUpperCase() + sentence.substring(1) + ".";

            // 6. Output the final sentence
            System.out.println(formattedSentence);
        }
    }
}
