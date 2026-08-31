class IntersectionofTwoArrays {
    //Two pointer approach
    public int[] intersection(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ans = new ArrayList<>();

        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                if(ans.isEmpty() || ans.get(ans.size() - 1) != nums1[i])
                    ans.add(nums1[i]);
                i++; j++;
            } else if(nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }

        int arr[] = new int[ans.size()];
        for(int k=0; k<arr.length; k++){
            arr[k] = ans.get(k);
        }

        return arr;
    }

    //Set approach
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums1.length; i++){
            set.add(nums1[i]);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<nums2.length; i++){
            if(set.contains(nums2[i])){
                answer.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();

    }
}