class MinAbsDiff {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int minDif = Integer.MAX_VALUE;
        TreeMap<Integer, List<List<Integer>>> map = new TreeMap<>();

        Arrays.sort(arr);

        for(int i=1; i<arr.length; i++){
            int dif = Math.abs(arr[i] - arr[i-1]);
            if(dif <= minDif){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i-1]);
                list.add(arr[i]);

                map.putIfAbsent(dif, new ArrayList<>());
                map.get(dif).add(list);

                minDif = dif;
            }
        }

        return map.get(map.firstKey());
    }
}