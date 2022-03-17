import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        Vector vec1b = new Vector(1.0f, 1.0f);
//        Vector vec2b = new Vector(2.0f, 2.0f);
//        Vector vec3b = new Vector(3.0f, 3.0f);
//        Vector vec4b = new Vector(4.0f, 4.0f);
//        Vector vec1a = new Vector(-1.0f, -1.0f);
//        Vector vec2a = new Vector(-2.0f, -2.0f);
//        Vector vec3a = new Vector(-3.0f, -3.0f);
//        Vector vec4a = new Vector(-4.0f, -4.0f);
        //HashMap<String, ArrayList<Vector>> classes = new HashMap<>();
        //ArrayList<Vector> classA = new ArrayList<>(Arrays.asList(vec1a, vec2a, vec3a, vec4a));
        //ArrayList<Vector> classB = new ArrayList<>(Arrays.asList(vec1b, vec2b, vec3b, vec4b));
        //classes.put("A", classA);
        //classes.put("B", classB);
        //Classifier classifier = new Classifier(classes, new Vector(1f, 2f));
        //System.out.println(classifier.classify());
        int successfulPredictions = 0;
        int sampleSize = 5;
        Loader loader = new Loader();
        HashMap<String, ArrayList<Vector>> classesFromFile = loader.load("src/train.txt");
        System.out.println(classesFromFile);
        HashMap<String, ArrayList<Vector>> trainingClasses = loader.load("src/test.txt");
        HashMap<String, ArrayList<Vector>> samples = getSampleFromMap(sampleSize, trainingClasses);

        Classifier classifier = new Classifier(classesFromFile);
        for(Map.Entry<String, ArrayList<Vector>> entry: samples.entrySet()){
            for(Vector vector: entry.getValue()){
                String classifiedAs = classifier.classify(vector);
                if(entry.getKey().equals(classifiedAs))
                    successfulPredictions++;
            }
        }
        System.out.println("Successful: " + successfulPredictions);
        System.out.println("Success rate: " + (float)successfulPredictions/sampleSize*100 + "%");
    }
    public static HashMap<String, ArrayList<Vector>> getSampleFromMap(int sampleAmount, HashMap<String, ArrayList<Vector>> classesMap){
        HashMap<String, ArrayList<Vector>> samples = new HashMap<>();
        Random r = new Random();
        for(int i = 0; i < sampleAmount; i++){
            List<String> keyList = new ArrayList<>(classesMap.keySet());

            String randomKey = keyList.get(r.nextInt(keyList.size()));
            Vector randomVector = classesMap.get(randomKey).get(r.nextInt(classesMap.get(randomKey).size()));

            if(samples.containsKey(randomKey))
                samples.get(randomKey).add(randomVector);
            else
                samples.put(randomKey, new ArrayList<>(Arrays.asList(randomVector)));
        }
        return samples;
    }
}
