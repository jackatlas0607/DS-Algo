import java.util.ArrayList;
import java.util.Iterator;

public class _126MST {

    private static ArrayList<Edge> bucket = new ArrayList<>();

    private static void setFalse(NodeMST... nodeArray) {
        for (int i = 0; i < nodeArray.length; i++) {
            nodeArray[i].setVisited(false);
        }
    }

    public static void main(String[] args) {
        NodeMST A = new NodeMST("A");
        NodeMST B = new NodeMST("B");
        NodeMST C = new NodeMST("C");
        NodeMST D = new NodeMST("D");
        NodeMST E = new NodeMST("E");
        NodeMST F = new NodeMST("F");
        NodeMST[] allNodes = {A, B, C, D, E, F};

        Edge e1 = new Edge(A, B, 10);
        A.addNeighbor(e1);
        B.addNeighbor(e1);

        Edge e2 = new Edge(A, C, 8);
        A.addNeighbor(e2);
        C.addNeighbor(e2);

        Edge e3 = new Edge(B, D, 6);
        B.addNeighbor(e3);
        D.addNeighbor(e3);

        Edge e4 = new Edge(C, D, 5);
        C.addNeighbor(e4);
        D.addNeighbor(e4);

        Edge e5 = new Edge(B, E, 7);
        B.addNeighbor(e5);
        E.addNeighbor(e5);

        Edge e6 = new Edge(D, E, 4);
        D.addNeighbor(e6);
        E.addNeighbor(e6);

        Edge e7 = new Edge(D, F, 3);
        D.addNeighbor(e7);
        F.addNeighbor(e7);

        Edge e8 = new Edge(E, F, 1);
        E.addNeighbor(e8);
        F.addNeighbor(e8);

        Edge e9 = new Edge(C, F, 8);
        C.addNeighbor(e9);
        F.addNeighbor(e9);

        ArrayList<Edge> edgeArrayList1 = mstPrim(A, allNodes);
        for (Edge edge : edgeArrayList1) {
            System.out.println(edge);
        }

        setFalse(A, B, C, D, E, F);

        System.out.println("--------------------------------------------------");

        ArrayList<Edge> edgeArrayList2 = mstPrim(B, allNodes);
        Iterator<Edge> iterator = edgeArrayList2.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        setFalse(A, B, C, D, E, F);

        System.out.println("--------------------------------------------------");

        ArrayList<Edge> edgeArrayList3 = mstPrim(C, allNodes);
        for (int i = 0; i < edgeArrayList3.size(); i++) {
            System.out.println(edgeArrayList3.get(i));
        }
    }

    public static ArrayList<Edge> mstPrim(NodeMST startNode, NodeMST[] allNodes) {
        ArrayList<Edge> mstEdges = new ArrayList<>();

        //把startNode相鄰的所有edges加到bucket裡
        for (int i = 0; i < startNode.getEdges().size(); i++) {
            bucket.add(startNode.getEdges().get(i));
        }

        Edge bestEdge = getBestEdge();

        while (bestEdge != null) {
            NodeMST n1 = bestEdge.getNode1();
            NodeMST n2 = bestEdge.getNode2();
            n1.setVisited(true);
            n2.setVisited(true);
            mstEdges.add(bestEdge);

            bucket.clear();
            //bucket = new ArrayList<>();

            for (NodeMST e : allNodes) {
                if (e.isVisited()) {
                    ArrayList<Edge> edgeArrayList = e.getEdges();
                    for (int i = 0; i < edgeArrayList.size(); i++) {
                        if (!mstEdges.contains(edgeArrayList.get(i))) {
                            bucket.add(edgeArrayList.get(i));
                        }
                    }
                }
            }
            bestEdge = getBestEdge();
        }
        return mstEdges;
    }

    //放在bucket裡的edges，哪一個才是適合放在 mstEdges 裡
    public static Edge getBestEdge() {
        Edge bestEdge = null;
        while (bestEdge == null && bucket.size() != 0) {
            // find the best edge
            bestEdge = bucket.get(0);
            int index = 0;
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(i).getWeight() < bestEdge.getWeight()) {
                    bestEdge = bucket.get(i);
                    index = i;
                }
            }
            if (bestEdge.getNode1().isVisited() && bestEdge.getNode2().isVisited()) {
                bucket.remove(index);  // 把該元素從bucket刪除，因為會產生loop
                bestEdge = null;
            }
        }
        return bestEdge;
    }
}

class NodeMST {
    private String value;
    private boolean visited;
    private ArrayList<Edge> edges = new ArrayList<>();

    public NodeMST(String value) {
        this.value = value;
    }

    public void addNeighbor(Edge edge) {
        this.edges.add(edge);
    }

    public boolean isVisited() {
        return visited;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "NodeMST{" +
                "value='" + value + '\'' +
                ", visited=" + visited +
                '}';
    }
}

class Edge {
    private NodeMST node1;
    private NodeMST node2;
    private int weight;

    public Edge(NodeMST node1, NodeMST node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public NodeMST getNode1() {
        return node1;
    }

    public NodeMST getNode2() {
        return node2;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "node1=" + node1 +
                ", node2=" + node2 +
                ", weight=" + weight +
                '}';
    }
}