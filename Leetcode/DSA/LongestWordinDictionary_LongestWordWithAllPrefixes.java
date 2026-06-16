class LongestWordinDictionary_LongestWordWithAllPrefixes {
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

    private static String ans;

    public String longestWord(String[] words) {
        root = new Node();
        ans = "";

        for (String word : words) {
            insert(word);
        }

        helper(root, new StringBuilder(""));
        return ans;
    }

    public static void helper(Node root, StringBuilder temp){
        if(root == null) return;

        for(int i=0; i<26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                helper(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
}