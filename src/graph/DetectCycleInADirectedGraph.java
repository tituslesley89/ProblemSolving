package graph;

import util.ConsoleUtil;
import util.GraphUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetectCycleInADirectedGraph {

    private static boolean findCycleHelper(Set<GraphNode> visited, GraphNode curNode) {
        List<GraphNode> adj = curNode.getAdj();

        if(adj.isEmpty())
            return false;

        boolean hasCycle = false;
        for(int i=0;i<adj.size();i++) {
            GraphNode adjNode = adj.get(i);
            if(visited.contains(adjNode))
                return true;
            else {
                Set<GraphNode> newVisited = visited;
                newVisited.add(curNode);
                hasCycle = hasCycle|| findCycleHelper(newVisited, adjNode);
            }
        }
        return hasCycle;
    }

    private static boolean findCycle(GraphNode startNode) {
        return findCycleHelper(new HashSet<>(), startNode);
    }

    public static void main(String[] args) {
        GraphNode directedAcyclicGraph = GraphUtil.getExampleDAG("A");
        GraphNode directedCyclicGraph = GraphUtil.getExampleDCG("A");

        ConsoleUtil.println("Checking DAG:");
        ConsoleUtil.println("Has cycle:"+findCycle(directedAcyclicGraph));

        ConsoleUtil.newline();
        ConsoleUtil.println("Checking DCG:");
        ConsoleUtil.println("Has cycle:"+findCycle(directedCyclicGraph));
    }
}
