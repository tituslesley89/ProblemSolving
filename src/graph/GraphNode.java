package graph;

import util.ConsoleUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphNode {

    String value;
    List<GraphNode> adj;

    public GraphNode(String value) {
        this.value = value;
        adj = new ArrayList<>();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<GraphNode> getAdj() {
        return adj;
    }

    public void setAdj(List<GraphNode> adj) {
        this.adj = adj;
    }

    public void printInfo() {
        StringBuffer sb = new StringBuffer("{");
        adj.stream().forEach(node -> {
            sb.append(node.getValue()+",");
        });
        sb.append("}");
        ConsoleUtil.println("NodeValue:"+value);
        ConsoleUtil.println("AdjNodes"+sb.toString());
    }

    public void printGraph() {
        Queue<GraphNode> q = new LinkedList<>();
        q.add(this);

        while(!q.isEmpty()) {
            GraphNode cur = q.remove();
            cur.printInfo();
            q.addAll(cur.getAdj());
        }
    }

    public boolean equals(Object o) {
        if(!(o instanceof GraphNode)) {
            return false;
        }

        if(((GraphNode)o).value == this.value)
            return true;
        else
            return false;
    }
}

