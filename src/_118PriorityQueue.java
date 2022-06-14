import java.util.ArrayList;
import java.util.Iterator;

public class _118PriorityQueue {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyPriorityQueue pq = new MyPriorityQueue();
        pq.enqueue("Eat Breakfast", 5);
        pq.enqueue("Learn Java", 2);
        pq.enqueue("Learn Python", 7);
        pq.enqueue("Buy Textbooks", 8);
        pq.enqueue("Watch Netflix", 12);
        pq.enqueue("Pay Bills", 15);

        /*
        ArrayList<NodePQ> pqValues = pq.getValues();
        for (NodePQ e : pqValues) {
            System.out.println(e);
        }
        */

        //打印出來最上面一定是priority最高者，下面就不是考量範圍

        Iterator<NodePQ> iterator = pq.getValues().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("-----------------------------------------");

        while (pq.getValues().size() > 0) {
            pq.dequeue();
        }
    }
}

class NodePQ implements Cloneable{
    private String value;
    private int priority;

    public NodePQ(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public String getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    //重寫 clone() 方法，需 implements Cloneable interface
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "NodePQ{" +
                "value='" + value + '\'' +
                ", priority=" + priority +
                '}';
    }
}

class MyPriorityQueue {
    private ArrayList<NodePQ> values = new ArrayList();

    public MyPriorityQueue() {

    }

    public void enqueue(String value, int priority) {
        NodePQ newNode = new NodePQ(value, priority);

        // check if the priority queue is empty
        if (this.values.size() == 0) {
            this.values.add(newNode);
            return;
        }

        this.values.add(newNode);
        int newIndex = this.values.size() - 1;
        int parentIndex = (int) Math.floor((newIndex - 1) / 2);

        while (parentIndex >= 0 &&
                this.values.get(newIndex).getPriority() > this.values.get(parentIndex).getPriority()) {
            // swap parent and child
            String originalValue = this.values.get(parentIndex).getValue();
            int originalPriority = this.values.get(parentIndex).getPriority();

            this.values.get(parentIndex).setPriority(this.values.get(newIndex).getPriority());
            this.values.get(parentIndex).setValue(this.values.get(newIndex).getValue());

            this.values.get(newIndex).setPriority(originalPriority);
            this.values.get(newIndex).setValue(originalValue);

            // update index number  再繼續往上檢查是否需要再換位置
            newIndex = parentIndex;
            parentIndex = (int) Math.floor((newIndex - 1) / 2);

        }
    }

    public void dequeue() throws CloneNotSupportedException {
        if (this.values.size() == 0) {
            System.out.println("No element in this priority queue.");
            return;
        }

        if (this.values.size() == 1) {
            System.out.println(this.values.remove(0));
            return;
        }

        // swap two nodes
        NodePQ temp = this.values.remove(this.values.size() - 1); // 先移除ArrayList最後一個值
        NodePQ firstElement = (NodePQ) this.values.get(0).clone();
        this.values.add(firstElement);
        this.values.get(0).setValue(temp.getValue());
        this.values.get(0).setPriority(temp.getPriority());

        NodePQ removeNode = this.values.remove(this.values.size() - 1);
        System.out.println(removeNode);

        maxHeapify(0);


    }

    public void maxHeapify(int i) {
        int largest;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < this.values.size() &&
                this.values.get(l).getPriority() > this.values.get(i).getPriority()) {
            largest = l;
        } else {
            largest = i;
        }

        if (r < this.values.size() &&
                this.values.get(r).getPriority() > this.getValues().get(largest).getPriority()) {
            largest = r;
        }

        if (largest != i) {
            // swap
            String tempValue = this.values.get(i).getValue();
            int tempPriority = this.values.get(i).getPriority();

            this.values.get(i).setPriority(this.values.get(largest).getPriority());
            this.values.get(i).setValue(this.values.get(largest).getValue());

            this.values.get(largest).setValue(tempValue);
            this.values.get(largest).setPriority(tempPriority);
            maxHeapify(largest);
        }
    }


    public ArrayList<NodePQ> getValues() {
        return values;
    }
}
