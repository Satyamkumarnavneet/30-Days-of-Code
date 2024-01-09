class Solution {
    private int m, n;
    private int totalCells;
    private Map<Integer, Integer> indexMap;
    private Random random;

    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        this.totalCells = m * n;
        this.indexMap = new HashMap<>();
        this.random = new Random();
        reset();
    }

    public int[] flip() {
        // Generate a random number between 0 (inclusive) and totalCells (exclusive)
        int rand = random.nextInt(totalCells--);

        // Use the generated random number to get the corresponding index from the map
        int index = indexMap.getOrDefault(rand, rand);

        // Update the map to reflect the current state after flipping
        indexMap.put(rand, indexMap.getOrDefault(totalCells, totalCells));

        // Convert the index to [row, col] format
        int row = index / n;
        int col = index % n;

        // Return the result
        return new int[]{row, col};
    }

    public void reset() {
        // Reset the map and totalCells to their initial state
        indexMap.clear();
        totalCells = m * n;
    }
}