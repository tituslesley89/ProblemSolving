package util.graphconfig;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseGraphConfig {

    protected static List<String> nodeNames = Arrays.asList("A","B","C","D","E","F");

    /**
     * D -> A -> B -> C
     * |->E |->F
     * @return
     */
    protected static Map<String, List<String>> getBasicDAG() {
        Map<String, List<String>> connectionsMap = new HashMap<>();

        connectionsMap.put("D", Arrays.asList("A","E"));
        connectionsMap.put("A", Arrays.asList("B","F"));
        connectionsMap.put("B", Arrays.asList("C"));

        return connectionsMap;
    }
}
