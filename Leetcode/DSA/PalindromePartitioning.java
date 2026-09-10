class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<StringBuilder> currentPath = new ArrayList<>();

        getAllParts(s, 0, currentPath, ans);
        return ans;
    }

    private void getAllParts(String s, int index, List<StringBuilder> currentPath, List<List<String>> ans) {
        if (index == s.length()) {
            List<String> validPartition = new ArrayList<>();
            for (StringBuilder sb : currentPath) {
                validPartition.add(sb.toString());
            }
            ans.add(validPartition);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalin(s, index, i)) {
                StringBuilder part = new StringBuilder(s.substring(index, i + 1));
                currentPath.add(part);
                getAllParts(s, i + 1, currentPath, ans);
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }

    private boolean isPalin(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++; 
            right--;
        }
        return true;
    }
}
