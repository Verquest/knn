public class ClassWrapper{
    private String className;
    private double distance;

    public ClassWrapper(String className, double distance) {
        this.className = className;
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public String getName() {
        return className;
    }
}
