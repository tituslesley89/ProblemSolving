package graph.helpers;

public class WeightedEdge {

    private int weight,
    source,
    destination;

    public WeightedEdge() {
    }

    public WeightedEdge(int weight, int source, int destination) {
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }
}
