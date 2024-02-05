class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<>();

        for (String node : nodes) {
            while (node.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop(); // Pop two consecutive '#' and their parent node
                if (stack.isEmpty()) {
                    return false; // Invalid serialization
                }
                stack.pop();
            }
            stack.push(node); // Push the current node onto the stack
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }
}