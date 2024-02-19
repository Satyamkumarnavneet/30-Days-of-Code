class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] sums = new int[n][];
        for (int i = 0; i < n; i++) {
            sums[i] = new int[]{aliceValues[i] + bobValues[i], aliceValues[i], bobValues[i]};
        }
        Arrays.sort(sums, (a, b) -> Integer.compare(b[0], a[0]));
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a += sums[i][1];
            }
            else {
                b += sums[i][2];
            }
        }
        if (a > b) {
            return 1;
        }
        else if (a < b) {
            return -1;
        }
        return 0;
    }
}