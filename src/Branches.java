import java.util.*;

/**
 * 자식 노드가 2개 이상인 가지 노드 수를 구한다.
 */
public class Branches {
    public static int count(int[] tree) {

        Map<Integer, Integer> treeMap = new HashMap<>();
        int branchCount = 0;

        for (int i = 0; i < tree.length; i++) {
            int node = tree[i];

            if(treeMap.get(node) != null) {
                branchCount++;
                continue;
            }

            treeMap.put(node, 1);
        }

        return branchCount;
    }

    public static void main(String[] args) {
        System.out.println(Branches.count(new int[] { 1, 3, 1, -1, 3 }));
    }
}