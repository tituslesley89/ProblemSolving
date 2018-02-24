package mains;

import heap.MinHeap;
import util.ConsoleUtil;

import java.util.Arrays;
import java.util.List;

public class MinHeapMain {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5,4,2,5,6,2,1,32,5);
        MinHeap heap = new MinHeap(arr.size());
        ConsoleUtil.newline();
        ConsoleUtil.print("Array to insert into heap:");
        ConsoleUtil.printArray(arr);
        ConsoleUtil.newline();
        ConsoleUtil.println("Heap generated:");
        arr.forEach(ele -> {
            heap.add(ele);
        });
        ConsoleUtil.print(heap.toString());
        ConsoleUtil.println("Peek:"+heap.peek());

        ConsoleUtil.println("Removing element..");
        heap.remove();

        ConsoleUtil.println("Heap after removing element:");
        ConsoleUtil.print(heap.toString());
    }
}
