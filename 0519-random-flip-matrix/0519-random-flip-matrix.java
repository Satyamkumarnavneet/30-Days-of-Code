class Solution {
    int currentRow = 0;
    int currentCol = 0;
    int totalRows = 0;
    int totalCols = 0;

    public Solution(int totalRows, int totalCols) {
        this.totalRows = totalRows;
        this.totalCols = totalCols;
    }

    public int[] flip() {
        if (currentRow >= totalRows || currentCol >= totalCols) {
            return null;  // All cells are flipped or matrix has been reset
        }

        int[] result = new int[]{currentRow, currentCol};
        currentCol++;

        if (currentCol == totalCols) {
            currentCol = 0;
            currentRow++;
        }

        if (currentRow == totalRows) {
            currentRow = 0;
            currentCol = 0;
        }

        return result;
    }

    public void reset() {
        
    }
}
