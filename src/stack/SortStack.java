package stack;

import util.ConsoleUtil;
import util.StackUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SortStack {

    private static Stack<Integer> sortStack(Stack<Integer> s) {
        if(s.isEmpty() || s.size() == 1) {
            return s;
        }

        Stack<Integer> s1 = new Stack<>(),
                s2 = new Stack<>();

        s1.push(s.pop());

        while(!s.isEmpty()) {
            Integer v = s.pop();
            if(s1.peek() <= v) {
                s1.push(v);
            } else {
                while(!s1.isEmpty() && s1.peek()>v) {
                    s2.push(s1.pop());
                }
                s1.push(v);
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
        }

        while(!s1.isEmpty()) {
            s.push(s1.pop());
        }
        return s;
    }

    public static void main(String[] args) {
        List<Stack> inputs = new ArrayList<>();

        inputs.add(StackUtil.getRandomStack());
        inputs.add(StackUtil.getRandomStack());
        inputs.add(StackUtil.getRandomStack());

        inputs.stream().forEach(s -> {
            ConsoleUtil.println("Input Stack:");
            StackUtil.printStack(s);
            ConsoleUtil.println("Sorted Stack:");
            StackUtil.printStack(sortStack(s));
            ConsoleUtil.newline();
        });
    }
}
