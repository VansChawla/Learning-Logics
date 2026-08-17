class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String chopped = doubled.substring(1, doubled.length() - 1);
        
        return chopped.contains(s);
    }
}