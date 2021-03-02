//Victor Tuah Kumi
//Lab 1

package AVL;

import tree.StudentNode;

public class Main {
    public static void main(String[] args){
        AVLTree tree = new AVLTree();
        tree.insert(new AVLTree.AVLNode("Sarah",10));
        tree.insert(new AVLTree.AVLNode("bob",5));
        tree.insert(new AVLTree.AVLNode("Sam",2));
        tree.insert(new AVLTree.AVLNode("Vic",1));
        tree.insert(new AVLTree.AVLNode("Joe",7));
        tree.insert(new AVLTree.AVLNode("a",17));
        tree.insert(new AVLTree.AVLNode("b",12));
        tree.insert(new AVLTree.AVLNode("Sarah",10)); //to show that repition not allowed
        tree.insert(new AVLTree.AVLNode("c",20));
        tree.printPreOrder ();
        System.out.println("------------");
        tree.printInOrder();
        System.out.println("------------");
        tree.printPostOrder();

    }
}
