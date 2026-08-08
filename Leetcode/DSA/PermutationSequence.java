import java.util.ArrayList;
import java.util.List;

class PermutationSequence {
    //Brute Force Approach
    public String getPermutation(int n, int k) {
        String num = "";
        for (int i = 1; i <= n; i++) {
            num += i;
        }

        ArrayList<String> list = new ArrayList<>();
        boolean[] used = new boolean[num.length()];
        helper(list, new StringBuilder(), num, used);

        return list.get(k-1);
    }

    private void helper(ArrayList<String> list, StringBuilder str, String num, boolean[] used) {
        if (str.length() == num.length()) {
            list.add(str.toString());
            return;
        }
        
        for (int i = 0; i < num.length(); i++) {
            if (used[i]) continue;
            
            used[i] = true;
            str.append(num.charAt(i));
            
            helper(list, str, num, used);
            
            str.deleteCharAt(str.length() - 1);
            used[i] = false;
        }
    }

    //Optimized Approach - Striver
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        StringBuilder ans = new StringBuilder();
        k = k - 1;
        while(true) {
            ans.append(numbers.get(k / fact));
            numbers.remove(k / fact);
            if(numbers.size() == 0) {
                break;
            }
            
            k = k % fact;
            fact = fact / numbers.size();
        }

        return ans.toString();
    }
}