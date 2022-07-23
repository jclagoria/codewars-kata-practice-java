package ar.com.problems.katas;

public class Projectile {

    private final double  ROUND_FACTOR = 1000.0;

    private double startingHeight;
    private double startingVelocity;
    private double startingAngle;

    private double velocityY;
    private double velocityX;

    public Projectile(double startingHeight,
                      double startingVelocity,
                      double startingAngle) {
        this.startingHeight = startingHeight;
        this.startingVelocity = startingVelocity;
        this.startingAngle = startingAngle;

        this.velocityY = startingVelocity * Math.sin(Math.toRadians(startingAngle));
        this.velocityX = startingVelocity * Math.cos(Math.toRadians(startingAngle));
    }

    public String heightEq() {

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("h(t) = -16.0t^2 + ")
                .append(roundValue(velocityY)).append("t ")
                .append(" + ").append(startingHeight);

        return strBuilder.toString();
    }

    public String horizEq() {

        StringBuilder result = new StringBuilder();

        result.append("x(t) = ")
                .append(roundValue(velocityX))
                .append("t");
        return result.toString();
    }

    public double height(double t) {
        return roundValue((-16.0 * t * t) + (velocityY  * t) + startingHeight ) ;
    }

    public double horiz(double t) {

        return roundValue(velocityX * t);
    }

    public double[] landing() {

        double time = (-velocityY - Math.sqrt((velocityX * velocityY) + (64.0 * startingHeight))) / -32.0;
        double distance = horiz(time);

        return new double[] {roundValue(distance), 0.0, roundValue(time)};
    }

    private double roundValue(double initialValue) {
        return Math.round(initialValue * ROUND_FACTOR) / ROUND_FACTOR;
    }

}
