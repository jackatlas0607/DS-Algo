public class _74LinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.push("Ogurisuda");
        list.push("Tina");
        list.push("Luka Dončić");
        list.push("Uchiha Sauske");
        list.push("Hatake Kakashi");
        list.push("Uzumaki Naruto");
        System.out.println("list length is " + list.getLength());
        list.printAll();
        System.out.println("--------------------------------------------");

        System.out.println(list.get(2));
    }
}

class Node<E> {
    private E vlaue;
    private Node next;

    public Node(E vlaue) {
        this.vlaue = vlaue;
        this.next = null;
    }

    public E getVlaue() {
        return vlaue;
    }

    public void setVlaue(E vlaue) {
        this.vlaue = vlaue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class MyLinkedList {
    private Node head;
    private int length;

    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    //只有push pop --> stack

    //加在list尾
    public <E> void push(E value) {
        Node<E> newNode = new Node<>(value);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<E> currentNode = this.head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        length++;
    }

    //移除list尾
    public void pop() {
        if (this.head == null) {
            System.out.println("No elements in this list.");
            return;
        } else if (this.length == 1) {
            Node temp = this.head;
            this.head = null;
            this.length = 0;
            System.out.println("Remove " + temp.getVlaue());
        } else {
            Node currentNode = this.head;
            for (int i = 1; i < this.length - 1; i++) {
                currentNode = currentNode.getNext();
            }
            Node temp = currentNode.getNext();
            currentNode.setNext(null);
            this.length--;
            System.out.println("Remove " + temp.getVlaue());
        }
    }

    //移除list頭
    public void shift() {
        if (this.head == null) {
            System.out.println("No elements in this list.");
            return;
        } else if (this.length == 1) {
            Node temp = this.head;
            this.head = null;
            this.length = 0;
            System.out.println("Remove " + temp.getVlaue());
        } else {
            Node temp = this.head;
            this.head = this.head.getNext();
            this.length--;
            System.out.println("Remove " + temp.getVlaue());
        }
    }

    //加在list頭
    public <E> void unshift(E value) {
        if (this.head == null) {
            this.head = new Node(value);
        } else {
            Node temp = this.head;
            Node newNode = new Node<>(value);
            this.head = newNode;
            this.head.setNext(temp);
        }
        this.length++;
    }

    //在特定位置加入
    public <E> void insertAt(int index, E value) {
        if (index > this.length || index < 0) {
            System.out.println("Invalid index !");
            return;
        } else if (index == 0) {
            this.unshift(value);
            return;
        } else if (index == this.length) {
            this.push(value);
            return;
        }

        Node<E> currentNode = this.head;
        Node<E> newNode = new Node<>(value);
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        this.length++;
        return;
    }

    //在特定位置刪除
    public void removeAt(int index) {
        if (index > this.length - 1 || index < 0) {
            System.out.println("Invalid index !");
            return;
        } else if (index == 0) {
            this.shift();
        } else if (index == this.length - 1) {
            this.pop();
        }

        Node currentNode = this.head;
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(currentNode.getNext().getNext());
        this.length--;
    }

    //獲取特定位置
    public Object get(int index) {
        if (index >= this.length || index<0){
            System.out.println("Invalid index !");
            return null;
        }

        Node currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getVlaue();
    }

    public int getLength() {
        return this.length;
    }

    public void printAll() {
        if (this.length == 0) {
            System.out.println("Nothing in this linked list.");
            return;
        }

        Node currentNode = this.head;
        while (currentNode != null) {
            System.out.println(currentNode.getVlaue());
            currentNode = currentNode.getNext();
        }
    }
}
