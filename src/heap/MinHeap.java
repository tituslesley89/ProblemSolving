package heap;

public class MinHeap {

    int[] heap;
    int size;

    public MinHeap(int size) {
        heap = new int[size];
        this.size = 0;
    }

    private int getLeftChild(int index) {
        return heap[leftChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return (index*2)+1;
    }

    private boolean hasleftChild(int index) {
        return leftChildIndex(index) < size-1;
    }

    private int getRightChild(int index) {
        return heap[rightChildIndex(index)];
    }

    private int rightChildIndex(int index) {
        return (index*2)+2;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size-1;
    }

    private boolean hasChildren(int index) {
        return hasleftChild(index) || hasRightChild(index);
    }

    private int getParent(int index) {
        return heap[getParentIndex(index)];
    }

    private int getParentIndex(int index) {
        return (index-1)/2;
    }

    private int getSmallestChildIndex(int index) {
        int leftChild = Integer.MAX_VALUE,
                rightChild = Integer.MAX_VALUE;

        if (hasleftChild(index)) {
            leftChild = getLeftChild(index);
        }
        if (hasRightChild(index)) {
            rightChild = getRightChild(index);
        }

        return leftChild > rightChild ? getRightChild(index) : getLeftChild(index);
    }

    private int getSmallestChild(int index) {
        return heap[getSmallestChildIndex(index)];
    }

    private void swap(int idxA, int idxB) {
        int temp = heap[idxA];
        heap[idxA] = heap[idxB];
        heap[idxB] = temp;
    }

    public int peek() {
        if(size == 0)
            throw new IllegalStateException("Empty heap");
        return heap[0];
    }

    public void add(int val) {
        heap[size] = val;
        size++;
        heapifyUp();
    }

    public void remove() {
        if(size < 2) {
            size--;
            return;
        }

        heap[0] = heap[size-1];
        size--;
        heapifyDown();
    }

    private void heapifyDown() {
        int index = 0;

        while(index < size-1&&
                hasChildren(index)&&
                getSmallestChild(index) < heap[index]
                ) {
            int smallestChildIndex = getSmallestChildIndex(index);
            swap(smallestChildIndex, index);
            index = smallestChildIndex;
        }
    }

    private void heapifyUp() {
        int index =size -1;

        while(index != 0 &&
                heap[index] < getParent(index)
                ) {
            int parentIndex = getParentIndex(index);
            swap(parentIndex, index);
            index = parentIndex;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("{");
        for(int i=0;i<size;i++){
            sb.append(heap[i]+",");
        }
        sb.append("}");
        return sb.toString();
    }
}

