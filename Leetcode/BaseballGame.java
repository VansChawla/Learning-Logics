public class BaseballGame {
    public int calPoints(String[] operations) {
        ArrayList<Integer> record = new ArrayList<>();
        
        for (String ch : operations) {
            if (ch.equals("+")) {
                int size = record.size();

                int sum = record.get(size - 1) + record.get(size - 2);
                record.add(sum);
            } else if (ch.equals("D")) {
                int size = record.size();

                int doub = record.get(size - 1) * 2;
                record.add(doub);
            } else if (ch.equals("C")) {
                int size = record.size();

                record.remove(size - 1);
            } else { // Numeric Input

                record.add(Integer.parseInt(ch));
            }
        }

        int sum = 0;
        for (int score : record) {
            sum += score;
        }

        return sum;
    }
}
