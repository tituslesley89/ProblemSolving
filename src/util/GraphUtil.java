package util;

import graph.GraphNode;

import java.util.Arrays;

public class GraphUtil {

    /**
     *
     * Returns the head to an example graph, that looks like:
     * D -> A -> B -> C
     * |->E |->F
     * @return the sample graph
     */
    public static GraphNode getExampleGraph(String val) {
        GraphNode A = new GraphNode("A");
        GraphNode B = new GraphNode("B");
        GraphNode C = new GraphNode("C");
        GraphNode D = new GraphNode("D");
        GraphNode E = new GraphNode("E");
        GraphNode F = new GraphNode("F");

        D.setAdj(Arrays.asList(A,E));
        A.setAdj(Arrays.asList(B,F));
        B.setAdj(Arrays.asList(C));

        switch (val) {
            case "A" : return A;
            case "B" : return B;
            case "C" : return C;
            case "D" : return D;
            case "E" : return E;
            case "F" : return F;
            default: return A;
        }
    }

    public static GraphNode getExampleGraph() {
        return getExampleGraph("A");
    }
}

