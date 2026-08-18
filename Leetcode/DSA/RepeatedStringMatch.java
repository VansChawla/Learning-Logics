class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int reps = 0;

        while (sb.length() < b.length()) {
            sb.append(a);
            reps++;
        }

        if (sb.toString().contains(b)) {
            return reps;
        }

        sb.append(a);
        reps++;
        if (sb.toString().contains(b)) {
            return reps;
        }

        return -1;
    }
}