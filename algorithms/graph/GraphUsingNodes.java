package algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.net.ssl.SSLEngineResult.Status;

public class GraphUsingNodes {
	private ArrayList<ArrayList<Node>> adjacencyList;	

	public GraphUsingNodes(int numofVertexs){
		this.adjacencyList=new ArrayList<ArrayList<Node>>();
		ArrayList<Node> nodeList;
		for(int i=0;i<numofVertexs;i++){
			nodeList=new ArrayList<Node>();
			nodeList.add(new Node(i+1));
			this.adjacencyList.add(nodeList);
		}
	}
	public static void main(String args[]){
		GraphUsingNodes graph= new GraphUsingNodes(5);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
	//	graph.addEdge(2, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 5);
		graph.addEdge(5, 4);
		graph.addEdge(5, 1);
	//	System.out.println(new Node(2).equals(new Node(2)));
		graph.printEdges(new Node(1));
		graph.printEdges(new Node(2));
		graph.printEdges(new Node(3));
		graph.printEdges(new Node(4));
		graph.printEdges(new Node(5));
		System.out.println("Path exists?"+graph.bfsSearch(5, 5));
	}

	public boolean addEdge(int v1Value,int v2Value){
		Node v1= new Node(v1Value);
		Node v2=new Node(v2Value);
		if(!(v2==null || v2==null)){
			ArrayList<Node> nodeList=getNodeList(v1);
			if(nodeList!=null){			
				if(!checkIfEdgeExist(nodeList,v2)){
					nodeList.add(v2);
				//	System.out.println("Added");
					return true;
				}
			}	
		}
		return false;
	}
	private boolean checkIfEdgeExist(ArrayList<Node> nodeList, Node v2) {
		// TODO Auto-generated method stub
		int size=nodeList.size();
	//	System.out.println("11");
		if(size>1){
			for(int i=1;i<size;i++){
				if(nodeList.get(i).equals(v2)){
		//			System.out.println("2");
					return true;
				}
			}		
		}
		return false;
	}

public boolean bfsSearch(int start,int end){
	
	ArrayList<Node> nodelist=this.getNodeList(new Node(start));
	Node startVertex;
	Node endVertex;
	if(nodelist!=null){
		 startVertex=nodelist.get(0);
	}else {
		return false;
	}
	
	nodelist=this.getNodeList(new Node(end));
	if(nodelist!=null){
		endVertex=nodelist.get(0);
	}else {
		return false;
	}
	
	Queue<Node> bfsQueue=new LinkedList<Node>();
	
	bfsQueue.offer(startVertex);
	
	Node temp=null;
	while(!bfsQueue.isEmpty()){
		temp=bfsQueue.poll();
		temp.setNodeStatus("visiting");
		nodelist=this.getNodeList(temp);
		Node tempAdjacentNode;
		for(int i=1;i<nodelist.size();i++){
			tempAdjacentNode=nodelist.get(i);
			if(tempAdjacentNode.getNodeStatus().equals("notvisited") ){
				if(tempAdjacentNode.equals(endVertex)){
					return true;
				}
				bfsQueue.offer(tempAdjacentNode);
			}
		
		}
		temp.setNodeStatus("visited");
	}
	
	return false;
}
	public void printEdges(Node v1){
		if(v1!=null){
			ArrayList<Node> nodeList=getNodeList(v1);
			int size=nodeList.size();
			for(int i=1;i<size;i++){
				System.out.println("<"+v1.getValue()+","+nodeList.get(i).getValue()+">"+" s:"+size);
			}

		}
	}



	private ArrayList<Node> getNodeList(Node v1){
		ArrayList<Node> nodeList;
		for(int i=0;i<this.adjacencyList.size();i++){
			nodeList=this.adjacencyList.get(i);
			Node node=nodeList.get(0);
			if(node!=null&&node.equals(v1)){
				return nodeList;
			}

		}
		return null;
	}



}


class Node {
	private int value;
	private status nodeStatus;
	private enum status {notvisited, visiting, visited};

	public Node(int value){
		this.value=value;
		this.nodeStatus=status.notvisited;
	}

	public boolean equals(Object v2){
		if(v2!=null &&(v2 instanceof Node)){
			Node v2Temp=(Node)v2;
			if(this.value==v2Temp.getValue()){
				return true;
			}
		}
		return false;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getNodeStatus() {
		if(this.nodeStatus==status.notvisited)
			return "notvisited";
		else if(this.nodeStatus==status.visiting)
			return "visiting";
		else 
			return "visited";
		
	}

	public void setNodeStatus(String statusString) {
		if(statusString.equals("notvisited"))
			this.nodeStatus=status.notvisited;
		else if(statusString.equals("visiting"))
			this.nodeStatus=status.visiting;
		else if(statusString.equals("visited"))
			this.nodeStatus=status.visited;
	}


}
