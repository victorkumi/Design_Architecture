//Victor Tuah Kumi
//Lab 1
package AVL;

public class AVLTree {
    public static class AVLNode{
        private int id;
        private String name;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(String name, int value){
            this.name = name;
            this.id = value;
        }

        @Override
        public String toString() {
            return name + ", " + id;
        }

        public AVLNode getLeft() {
            return leftChild;
        }
        public AVLNode getRight() {
            return rightChild;
        }
    }

    private AVLNode root;

    public void insert( AVLNode value){
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, AVLNode value){
        if (root==null)
            return new AVLNode(value.name, value.id);
        if(value.id<root.id)
            root.leftChild = insert(root.leftChild, value);
        else if(value.id > root.id)
            root.rightChild = insert(root.rightChild, value);
        else {
            System.out.println("The student already exists");
            return root;
        }
        //root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
        setHeight(root);
        root = balance(root);


        //balance factor = height(L) - height(R)
        // > 1 => left heavy so perform right rotation : < -1 => right heavy so perform left rotation
        return root;
    }

    private AVLNode balance(AVLNode root){
        //if(balanceFactor > 1)
        if (isLeftHeavy(root)) {
            //System.out.println(root.value + " is left heavy");
            if(balanceFactor(root.leftChild) < 0)
                //System.out.println("Left Rotate " + root.leftChild.value);
                root.leftChild = rotateLeft(root.leftChild);
            //System.out.println("Right Rotate " + root.value);
            return rotateRight(root);
        }
        //else if (balanceFactor < -1)
        else if (isRightHeavy(root)) {
            if(balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root);
        }
        return root;
    }

    private AVLNode rotateLeft(AVLNode root){
        var newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        //root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root){
        var newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node){
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }

    private boolean isLeftHeavy(AVLNode node){
        //return height(node.leftChild) - height(node.rightChild) > 1;
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node){
        //return height(node.leftChild) - height(node.rightChild) < -1;
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node){
       return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private int height(AVLNode node){
        return (node == null) ? -1 : node.height;
    }

    public void printPreOrder () {
        TraversePreOrder (getRoot());
    }
    public void printInOrder () {
        TraverseInOrder (getRoot());
    }
    public void printPostOrder () {
        TraversePostOrder (getRoot());
    }

    private void TraversePreOrder (AVLNode cursor) {    //Node, left subtree, right subtree

        if (cursor != null) {
            System.out.println(cursor);
            TraversePreOrder (cursor.getLeft());
            TraversePreOrder (cursor.getRight());
        }
    }

    private void TraverseInOrder (AVLNode cursor) {    //Nodes in ascending order

        if (cursor != null) {

            TraverseInOrder (cursor.getLeft());
            System.out.println(cursor);
            TraverseInOrder (cursor.getRight());
        }
    }
    private void TraversePostOrder (AVLNode cursor) {    //Left, right, node
        if (cursor != null) {

            TraversePostOrder (cursor.getLeft());
            TraversePostOrder (cursor.getRight());
            System.out.println(cursor);
        }
    }

    public AVLNode getRoot() {
        return root;
    }
}
