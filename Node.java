public class Node{ //Generic used for LL and BST implementations
	private Node next;
	private Node left;
	private Node right;
	private int val;
	public Node(int i){
		this.val = i;
	}
	public void setNext(Node n){
		next = n;
	}
	public void setInt(int i){
		val = i;
	}
	public void setLeft(Node n){
		left = n;
	}
	public void setRight(Node n){
		right = n;
	}
	public Node getLeft(){
		return left;
	}
	public Node getRight(){
		return right;
	}
	public Node getNext(){
		return next;
	}
	public int getVal(){
		return val;
	}
}