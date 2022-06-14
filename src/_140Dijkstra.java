import java.util.ArrayList;

public class _140Dijkstra {

    public static void main(String[] args) throws CloneNotSupportedException {
        Node_Dijkstra A = new Node_Dijkstra("A");
        Node_Dijkstra B = new Node_Dijkstra("B");
        Node_Dijkstra C = new Node_Dijkstra("C");
        Node_Dijkstra D = new Node_Dijkstra("D");
        Node_Dijkstra E = new Node_Dijkstra("E");
        Node_Dijkstra F = new Node_Dijkstra("F");

        A.addEdges(new Edge_Dijkstra(B, 2));
        A.addEdges(new Edge_Dijkstra(C, 2));
        B.addEdges(new Edge_Dijkstra(A, 2));
        B.addEdges(new Edge_Dijkstra(D, 1));
        B.addEdges(new Edge_Dijkstra(E, 4));
        C.addEdges(new Edge_Dijkstra(A, 2));
        C.addEdges(new Edge_Dijkstra(D, 1));
        C.addEdges(new Edge_Dijkstra(F, 2));
        D.addEdges(new Edge_Dijkstra(B, 1));
        D.addEdges(new Edge_Dijkstra(C, 1));
        D.addEdges(new Edge_Dijkstra(E, 2));
        D.addEdges(new Edge_Dijkstra(F, 3));
        E.addEdges(new Edge_Dijkstra(B, 4));
        E.addEdges(new Edge_Dijkstra(D, 2));
        E.addEdges(new Edge_Dijkstra(F, 1));
        F.addEdges(new Edge_Dijkstra(C, 2));
        F.addEdges(new Edge_Dijkstra(D, 3));
        F.addEdges(new Edge_Dijkstra(E, 1));

        Dijkstra(E,A,B,C,D,E,F);

        System.out.println("A's information");
        System.out.println(A.getDistanceFromStartNode());
        System.out.println(A.getPrevious().getValue());
        System.out.println("B's Info");
        System.out.println(B.getDistanceFromStartNode());
        System.out.println(B.getPrevious().getValue());
        System.out.println("C's Info");
        System.out.println(C.getDistanceFromStartNode());
        System.out.println(C.getPrevious().getValue());
        System.out.println("D's Info");
        System.out.println(D.getDistanceFromStartNode());
        System.out.println(D.getPrevious().getValue());
        System.out.println("E's Info");
        System.out.println(E.getDistanceFromStartNode());
        System.out.println(E.getPrevious().getValue());
        System.out.println("F's Info");
        System.out.println(F.getDistanceFromStartNode());
        System.out.println(F.getPrevious().getValue());



    }

    private static void Dijkstra(Node_Dijkstra startNode, Node_Dijkstra... nodeArray) throws CloneNotSupportedException {
        MinHeap MH = new MinHeap();
        startNode.setDistanceFromStartNode(0);
        startNode.setVisited(true);

        for (int i = 0; i < nodeArray.length; i++) {
            MH.enqueue(nodeArray[i]);
        }

        Node_Dijkstra currentNode = MH.dequeue();

        while (MH.getValues().size() > 0) {
            ArrayList<Edge_Dijkstra> edges = currentNode.getEdges();
            for (int i = 0; i < edges.size(); i++) {
                Node_Dijkstra neighborNode = edges.get(i).getNode();
                if (!neighborNode.isVisited()) {
                    int d1 = neighborNode.getDistanceFromStartNode(); //該node與尚未拜訪的相鄰node的最初距離(Infinity)
                    int d2 = currentNode.getDistanceFromStartNode();  // 該node與startNode的距離
                    int d3 = edges.get(i).getWeight();  //該node與尚未拜訪的相鄰node的距離(weight)
                    if (d1 > d2 + d3) {
                        neighborNode.setDistanceFromStartNode(d2 + d3);
                        neighborNode.setPrevious(currentNode);
                    }
                }
            }
            currentNode = MH.dequeue();
        }
    }
}

class Node_Dijkstra implements Cloneable {
    private String value;
    private boolean visited;
    private ArrayList<Edge_Dijkstra> edges = new ArrayList<>();
    private int distanceFromStartNode;
    private Node_Dijkstra previous;

    public Node_Dijkstra() {

    }

    public Node_Dijkstra(String value) {
        this.value = value;
        this.distanceFromStartNode = (int) Double.POSITIVE_INFINITY;
        this.previous = null;
    }

    public void addEdges(Edge_Dijkstra edge) {
        this.edges.add(edge);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public ArrayList<Edge_Dijkstra> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge_Dijkstra> edges) {
        this.edges = edges;
    }

    public int getDistanceFromStartNode() {
        return distanceFromStartNode;
    }

    public void setDistanceFromStartNode(int distanceFromStartNode) {
        this.distanceFromStartNode = distanceFromStartNode;
    }

    public Node_Dijkstra getPrevious() {
        if (previous == null) {
            return new Node_Dijkstra();
        }
        return previous;
    }

