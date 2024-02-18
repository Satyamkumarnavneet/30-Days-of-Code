class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr2) {
            set.add(num);
        }
        int count = 0;
        for (int num : arr1) {
            boolean isValid = true;
            for (int j = num - d; j <= num + d; j++) {
                if (set.contains(j)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                count++;
            }
        }
        return count;
    }
}