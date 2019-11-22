import sun.misc.Queue;

import java.util.LinkedList;
import java.util.Stack;

class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        // 노드 생성시 인접노드 초기화, 마킹 값 false로 초기화
        public Node(int data) {
            this.data = data;
            this.adjacent = new LinkedList<>();
            this.marked = false;
        }
    }


    private Node[] nodes;

    /**
     * 모든 노드 마킹 값 초기화
     */
    void clear() {
        for (Node node : nodes) {
            if(node.marked) node.marked = false;
        }
    }

    Graph(int size) {
        this.nodes = new Node[size];

        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if(!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }

        if(!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1) ;
        }
    }

    void dfs() {
        dfs(0);
    }

    private void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        root.marked = true;

        while(!stack.isEmpty()) {
            Node r = stack.pop();
            for(int i = 0; i < r.adjacent.size(); i++) {
                Node n = r.adjacent.get(i);
                if(!n.marked) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }

        System.out.println("DFS 탐색이 끝났습니다.");
    }

    void bfs() throws InterruptedException {
        bfs(0);
    }

    private void bfs(int index) throws InterruptedException {
        Node root = nodes[index];
        Queue<Node> q = new Queue<>();
        q.enqueue(root);
        root.marked = true;

        while(!q.isEmpty()) {
            Node r = q.dequeue();
            for (int i = 0; i < r.adjacent.size(); i++) {
                Node n = r.adjacent.get(i);
                if(!n.marked) {
                    n.marked = true;
                    q.enqueue(n);
                }
            }

            visit(r);
        }

        System.out.println("BFS 탐색이 끝났습니다.");
    }

    /**
     * 재귀적 DFS 탐색
     * @param r
     */
    void dfsR(Node r) {
        if(r == null) return;
        r.marked = true;
        visit(r);
        for (Node n: r.adjacent) {
            if(!n.marked) dfsR(n);
        }
    }

    void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }

    void dfsR() {
        dfsR(0);
    }

    void visit(Node n) {
        System.out.println("[" + n.data + "] 노드에 방문 했습니다.");
    }
}

public class GraphSearch {
    public static void main(String[] args) {
        Graph g = new Graph(9);
        /**
         * 노드의 연관관계를 지어주고 시작
         */
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);

        System.out.println("******************* DFS ******************");
        g.dfs();
        System.out.println("******************* BFS ******************");
        g.clear();
        try {
            g.bfs();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
