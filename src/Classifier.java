import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Classifier {
    private HashMap<String, ArrayList<Vector>> vectors;
    public Classifier(HashMap<String, ArrayList<Vector>> vectors) {
        this.vectors = vectors;
    }

    public String classify(Vector toClassify){
        ArrayList<ClassWrapper> distances = new ArrayList<>();
        for(Map.Entry<String, ArrayList<Vector>> entry: vectors.entrySet()){
            for(Vector vector: entry.getValue()) {
                distances.add(new ClassWrapper(entry.getKey(), toClassify.distanceFrom(vector)));
            }
        }
        String classifiedTo = findKNN(3, distances).stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .get()
            .getKey();
        return classifiedTo;
    }
    private ArrayList<String> findKNN(int n, ArrayList<ClassWrapper> distances) {
        distances.sort(Comparator.comparingDouble(ClassWrapper::getDistance));
        ArrayList<String> toReturn = new ArrayList<>();

        for(int i = 0; i < n; i++){
            toReturn.add(distances.get(i).getName());
        }
        return toReturn;
    }
}
