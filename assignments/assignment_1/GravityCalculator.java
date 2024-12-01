package assignments.assignment_1;

class GravityCalculator {
    public static void main(String[] arguments) {
        double gravity = -9.81; // Earth's gravity in m/s^2
        double initialVelocity = 0.0;
        double fallingTime = 10.0;
        double initialPosition = 0.0;

        double at2 = gravity * Math.pow(fallingTime, 2);
        double vt = initialVelocity * fallingTime;
        double xt = initialPosition * fallingTime;

        double finalPosition = 0.5 * at2 + vt + xt;
        System.out.println("The object's position after " + fallingTime +
                " seconds is " + finalPosition + " m.");
    }
}