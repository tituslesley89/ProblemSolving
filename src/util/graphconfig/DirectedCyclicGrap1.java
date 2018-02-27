package util.graphconfig;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DirectedCyclicGrap1 extends BaseGraphConfig implements GraphConfig{

    @Override
    public List<String> getNodeNames() {
        return nodeNames;
    }

    @Override
    public Map<String, List<String>> getConnections() {
        Map<String,List<String>> connections = getBasicDAG();

        connections.put("F", Arrays.asList("A"));
        connections.put("B",Arrays.asList("C","D"));

        return connections;
    }
}
