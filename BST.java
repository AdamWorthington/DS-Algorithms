import java.util.*;

public class BST{
	
	private Node head;

	public void enqueue(int i){
		Node curr = head;
		if(head == null){
			head = new Node(i);
			return;
		}
		enqueueHelper(curr, i);
	}

	private void enqueueHelper(Node curr, int i){
		if(curr.getVal() >= i){ //Left leaning BST
			Node temp = curr.getLeft();
			if(temp != null){
				enqueueHelper(temp, i);
			}
			else{
				curr.setLeft(new Node(i));
			}
		}
		else{
			Node temp = curr.getRight();
			if(temp != null){
				enqueueHelper(temp, i);
			}
			else{
				curr.setRight(new Node(i));
			}
		}
	}

	public void printBST(){
		printBSTHelper(head);
	}

	private void printBSTHelper(Node curr){
		int val = curr.getVal();
		Node left = curr.getLeft();
		Node right = curr.getRight();
		if(left != null){
			System.out.println(val + " has left child: " + left.getVal());
			printBSTHelper(left);
		}
		if(right != null){
			System.out.println(val + " has right child: " + right.getVal());
			printBSTHelper(right);
		}
		if(left == null && right == null){
			System.out.println(val + " is a leaf");
		}
	}
	private int currIter = 1;

	public void findBFS(int i){
		if(head.getVal() == i){
			System.out.println("Found [" + i + "] after " + currIter + " nodes were searched in 1 iteration BFS.");
			return;
		}
		ArrayList<Node> al = new ArrayList<Node>();
		al.add(head);
		BFSHelper(al, i, 1);
		currIter = 1;
	}

	private void BFSHelper(ArrayList<Node> curr, int i, int iter){
		int iterparam = iter+1;
		if(curr.isEmpty()){
			System.out.println("Couldn't find " + i + " in BST using BFS.");
			return;
		}
		ArrayList<Node> al = new ArrayList<Node>();
		for(Node n : curr){
			Node left = n.getLeft();
			Node right = n.getRight();
			if(left != null){
				currIter++;
				if(left.getVal() == i){
					System.out.println("Found [" + i + "] after " + currIter + " nodes were searched in " + iterparam +" iterations BFS.");
					return;
				}
				else{
					al.add(left);
				}
			}
			if(right != null){
				currIter++;
				if(right.getVal() == i){
					System.out.println("Found [" + i + "] after " + currIter + " nodes were searched in " + iterparam +" iterations BFS.");
					return;
				}
				else{
					al.add(right);
				}
			}
		}
		BFSHelper(al, i, iterparam);
	}

	public void findDFS(int i){
		if(head.getVal() == i){
			System.out.println("Found [" + i + "] as head after " + currIter + " nodes were searched in DFS.");
		}
		DFSHelper(head, i);
		currIter = 1;
	}

	private void DFSHelper(Node curr, int i){
		currIter++;
		int val = curr.getVal();
		Node left = curr.getLeft();
		Node right = curr.getRight();
		if(left != null){
			if(left.getVal() == i){
				System.out.println("Found [" + i + "] as left child of [" + val + "] after " + currIter + " nodes were searched in DFS.");
				return;
			}
			DFSHelper(left, i);
		}
		if(right != null){
			if(right.getVal() == i){
				System.out.println("Found [" + i + "] as right child of [" + val + "] after " + currIter + " nodes were searched in DFS.");
				return;
			}
			DFSHelper(right, i);
		}
		if(left == null && right == null){
			return;
		}
	}
}