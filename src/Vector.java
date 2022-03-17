import java.util.ArrayList;
import java.util.Arrays;

public class Vector {
    private ArrayList<Double> vals;

    public Vector(double... values) {
        vals = new ArrayList(Arrays.asList(values));
    }
    public double distanceFrom(Vector v){
        double distance = 0;
        for(int i = 0; i < vals.size(); i++){
            System.out.println(vals.get(i) - v.getVals().get(i));
            distance += Math.pow(vals.get(i) - v.getVals().get(i), 2);
        }
        return Math.sqrt(distance);
    }

    public ArrayList<Double> getVals() {
        return vals;
    }
}
