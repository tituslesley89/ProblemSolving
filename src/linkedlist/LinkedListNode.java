package linkedlist;

public class LinkedListNode<T> {

    public T data;
    public LinkedListNode next;

    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedListNode<T> getAccessToNode(int n) {
        LinkedListNode<T> temp = this;
        int count = 0;
        while(temp!=null && count < n) {
            temp = temp.next;
            count++;
        }
        return temp;
    }

    public String toString() {
        LinkedListNode<T> temp = this;
        StringBuilder sb = new StringBuilder("[");

        while(temp!=null) {
            sb.append(temp.getData()+", ");
            temp = temp.next;
        }
        sb.append("\b\b}");
        return sb.toString();
    }
}

