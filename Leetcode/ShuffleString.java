public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indices.length; i++) {
            int idx = findIndex(indices, i);
            sb.append(s.charAt(idx));
        }

        return sb.toString();
    }

    private int findIndex(int[] indices, int target) {
        for (int i = 0; i < indices.length; i++) {
            if (target == indices[i]) {
                return i;
            }
        }
        return -1;
    }
}
