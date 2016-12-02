import java.lang.*;
import java.util.*;
public class LinkedList{
	private Node head;
	private int size;
	public LinkedList(){
		this.size = 0;
	}
	public void enqueue(int val){
		if(head == null){
			head = new Node(val);
			return;
		}
		Node temp = head;
		while(temp.getNext() != null){
			temp = temp.getNext();
		}
		temp.setNext(new Node(val));
	}
	public int getSize(){
		return size;
	}
	public void printList(){
		Node temp = head;
		while(temp != null){
			System.out.println("["+temp.getVal()+"] ");
			temp = temp.getNext();
		}
	}
	public void reverseList(){
		Node temp = head;
		recur(temp, 0);
	}

	private Node recur(Node parent, int counter){
		if(parent.getNext() == null){
			head = parent; //childless

			System.out.println("Setting head to: " + parent.getVal());
			return head;
		}
		else{
			Node child = parent.getNext();
			Node temp = recur(child, counter + 1);
			System.out.println(temp.getVal() + "->" + parent.getVal());
			temp.setNext(parent);
			if(counter == 0){
				parent.setNext(null);
			}
			return parent;
		}
	}
	public void removeDoubles(){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Node curr = head;
		Node next = curr.getNext();
		map.put(curr.getVal(), map.get(curr.getVal() + 1));
		while(next != null){
			int occ = map.get(curr.getVal());
			if(occ != 0){
				if(next.getNext() == null){
					curr.setNext(null);
				}
				else{
					curr.setNext(next.getNext());
				}
			}
			else{
				if(next.getNext() != null){
					curr = next;
					next = next.getNext();
				}
				else{
					break;
				}
			}
		}
	}
}