import java.util.*;

class Solution {
    public int racecar(int target) {

        Queue<int[]> queue = new LinkedList<>();

        // position, speed
        queue.offer(new int[]{0, 1});

        Set<String> visited = new HashSet<>();
        visited.add("0,1");

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int position = current[0];
                int speed = current[1];

                if (position == target) {
                    return steps;
                }


                int newPosition = position + speed;
                int newSpeed = speed * 2;

                String state1 = newPosition + "," + newSpeed;

                if (Math.abs(newPosition) <= 2 * target &&
                    !visited.contains(state1)) {

                    visited.add(state1);
                    queue.offer(new int[]{newPosition, newSpeed});
                }


                int reverseSpeed;

                if (speed > 0) {
                    reverseSpeed = -1;
                } else {
                    reverseSpeed = 1;
                }

                String state2 = position + "," + reverseSpeed;

                if (!visited.contains(state2)) {

                    visited.add(state2);
                    queue.offer(new int[]{position, reverseSpeed});
                }
            }

            steps++;
        }

        return -1;
    }
}