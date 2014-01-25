package datastructure;

import java.util.ArrayList;

public class Stack<E> {

	private ArrayList<E> stackArray=new ArrayList<E>();
	private int top=-1;
	
	
	public void push(E element){
		stackArray.add(element);		
		top++;
//		System.out.println("Element Pushed:"+element+" top:"+top);
	}
	
	public E pop(){
		if(top!=-1){
			E element=stackArray.remove(top);
			top--;
		//	System.out.println("Element Popped:"+element);
			return element;
		}else{
			//stack is empty
			return null;
		}
	}
	
	public boolean isEmpty(){
		if(top==-1){
			return true;
		}else{
			return false;
		}
	}
	
	public void printElements(){
		for(int index=stackArray.size()-1;index>=0;index--)
			System.out.println(stackArray.get(index));
		
	}
	
	
	
}
