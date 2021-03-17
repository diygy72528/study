/**
 * @author guyao
 * @date 2021/3/16 1:57 PM
 */
public class Tree {
    private Node root;

    public void insert(int key) {
        Node node = new Node();
        node.setData(key);
        if(root == null) {
            root = node;
            return;
        }
        Node parent = root;
        while(true) {
            if(key < parent.getData()) {
                if( parent.getLeft() == null ) {
                    parent.setLeft(node);
                    return;
                }
                parent = parent.getLeft();
            }else {
                if(parent.getRight() == null) {
                    parent.setRight(node);
                    return;
                }
                parent = parent.getRight();
            }
        }
    }

    public Node find(int key) {
        Node current = root;
        while(current != null) {
            if(current.getData() == key)
                return current;
            else if (key < current.getData())
                current = current.getLeft();
            else
                current = current.getRight();
        }
        return null;
    }


    //中序遍历
    public void inOrder(Node node) {
        if(node == null)
            return;
        inOrder(node.getLeft());
        System.out.println(node.getData());
        inOrder(node.getRight());
    }


    //最大值
    public Node max() {
        Node max;
        if ((max = root) == null)
            return null;
        while(max.getRight() != null) {
            max = max.getRight();
        }
        return max;
    }

    //最小值
    public Node minimum() {
        Node min;
        if((min = root) == null) {
            return null;
        }
        while(min.getLeft()!=null) {
            min = min.getRight();
        }
        return min;
    }


    //删除
    public Node delete(int key) {
        Node parent = null;
        Node current = root;
        boolean left = false;
        while(current != null ) {
            int curData = current.getData();
            if(curData == key) {
                //没有子节点
                if(current.getLeft() == null && current.getRight() == null) {
                    if(parent == null) {
                        //根节点
                        root = null;
                    }else{
                        if(left) {
                            parent.setLeft(null);
                        }else{
                            parent.setRight(null);
                        }
                    }
                }else if(current.getLeft() != null) {
                    //左
                    if(parent == null) {
                        root = current.getLeft();
                    }else if(left) {
                        parent.setLeft(current.getLeft());
                    }else {
                        parent.setRight(current.getLeft());
                    }
                    current.setLeft(null);
                }else if(current.getRight() != null){
                    //右
                    if(parent == null) {
                        root = current.getRight();
                    }else if(left) {
                        parent.setLeft(current.getRight());
                    }else {
                        parent.setRight(current.getRight());
                    }
                    current.setRight(null);
                }else {
                    //两个子节点
                    Node successor = getSuccessor(current);
                    if(parent == null) {
                        root = successor;
                    }else if(left) {
                        parent.setLeft(successor);
                    }else {
                        parent.setRight(successor);
                    }
                    successor.setLeft(current.getLeft());
                    current.setLeft(null);
                    current.setRight(null);
                }
                return current;

            }
            //赋值
            parent = current;
            if(curData > key) {
                left = true;
                current = current.getLeft();
            }else {
                left = false;
                current = current.getRight();
            }
        }
        return null;
    }

    //获取次大值
    private Node getSuccessor(Node current) {
        Node successor = current.getRight();
        Node rightCurrent = successor.getLeft();
        Node rightParent = current;
        while(rightCurrent != null) {
            rightParent = successor;
            successor = rightCurrent;
            rightCurrent = rightCurrent.getLeft();
        }
        if(current.getRight() != successor) {
            //有左子节点
            rightParent.setLeft(successor.getRight());
            successor.setRight(current.getRight());
        }
        return successor;
    }

    public Node getRoot() {
        return root;
    }
}
