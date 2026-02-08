class Solution {

    /*
     * Problem: Asteroid Collision
     *
     * Each asteroid is represented by an integer:
     *  - Absolute value = size
     *  - Sign = direction (positive → right, negative → left)
     *
     * Approach:
     * We process asteroids from left to right using a stack.
     * A collision can occur only when:
     *   - The asteroid on the stack is moving right (+)
     *   - The current asteroid is moving left (-)
     *
     * We resolve collisions based on size and keep only surviving asteroids.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public int[] asteroidCollision(int[] asteroids) {

        // Stack to store asteroids that are still alive
        Stack<Integer> stack = new Stack<>();

        // Traverse each asteroid from left to right
        for (int asteroid : asteroids) {

            // Assume current asteroid survives
            boolean alive = true;

            /*
             * Collision condition:
             * - stack is not empty
             * - top of stack is moving right
             * - current asteroid is moving left
             */
            while (alive && !stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {

                // If stack asteroid is smaller, it explodes
                if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    stack.pop();
                }
                // If both asteroids are equal in size, both explode
                else if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    stack.pop();
                    alive = false;
                }
                // If stack asteroid is larger, current asteroid explodes
                else {
                    alive = false;
                }
            }

            // Push current asteroid if it survived all collisions
            if (alive) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array while preserving order
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