    public void setPrevious(Node_Dijkstra previous) {
        this.previous = previous;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Node_Dijkstra{" +
                "value='" + value + '\'' +
                ", distanceFromStartNode=" + distanceFromStartNode +
                ", previous=" + previous +
                '}';
    }
}

class Edge_Dijkstra {
    private Node_Dijkstra node;
    private int weight;

    public Edge_Dijkstra(Node_Dijkstra node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public Node_Dijkstra getNode() {
        return node;
    }

    public void setNode(Node_Dijkstra node) {
        this.node = node;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge_Dijkstra{" +
                "node=" + node +
                ", weight=" + weight +
                '}';
    }
}

class MinHeap {
    private ArrayList<Node_Dijkstra> values;

    public MinHeap() {
        this.values = new ArrayList<>();
    }

    public void enqueue(Node_Dijkstra node) {
        // check if the priority queue is empty
        if (this.values.size() == 0) {
            this.values.add(node);
            return;
        }
        this.values.add(node);
        int newIndex = this.values.size() - 1;
        int parentIndex = (int) Math.floor((newIndex - 1) / 2);
        while (parentIndex >= 0 &&
                this.values.get(newIndex).getDistanceFromStartNode() <
                        this.values.get(parentIndex).getDistanceFromStartNode()) {
            // swap parent and child
            String tempValue = this.values.get(parentIndex).getValue();
            boolean tempVisited = this.values.get(parentIndex).isVisited();
            ArrayList<Edge_Dijkstra> tempEdges = this.values.get(parentIndex).getEdges();
            int tempDistanceFromStartNode = this.values.get(parentIndex).getDistanceFromStartNode();
            Node_Dijkstra tempPrevious = this.values.get(parentIndex).getPrevious();

            this.values.get(parentIndex).setValue(this.values.get(newIndex).getValue());
            this.values.get(parentIndex).setVisited(this.values.get(newIndex).isVisited());
            this.values.get(parentIndex).setEdges(this.values.get(newIndex).getEdges());
            this.values.get(parentIndex).setDistanceFromStartNode(this.values.get(newIndex).getDistanceFromStartNode());
            this.values.get(parentIndex).setPrevious(this.values.get(newIndex).getPrevious());

            this.values.get(newIndex).setValue(tempValue);
            this.values.get(newIndex).setVisited(tempVisited);
            this.values.get(newIndex).setEdges(tempEdges);
            this.values.get(newIndex).setDistanceFromStartNode(tempDistanceFromStartNode);
            this.values.get(newIndex).setPrevious(tempPrevious);

            // update index number
            newIndex = parentIndex;
            parentIndex = (int) Math.floor((newIndex - 1) / 2);
        }
    }

    public Node_Dijkstra dequeue() throws CloneNotSupportedException {
        if (this.values.size() == 0) {
            return null;
        }
        if (this.values.size() == 1) {
            Node_Dijkstra removeNode = this.values.remove(0);
            return removeNode;
        }

        // swap two nodes
        Node_Dijkstra temp = this.values.remove(this.values.size() - 1);  // 先移除ArrayList最後一個值
        Node_Dijkstra tempFirst = (Node_Dijkstra) this.values.get(0).clone();
        this.values.add(tempFirst);
        this.values.get(0).setValue(temp.getValue());
        this.values.get(0).setEdges(temp.getEdges());
        this.values.get(0).setVisited(temp.isVisited());
        this.values.get(0).setDistanceFromStartNode(temp.getDistanceFromStartNode());
        this.values.get(0).setPrevious(temp.getPrevious());

        Node_Dijkstra removeNode = this.values.remove(this.values.size() - 1);
        this.minHeapify(0);
        return removeNode;
    }

    public void minHeapify(int i) throws CloneNotSupportedException {
        int smallest;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l <= this.values.size() - 1 && this.values.get(l).getDistanceFromStartNode() <
                this.values.get(i).getDistanceFromStartNode()) {
            smallest = l;
        } else {
            smallest = i;
        }

        if (r <= this.values.size() - 1 && this.values.get(r).getDistanceFromStartNode() <
                this.values.get(smallest).getDistanceFromStartNode()) {
            smallest = r;
        }

        if (smallest != i) {
            // swap
            Node_Dijkstra temp = (Node_Dijkstra) this.values.get(i).clone();
            this.values.get(i).setValue(this.values.get(smallest).getValue());
            this.values.get(i).setEdges(this.values.get(smallest).getEdges());
            this.values.get(i).setVisited(this.values.get(smallest).isVisited());
            this.values.get(i).setDistanceFromStartNode(this.values.get(smallest).getDistanceFromStartNode());
            this.values.get(i).setPrevious(this.values.get(smallest).getPrevious());

            this.values.get(smallest).setValue(temp.getValue());
            this.values.get(smallest).setEdges(temp.getEdges());
            this.values.get(smallest).setVisited(temp.isVisited());
            this.values.get(smallest).setDistanceFromStartNode(temp.getDistanceFromStartNode());
            this.values.get(smallest).setPrevious(temp.getPrevious());

            this.minHeapify(smallest);
        }
    }

    public ArrayList<Node_Dijkstra> getValues() {
        return values;
    }
}
 