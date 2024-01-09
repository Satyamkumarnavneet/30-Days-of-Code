class Solution {
    private int currentRow = 0;
    private int currentCol = 0;
    private int totalRows = 0;
    private int totalCols = 0;
    private boolean matrixFlipped = false;

    public Solution(int totalRows, int totalCols) {
        this.totalRows = totalRows;
        this.totalCols = totalCols;
    }

    public int[] flip() {
        if (matrixFlipped || currentRow == totalRows) {
            return null;  // All cells are flipped or matrix has been reset
        }

        int[] result = new int[]{currentRow, currentCol};
        currentCol++;

        if (currentCol == totalCols) {
            currentCol = 0;
            currentRow++;
        }

        if (currentRow == totalRows) {
            matrixFlipped = true;
        }

        return result;
    }

    public void reset() {
        
    }
}
