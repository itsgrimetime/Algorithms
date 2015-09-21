import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by michaelgrimes on 11/18/14.
 */
public class BinaryTree {

    private BTNode root;

    public BinaryTree(int value) {
        this.root = new BTNode(value);
    }

    private static class BTNode {
        int value;
        BTNode left, right, parent;

        private BTNode(int value) {
            this.value = value;
        }

        private BTNode(int value, BTNode parent, BTNode left, BTNode right) {
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        private void setLeft(BTNode left) {
            this.left = left;
        }

        private void setRight(BTNode right) {
            this.right = right;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        BinaryTree tree = new BinaryTree(10);
        tree.insert(9);
        tree.insert(11);
        tree.insert(8);
        tree.insert(12);
        tree.insert(7);
        tree.insert(13);
        tree.insert(6);
        tree.insert(14);
        tree.insert(5);
        tree.insert(15);
        tree.insert(4);
        tree.insert(16);
        tree.insert(3);
        tree.insert(17);
        tree.insert(2);

        for (List<BTNode> level : getLevels(tree.root)) {
            for (BTNode node : level) {
                System.out.print(node.value + " ");
            }
            System.out.println();
        }
    }

    public void insert(int value) {
        BTNode node = new BTNode(value);
        BTNode cur = this.root;
        while (true) {
            if (node.value <= cur.value) {
                if (cur.left == null) {
                    node.parent = cur;
                    cur.left = node;
                    break;
                } else {
                    cur = cur.left;
                }
            } else {
                if (cur.right == null) {
                    node.parent = cur;
                    cur.right = node;
                    break;
                } else {
                    cur = cur.right;
                }
            }
        }
    }



    public static List<List<BTNode>> getLevels(BTNode node) {
        List<List<BTNode>> levels = new ArrayList<List<BTNode>>();
        LinkedList<BTNode> q = new LinkedList<BTNode>();

        BTNode last = node;
        q.add(node);
        BTNode cur;
        List<BTNode> curList = new ArrayList<BTNode>();
        while (!q.isEmpty()) {
            cur = q.poll();
            curList.add(cur);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
            if (last == cur) {
                last = cur.right;
                levels.add(curList);
                curList = new ArrayList<BTNode>();
            }
        }
        return levels;
    }

    public static boolean balanced(BTNode node) {
        if (node.left == null && node.right == null) {
            return true;
        } else if (node.left == null && node.right != null) {
            return height(node.right) <= 1;
        } else if (node.left != null && node.right == null) {
            return height(node.left) <= 1;
        } else {
            return balanced(node.left) && balanced(node.right);
        }
    }

    public static int height(BTNode node) {
        if (node.left == null && node.right == null) {
            return 1;
        } else if (node.left == null && node.right != null) {
            return 1 + height(node.right);
        } else if (node.left != null && node.right == null) {
            return 1 + height(node.left);
        } else {
            return Math.max(height(node.left), height(node.right));
        }
    }

    public static boolean isBST(BTNode node) {
        if (node.left.value > node.value) {
            return false;
        } else if (node.right.value <= node.value) {
            return false;
        } else {
            return isBST(node.left) || isBST(node.right);
        }
    }

    public static BTNode inOrderSucc(BTNode node) {
        return new BTNode(-1);
    }

}
