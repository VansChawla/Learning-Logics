package Leetcode.DSA;

import java.util.Arrays;

public class LongestCommonPrefix {
    //Using Trie
    public static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;
        Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            freq = 0;
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
            curr.children[idx].freq++;
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        root = new Node();

        for (String str : strs) {
            if(str.isEmpty()) return ""; 
            insert(str);
        }

        root.freq = strs.length;
        
        return helper(root, "", strs.length);
    }

    public String helper(Node root, String ans, int N){
        if(root == null) return "";
        if(root.freq < N){
            return ans;
        }
        for(int i=0; i<root.children.length; i++){
            if(root.children[i] != null && root.children[i].freq == N){
                String res = helper(root.children[i], ans+(char)(i+'a'), N);
                if(!res.isEmpty() || root.children[i].eow) {
                    return res;
                }
                break;
            }
        }

        return ans;
    }

    //Another approach without Trie
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        for(int i=0; i<Math.min(first.length(), last.length()); i++){
            if(first.charAt(i) != last.charAt(i)){
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}