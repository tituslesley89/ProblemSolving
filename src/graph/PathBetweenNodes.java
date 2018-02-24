package graph;

import util.ConsoleUtil;
import util.GraphUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class PathBetweenNodes {

    private static boolean pathBetweenNodes(GraphNode head, GraphNode dst) {
        if(head.equals(dst))
            return true;

        Queue<GraphNode> q = new LinkedList<>();
        q.add(head);

        while (!q.isEmpty()) {
            GraphNode cur = q.remove();
            if(cur.equals(dst))
                return true;
            q.addAll(cur.getAdj());
        }
        return false;
    }

    public static void main(String[] args) {
        List<GraphNode> src = Arrays.asList(new GraphNode("A"),
                new GraphNode("C"),
                new GraphNode("D"));
        List<GraphNode> dst = Arrays.asList(new GraphNode("C"),
                new GraphNode("F"),
                new GraphNode("C"));

        IntStream.range(0,3).forEach(i -> {
            ConsoleUtil.println("Finding path from "+src.get(i).value + " to "+ dst.get(i).value);
            ConsoleUtil.println("Path found:"+pathBetweenNodes(GraphUtil.getExampleGraph(src.get(i).value),dst.get(i)));
        });
    }
}

