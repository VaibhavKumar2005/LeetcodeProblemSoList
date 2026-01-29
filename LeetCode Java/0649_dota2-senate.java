class Solution {

    public String predictPartyVictory(String senate) {

        // Queue to store indices of Radiant senators
        Queue<Integer> radiant = new LinkedList<>();

        // Queue to store indices of Dire senators
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();

        // Step 1: Populate the queues with initial positions
        // We store indices to preserve the order of turns
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        // Step 2: Simulate the voting process
        // Continue until one party has no active senators left
        while (!radiant.isEmpty() && !dire.isEmpty()) {

            // Get the next active senator from each party
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            /*
             * The senator with the smaller index gets to act first
             * and bans the opponent senator for all future rounds.
             *
             * The winning senator is re-added to the queue with
             * index increased by n, simulating the next round.
             */
            if (rIndex < dIndex) {
                // Radiant senator acts first and survives
                radiant.offer(rIndex + n);
            } else {
                // Dire senator acts first and survives
                dire.offer(dIndex + n);
            }
        }

        // Step 3: Determine the winner
        // The party with remaining senators wins
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
