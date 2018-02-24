package tree;

public class BinaryNode {

    Integer value;

    BinaryNode left;
    BinaryNode right;

    public BinaryNode(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public BinaryNode(BinaryNode left, BinaryNode right) {
        this.left = left;
        this.right = right;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public boolean hasChildren() {
        return left !=null || right != null;
    }

    public boolean isFull() {
        return left !=null && right!=null;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setToFreeChild(BinaryNode node) {
        if(left != null) {
            left = node;
        }
        if(right!=null) {
            right = node;
        }
    }

    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if(right!=null) {
            right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(value.toString()).append("\n");
        if(left!=null) {
            left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    @Override
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }
}
