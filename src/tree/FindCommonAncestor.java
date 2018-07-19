package tree;

import util.ConsoleUtil;
import util.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonAncestor {

    public static BinaryNode findLeastCommonAncestor(BinaryNode root,
                                              Integer a,
                                              Integer b) {
        Response response = findLCAHelper(root, a, b);
        return response!=null ? response.node : null;
    }

    private static Response findLCAHelper(BinaryNode cur, Integer a, Integer b) {
        if(cur == null) {
            return null;
        }

        if(cur.value.equals(a) || cur.value.equals(b)){
            return new Response(true, null);
        }

        Response lResp = findLCAHelper(cur.left, a, b),
                 rResp = findLCAHelper(cur.right, a, b);

        if(lResp.found && rResp.found) {
            return new Response(true, cur);
        } else if(lResp.found || rResp.found) {
            return new Response(true, null);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        List<BinaryNode> listOfTrees = new ArrayList<>();
        List<Integer> aList = Arrays.asList(3,5);
        List<Integer> bList = Arrays.asList(5,2);

        listOfTrees.add(TreeUtil.createBinarySearchTree(Arrays.asList(7,3,5,1,2,4,6)));
        listOfTrees.add(TreeUtil.createBinarySearchTree(Arrays.asList(4,3,6,1,2,5,7)));

        for(int i=0;i<listOfTrees.size();i++) {
            ConsoleUtil.println("Tree:");
            ConsoleUtil.println(listOfTrees.get(i).toString());
            ConsoleUtil.println("commonAncestor between A:"+aList.get(i)+" & B:"+bList.get(i) + " is: " + findLeastCommonAncestor(listOfTrees.get(i),
                    aList.get(i),
                    bList.get(i)).value);
        }
    }
}
