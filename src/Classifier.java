import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Classifier {
    private HashMap<String, ArrayList<Vector>> vectors;
    private Vector toClassify;

    public Classifier(HashMap<String, ArrayList<Vector>> vectors, Vector toClassify) {
        this.vectors = vectors;
        this.toClassify = toClassify;
    }

    public int classify(){
        HashMap<String, ArrayList<Float>> distances = new HashMap<>();
        for(Map.Entry<String, ArrayList<Vector>> entry: vectors.entrySet()){
            distances.put(entry.getKey(), new ArrayList<Float>());
            for(Vector vector: entry.getValue()) {
                for (Vector vector1 : entry.getValue()) {
                    distances.get(entry.getKey()).add(vector.distanceFrom(vector1));
                }
            }
        }
        return -1;
    }
    private String findKNN(int n, HashMap<String, ArrayList<Float>> distances){
        
    }
}
