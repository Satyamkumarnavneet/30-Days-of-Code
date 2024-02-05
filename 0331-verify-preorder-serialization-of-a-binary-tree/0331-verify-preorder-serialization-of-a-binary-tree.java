class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int nullCount = 0; // Counter for null nodes

        for (String node : nodes) {
            if (nullCount > 0) {
                return false; // If nullCount is already greater than 0, the serialization is invalid
            }

            if (node.equals("#")) {
                nullCount++; // Increment nullCount for null nodes
            } else {
                nullCount--; // Decrement nullCount for non-null nodes
            }
        }

        return nullCount == 1; // The valid serialization should end with nullCount equal to 1
    }
}