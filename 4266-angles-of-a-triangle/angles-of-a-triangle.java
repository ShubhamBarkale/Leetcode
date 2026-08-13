import java.util.*;

class Solution {
    public double[] internalAngles(int[] sides) {

        Arrays.sort(sides);

     if (sides[0] + sides[1] <= sides[2]) {
            return new double[0];
        }

        double a = sides[0];
        double b = sides[1];
        double c = sides[2];

        double angleA = Math.toDegrees(
            Math.acos((b * b + c * c - a * a) / (2 * b * c))
        );

        double angleB = Math.toDegrees(
            Math.acos((a * a + c * c - b * b) / (2 * a * c))
        );

        double angleC = Math.toDegrees(
            Math.acos((a * a + b * b - c * c) / (2 * a * b))
        );

        return new double[]{angleA, angleB, angleC};
    }
}