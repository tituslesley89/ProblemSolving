package util.graphconfig;

import java.util.List;
import java.util.Map;

public class DirectedAcyclicGraph1 extends BaseGraphConfig implements GraphConfig {

    @Override
    public List<String> getNodeNames() {
        return nodeNames;
    }

    @Override
    public Map<String, List<String>> getConnections() {
        return getBasicDAG();
    }
}
