public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<String> set = new HashSet<>();

        int k = 10;
        for(int i=0; i<=s.length()-k; i++){
            String dna = s.substring(i, i+k);
            if(set.contains(dna)){
                result.add(dna);
            }
            set.add(dna);
        }

        return new ArrayList<>(result);
    }
}
