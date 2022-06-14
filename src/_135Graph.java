import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class _135Graph {

    private static ArrayList<String> result = new ArrayList<>();

    private static void setFalse(NodeGraph... nodeArray) {
        for (NodeGraph e : nodeArray) {
            e.setVisited(false);
        }
    }

    public static void main(String[] args) {

        NodeGraph A = new NodeGraph("A");
        NodeGraph B = new NodeGraph("B");
        NodeGraph C = new NodeGraph("C");
        NodeGraph D = new NodeGraph("D");
        NodeGraph E = new NodeGraph("E");
        NodeGraph F = new NodeGraph("F");
        NodeGraph G = new NodeGraph("G");
        NodeGraph H = new NodeGraph("H");
        NodeGraph I = new NodeGraph("I");
        NodeGraph J = new NodeGraph("J");
        NodeGraph K = new NodeGraph("K");
        NodeGraph L = new NodeGraph("L");
        NodeGraph M = new NodeGraph("M");

        A.addNeighbor(E);
        A.addNeighbor(F);
        B.addNeighbor(D);
        C.addNeighbor(D);
        D.addNeighbor(B);
        D.addNeighbor(C);
        D.addNeighbor(E);
        D.addNeighbor(I);
        E.addNeighbor(A);
        E.addNeighbor(D);
        E.addNeighbor(F);
        E.addNeighbor(I);
        F.addNeighbor(A);
        F.addNeighbor(E);
        F.addNeighbor(I);
        G.addNeighbor(H);
        G.addNeighbor(I);
        H.addNeighbor(G);
        H.addNeighbor(I);
        H.addNeighbor(L);
        I.addNeighbor(D);
        I.addNeighbor(E);
        I.addNeighbor(F);
        I.addNeighbor(G);
        I.addNeighbor(H);
        I.addNeighbor(J);
        I.addNeighbor(K);
        I.addNeighbor(M);
        J.addNeighbor(I);
        J.addNeighbor(M);
        K.addNeighbor(I);
        K.addNeighbor(L);
        K.addNeighbor(M);
        L.addNeighbor(H);
        L.addNeighbor(K);
        M.addNeighbor(I);
        M.addNeighbor(J);
        M.addNeighbor(K);

        Iterator<String> iterator = DFT(A).iterator();
        while (iterator.hasNext()) {
            System.out.printf(iterator.next() + "\t");
        }

        System.out.println();
        System.out.println("----------------------------------------------------");

        setFalse(A, B, C, D, E, F, G, H, I, J, K, L, M);
        result.clear();

        ArrayList<String> bft = BFT(A);
        for (int i = 0; i < bft.size(); i++) {
            System.out.printf(bft.get(i) + "\t");
        }
    }

    public static ArrayList<String> DFT(NodeGraph starter) {

        starter.setVisited(true);
        result.add(starter.getValue());

        ArrayList<NodeGraph> neighbors = starter.getNeighbors();
        for (NodeGraph e : neighbors) {
            if (!e.isVisited()) {
                DFT(e);
            }
        }
        return result;
    }

    public static ArrayList<String> BFT(NodeGraph starter) {
        Queue<NodeGraph> queue = new LinkedList();
        queue.add(starter);
        while (queue.size() != 0) {
            NodeGraph firstNode = queue.poll(); // 移除 queue 的第一個元素
            if (!firstNode.isVisited()) {
                firstNode.setVisited(true);
                result.add(firstNode.getValue());
                for (int i = 0; i < firstNode.getNeighbors().size(); i++) {
                    if (!firstNode.getNeighbors().get(i).isVisited()) {
                        queue.add(firstNode.getNeighbors().get(i));
                    }
                }
            }
        }
        return result;
    }
}

class NodeGraph {
    private String value;
    private ArrayList<NodeGraph> neighbors = new ArrayList<>();
    private boolean visited;

    public NodeGraph(String value) {
        this.value = value;
    }

    public void addNeighbor(NodeGraph node) {
        this.neighbors.add(node);
    }

    public String getValue() {
        return value;
    }

    public ArrayList<NodeGraph> getNeighbors() {
        return neighbors;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
