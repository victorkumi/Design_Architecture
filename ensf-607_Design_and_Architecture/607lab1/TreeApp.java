//Victor Tuah Kumi
//Lab 1
package tree;

public class TreeApp {
	public static void main (String [] args) {
		
		System.out.println("Tree App");
		
		StudentTree myTree = new StudentTree();
		
		myTree.insert(new StudentNode ("Sarah", 10));
		myTree.insert(new StudentNode ("Bob", 5));
		myTree.insert(new StudentNode ("Sam", 2));

		myTree.insert(new StudentNode ("Joe", 7));

		myTree.insert(new StudentNode ("a", 17));
		myTree.insert(new StudentNode ("b", 12));
		myTree.insert(new StudentNode ("c", 20));
		
		/*System.out.println(myTree.getRoot());
		System.out.println(myTree.getRoot().getLeft());
		System.out.println(myTree.getRoot().getRight());*/
		myTree.printPreOrder ();
		System.out.println("------------");
		myTree.printInOrder();
		System.out.println("------------");
		myTree.printPostOrder();

		//Two ways to search for student by id. using id:5 as example
		int id = 5;
		System.out.println("Searching for details of student with id: " + id);
		StudentNode student = myTree.searchStudent(id);
		System.out.println(student + "\n");
		//Second method
		//System.out.println(myTree.searchStudent(5).getName());

		System.out.println("Deleted student with id: " + id);
		myTree.deleteStudent(id);
	}

}
