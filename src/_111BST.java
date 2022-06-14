import java.util.ArrayList;

public class _111BST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.treeInsert(new NodeBST(15));
        bst.treeInsert(new NodeBST(6));
        bst.treeInsert(new NodeBST(5));
        bst.treeInsert(new NodeBST(1));
        bst.treeInsert(new NodeBST(13));
        bst.treeInsert(new NodeBST(-7));
        bst.treeInsert(new NodeBST(3));


        bst.preOrder(bst.getRoot());
        System.out.println("Preorder " + bst.getPath());
        bst.cleanPath();

        bst.inOrder(bst.getRoot());
        System.out.println("Inorder " + bst.getPath());
        bst.cleanPath();

        bst.postOrder(bst.getRoot());
        System.out.println("Postorder "+bst.getPath());



        /*
         bst.bftt(bst.getRoot());
        ArrayList arrayList = bst.getQueue();
        for (Object e : arrayList){
            System.out.println(e);
        }

         */


       /*
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
       */

        System.out.println(bst.searchRecursively(bst.getRoot(), 13));

        System.out.println("----------------------------------------");

        bst.searchIteratively(bst.getRoot(), 13);

    }
}

class NodeBST {
    private int key;
    private NodeBST left;
    private NodeBST right;

    public NodeBST(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public NodeBST getLeft() {
        return left;
    }

    public void setLeft(NodeBST left) {
        this.left = left;
    }

    public NodeBST getRight() {
        return right;
    }

    public void setRight(NodeBST right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "NodeBST{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class BinarySearchTree {
    private NodeBST root;
    private String path = "";
    private ArrayList queue = new ArrayList();


    public void treeInsert(NodeBST z) {
        NodeBST y = null;
        NodeBST x = this.root;

        while (x != null) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }

        if (y == null) {
            this.root = z;
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }
    }

    public void cleanPath(){
        this.path=" ";
    }

    public void preOrder(NodeBST n) {
        if (n != null) {
            this.path += n.getKey() + " ";    // root
            this.preOrder(n.getLeft());   // left
            this.preOrder(n.getRight());  // right
        }
    }

    public void inOrder(NodeBST n) {
        if (n != null) {
            this.inOrder(n.getLeft());   // left
            this.path += n.getKey() + " ";    // root
            this.inOrder(n.getRight());  // right
        }
    }

    public void postOrder(NodeBST n) {
        if (n != null) {
            this.postOrder(n.getLeft());   // left
            this.postOrder(n.getRight());  // right
            this.path += n.getKey() + " ";    // root
        }
    }

    public void bftt(NodeBST n) {
        if (n != null) {
            this.queue.add(n);
            for (int i = 0; i < this.queue.size(); i++) {
                NodeBST currentNode = (NodeBST) this.queue.get(i);
                if (currentNode != null) {
                    if (currentNode.getLeft() != null) {
                        this.queue.add(currentNode.getLeft());
                    }
                    if (currentNode.getRight() != null) {
                        this.queue.add(currentNode.getRight());
                    }
                }
            }
        }

    }

    public NodeBST searchRecursively(NodeBST x, int key) {
        if (x == null || key == x.getKey()) {
            return x;
        } else if (key < x.getKey()) {
            return this.searchRecursively(x.getLeft(), key);
        } else {
            return this.searchRecursively(x.getRight(), key);
        }
    }

    public void searchIteratively(NodeBST x, int key) {
        while (x != null && key != x.getKey()) {
            if (key < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }

        if (x == null) {
            System.out.println("Node not found");
        } else {
            System.out.println("Node found");
            System.out.println(x);
        }
    }


    public NodeBST getRoot() {
        return root;
    }

    public String getPath() {
        return path;
    }

    public ArrayList getQueue() {
        return queue;
    }
}

