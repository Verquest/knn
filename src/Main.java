import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Vector vec1b = new Vector(1.0f, 2.0f);
        Vector vec2b = new Vector(2.0f, 2.0f);
        Vector vec3b = new Vector(2.0f, 3.0f);
        Vector vec4b = new Vector(3.0f, 3.0f);
        Vector vec1a = new Vector(-1.0f, -2.0f);
        Vector vec2a = new Vector(-2.0f, -2.0f);
        Vector vec3a = new Vector(-2.0f, -3.0f);
        Vector vec4a = new Vector(-3.0f, -3.0f);
        HashMap<String, ArrayList<Vector>> classes = new HashMap<>();
        ArrayList<Vector> classA = new ArrayList<>(Arrays.asList(vec1a, vec2a, vec3a, vec4a));
        ArrayList<Vector> classB = new ArrayList<>(Arrays.asList(vec1b, vec2b, vec3b, vec4b));
        classes.put("A", classA);
        classes.put("B", classB);
        Classifier classifier = new Classifier(classes, new Vector(1.0f, 4.0f));
        classifier.classify();
    }
}
