import java.util.*;

public class Main {
    public static void main(String[] args) {
        int successfulPredictions = 0;
        int sampleSize = 5;
        Loader loader = new Loader();
        HashMap<String, ArrayList<Vector>> classesFromFile = loader.load("src/train.txt");
        HashMap<String, ArrayList<Vector>> testingClasses = loader.load("src/test.txt");
        HashMap<String, ArrayList<Vector>> samples = getSampleFromMap(sampleSize, testingClasses);

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

        loadDataFromInput(classifier, classesFromFile.get(classesFromFile.keySet().toArray()[0]).get(0).getLength());

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
    public static void loadDataFromInput(Classifier classifier, int vecCount){
        ArrayList<Double> points = new ArrayList<Double>();
        Scanner s = new Scanner(System.in);
        while(true){
            for(int i = 0; i < vecCount; i++){
                System.out.println("input the " + i + " point: ");
                points.add(s.nextDouble());
            }
            String classifiedAs = classifier.classify(new Vector(points));
            System.out.print("Predicting for: ");
            points.forEach(el -> System.out.print(el + " "));
            System.out.println("\nClassified as: " + classifiedAs);
        }
    }
}
