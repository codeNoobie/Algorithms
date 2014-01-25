package datastructure;

import java.util.LinkedList;

public class Queue<E> {
	
	
	public Queue(){
		
	}
	
	
	private LinkedList<E> queueList=new LinkedList<E>();
	private int head=-1;
	private int tail=-1;
	
	public void enqueue(E element){
		//for static, shd check for queue full condition
		tail++;
		queueList.add(tail, element);
//		System.out.println("Element Added:"+element+" current head:"+head+" current tail:"+tail);
	}
	public E dequeue(){
		//check for is empty
		if(!isEmpty()){
			head++;
			E element=queueList.get(head);
		//	System.out.println("Element removed:"+element+" current head:"+head+" current tail:"+tail);

			return element;
		}else{
			return null;
		}
	}
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(head==tail){
			return true;
		}else 		
		return false;
	}
	public int size() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			return 0;
		}else{
			return tail-head;
		}
		
	}

}
