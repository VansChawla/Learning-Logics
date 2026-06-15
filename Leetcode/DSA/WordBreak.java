class WordBreak {
    public static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }
    public static Node root;

    public static void insert(String word){
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key){
        Node curr = root;
        for(int i=0; i<key.length(); i++){
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow == true;
    }

    // Step 1: Initialize the cache
    private HashMap<String, Boolean> memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Node();
        memo = new HashMap<>(); // Instantiate the cache here

        for (String word : wordDict) {
            insert(word);
        }

        // return wordBreakHelper(s);
        // return wordBreakHelperMem(s);
        return wordBreakHelperTab(s, wordDict);
    }

    //TABULATION
    public boolean wordBreakHelperTab(String s, List<String> wordDict){
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i < s.length(); i++){
            if (dp[i] == true) {
                for (String word : wordDict) {
                    if (s.startsWith(word, i)) {
                        dp[i + word.length()] = true;
                    }
                }
            }
        }

        return dp[s.length()];
    }

    //MEMOIZATION
    public boolean wordBreakHelperMem(String key){
        if(key.length() == 0) return true;

        // Step 2: Check cache early
        if (memo.containsKey(key))
            return memo.get(key);

        for(int i=1; i<=key.length(); i++){
            if(search(key.substring(0, i)) &&
             wordBreakHelperMem(key.substring(i))) {
                // Step 3: Cache "True" Results
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    //RECURSION
    public boolean wordBreakHelper(String key){
        if(key.length() == 0) return true;

        for(int i=1; i<=key.length(); i++){
            if(search(key.substring(0, i)) &&
             wordBreakHelper(key.substring(i))) {
                return true;
            }
        }

        return false;
    }
}