package tree;

public class Response {
    public boolean found;
    public BinaryNode node;

    public Response(boolean found, BinaryNode node) {
        this.found = found;
        this.node = node;
    }
}
