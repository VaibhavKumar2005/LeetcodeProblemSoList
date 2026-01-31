/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        // List to store the final inorder traversal result
        List<Integer> result = new ArrayList<>();

        // Stack used to simulate recursive function calls
        Stack<TreeNode> stack = new Stack<>();

        // Pointer to traverse the tree starting from root
        TreeNode current = root;

        // Continue traversal while there are nodes to process
        // Either current node exists OR stack still has nodes
        while (current != null || !stack.isEmpty()) {

            // Step 1: Reach the leftmost node of the current subtree
            // Push all left children onto the stack
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Step 2: Process the node at the top of the stack
            current = stack.pop();
            result.add(current.val); // Visit the node

            // Step 3: Move to the right subtree
            current = current.right;
        }

        // Return the inorder traversal result
        return result;
    }
}
