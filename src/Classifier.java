import java.util.*;

public class Classifier {
    private HashMap<String, ArrayList<Vector>> vectors;
    private Vector toClassify;

    public Classifier(HashMap<String, ArrayList<Vector>> vectors, Vector toClassify) {
        this.vectors = vectors;
        this.toClassify = toClassify;
    }

    public String classify(){
        TreeMap<Float, String> distances = new TreeMap<>();
        for(Map.Entry<String, ArrayList<Vector>> entry: vectors.entrySet()){
            for(Vector vector: entry.getValue()) {
                for (Vector vector1 : entry.getValue()) {
                    distances.put(vector.distanceFrom(vector1), entry.getKey());
                }
            }
        }
        findKNN(3, distances);
        return "";
    }
    private void findKNN(int n, TreeMap<Float, String> distances) {
        HashMap<String, Float> nearestNeighbors = new HashMap<>();
        for (Map.Entry<Float, String> entry : distances.entrySet()) {
            nearestNeighbors.put(entry.getValue(), entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
