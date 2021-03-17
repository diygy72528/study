/**
 * @author guyao
 * @date 2021/3/17 1:33 PM
 */
public class Test {


    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);
        tree.delete(6);
        tree.inOrder(tree.getRoot());
    }
}
