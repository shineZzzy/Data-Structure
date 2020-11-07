package Tree;

public class Node {
    Integer key;
    Node left;
    Node right;
    Node root;

    public Node(Integer key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                '}';
    }
}
