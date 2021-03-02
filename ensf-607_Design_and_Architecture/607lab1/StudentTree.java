//Victor Tuah Kumi
//Lab 1

package tree;

public class StudentTree {
	
	private StudentNode root;
	
	
	
	public StudentTree () {
		setRoot(null);
	}
	
	public void insert (StudentNode node) {
		
		if (node == null)
			return;
		//making sure both left and right of the node are null
		node.setLeft(null);
		node.setRight(null);
		
		if (root == null)
			root = node;
		else {
			//Start with the root and look for a spot to insert
			//i.e. Traverse the tree and look for the proper spot to insert node
			StudentNode cursor = getRoot ();
			while (true) {
				StudentNode parent = cursor;
				//Question: insert to the left or right?
				if (node.getId() < cursor.getId()) {
					cursor = cursor.getLeft();
					//if the left child has no children, insert!
					if (cursor == null) {
						parent.setLeft(node);
						return;
					}
				
				}
				else if (node.getId() > cursor.getId()) {
					cursor = cursor.getRight();
					//if the right child has no children, insert
					if (cursor == null) {
						parent.setRight(node);
						return;
					}
					
				}
				else {
					System.out.println("This student already exists!");
					return;   //the  node is not added if the id already exists
				}
				
			}
		}
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

	private void TraversePreOrder (StudentNode cursor) {    //Node, left subtree, right subtree 

		if (cursor != null) {
			System.out.println(cursor);
			TraversePreOrder (cursor.getLeft());
			TraversePreOrder (cursor.getRight());
		}
	}

	private void TraverseInOrder (StudentNode cursor) {    //Nodes in ascending order

		if (cursor != null) {

			TraverseInOrder (cursor.getLeft());
			System.out.println(cursor);
			TraverseInOrder (cursor.getRight());
		}
	}
	private void TraversePostOrder (StudentNode cursor) {    //Left, right, node		
		if (cursor != null) {

			TraversePostOrder (cursor.getLeft());
			TraversePostOrder (cursor.getRight());
			System.out.println(cursor);
		}
	}
	public StudentNode searchStudent (int key) {
		//To be completed by Students!
		StudentNode student = searchNode(this.root, key);
		return student;
	}

	private StudentNode searchNode(StudentNode cursor, int key) {
		if (cursor==null || cursor.getId()==key)
			return cursor;
		else if (cursor.getId() > key)
			return searchNode(cursor.getLeft(), key);
		else
			return searchNode(cursor.getRight(), key);
	}

	public void deleteStudent (int key) {
		StudentNode deletedNode = deleteNode(this.root, key);
		TraversePostOrder (getRoot());
	}

	private StudentNode deleteNode(StudentNode root, int key){
		if (root == null) return null;
		// here you delete!
		if (key < root.getId())
			root.setLeft(deleteNode(root.getLeft(), key));
		else if(key > root.getId())
			root.setRight(deleteNode(root.getRight(), key));
		else {
			//leaf node
			if(root.getLeft() == null && root.getRight() == null) {
				root = null;
				return null;
			}
			// one child node. Right
			else if(root.getLeft() == null) {
				root = null;
				return root.getRight();
			}
			// one child node. Left
			else if(root.getRight() == null) {
				root = null;
				return root.getLeft();
			}
			//two child nodes..using right subtree min id
			else {
				StudentNode min = findMinimum(root.getRight());
				root.setId(min.getId());
				root.setName(min.getName());
				root.setRight(deleteNode(root.getRight(), min.getId()));
			}

		}
		return root;
		//return studentNode;
	}

	private StudentNode findMinimum(StudentNode rightNode) {
		if (rightNode==null)
			return null;
		else if(rightNode.getLeft() != null)
			return findMinimum(rightNode.getLeft());
		return rightNode;
	}


	public StudentNode getRoot() {
		return root;
	}

	public void setRoot(StudentNode root) {
		this.root = root;
	}
	
	

}
