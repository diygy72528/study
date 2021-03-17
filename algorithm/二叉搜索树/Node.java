/**
 * @author guyao
 * @date 2021/3/16 1:58 PM
 */
public class Node {
    private int data;
    private Node left;
    private Node right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    private void displayNode() {

    }

    @Override
    public String toString() {
        return "" + data;
    }
}
