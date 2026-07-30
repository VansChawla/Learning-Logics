class SubsetSums {
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(arr, 0, list, 0);
        return list;
    }
    
    private void helper(int[] arr, int i, ArrayList<Integer> list, int sum){
        if(i == arr.length){
            list.add(sum);
            return;
        }
        
        helper(arr, i+1, list, sum+arr[i]);
        helper(arr, i+1, list, sum);
    }
}