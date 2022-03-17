import java.util.ArrayList;
import java.util.Arrays;

public class Vector {
    private ArrayList<Float> vals;

    public Vector(float... values) {
        vals = new ArrayList(Arrays.asList(values));
    }
    public float distanceFrom(Vector v){
        float distance = 0;
        for(int i = 0; i < vals.size(); i++){
            distance += Math.pow(vals.get(i) - v.getVals().get(i), 2);
        }
        return (float)Math.sqrt(distance);
    }

    public ArrayList<Float> getVals() {
        return vals;
    }
}
