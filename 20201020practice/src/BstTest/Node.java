package BstTest;

public class Node {
    Node left;
    Node right;
    public Integer key;

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
