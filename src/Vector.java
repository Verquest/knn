import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Vector {
    private ArrayList<Double> vals;

    public Vector(double... values) {
        vals = new ArrayList<>();
        for(double d: values)
            vals.add(d);
    }
    public Vector(Collection<Double> values) {
        vals = new ArrayList<>();
        for(double d: values)
            vals.add(d);
    }
    public double distanceFrom(Vector v){
        double distance = 0;
        for(int i = 0; i < vals.size(); i++){
            distance += Math.pow(vals.get(i) - v.getVals().get(i), 2);
        }
        return Math.sqrt(distance);
    }

    public ArrayList<Double> getVals() {
        return vals;
    }

    @Override
    public String toString() {
        return vals.toString();
    }
}
