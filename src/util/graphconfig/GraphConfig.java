package util.graphconfig;

import java.util.List;
import java.util.Map;

public interface GraphConfig {

    public List<String> getNodeNames();

    public Map<String, List<String>> getConnections();
}
