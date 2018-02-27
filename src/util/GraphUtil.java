package util;

import graph.GraphNode;
import util.graphconfig.DirectedAcyclicGraph1;
import util.graphconfig.DirectedCyclicGrap1;
import util.graphconfig.GraphConfig;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * DAG - Directed Acyclic Graph
 * DCG - Directed Cyclic Graph
 */
public class GraphUtil {

    private static List<String> listOfDefaultNodes= Arrays.asList("A","B","C","D","E","F");


    /**
     *
     * Returns a directed acyclic graph the head to an example graph, that looks like:
     * D -> A -> B -> C
     * |->E |->F
     * @return the sample graph
     */
    public static GraphNode getExampleDAG(String startNode) {
        return constructGraph(new DirectedAcyclicGraph1(), startNode);
    }

    public static GraphNode getExampleDCG(String startNode) {
        return constructGraph(new DirectedCyclicGrap1(), startNode);
    }

    private static GraphNode constructGraph(GraphConfig config,String startNode) {
        return constructGraph(config.getNodeNames(), config.getConnections(), startNode);
    }

    private static GraphNode constructGraph(List<String> nodeNames, Map<String,List<String>> relations, String startNode) {
        Map<String,GraphNode> nameToNode = new HashMap<>();

        nodeNames.forEach(name -> {
            nameToNode.put(name,new GraphNode(name));
        });

        relations.forEach((node,adj) -> {
            List<GraphNode> adjGraphNodes = adj.stream()
                                               .map(adjNames -> nameToNode.get(adjNames))
                                               .collect(Collectors.toList());
            nameToNode.get(node).setAdj(adjGraphNodes);
        });

        return nameToNode.get(startNode);
    }
}

