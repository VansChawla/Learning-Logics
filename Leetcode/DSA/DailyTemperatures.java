import java.util.Stack;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && temps[i] > temps[s.peek()]) {
                int prevIndex = s.pop();
                ans[prevIndex] = i - prevIndex;
            }
            s.push(i);
        }

        return ans;
    }
}
