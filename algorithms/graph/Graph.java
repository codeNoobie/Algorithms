package algorithms.graph;

import java.util.ArrayList;

import datastructure.Queue;
import datastructure.Stack;

public class Graph {
	private int numOfVertexs;
	//	private int adjacencyMatrix[][];
	private  ArrayList<ArrayList<Integer>> adjacencyList;
	
	public Graph(int numOfVertexs){
		this.numOfVertexs=numOfVertexs;
		//	adjacencyMatrix=new int[numOfVertexs+1][numOfVertexs+1];
		Runtime.getRuntime().gc();
		adjacencyList=new ArrayList<ArrayList<Integer>>();
		adjacencyList.add(new ArrayList<Integer>());
		for(int i=1;i<=this.numOfVertexs;i++){
			ArrayList<Integer> vertexEdgeList=new ArrayList<Integer>();
			//vertexEdgeList.add(new Vertex(i));
			vertexEdgeList.add(i);

			adjacencyList.add(vertexEdgeList);
			
		}
	}


	public void addEdge(int v1, int v2){		
		ArrayList<Integer> edgeListV1=adjacencyList.get(v1);
		ArrayList<Integer> edgeListV2=adjacencyList.get(v2);
		edgeListV1.add(edgeListV2.get(0));
	}


	public int getInDegree(int v1){
		return 0;
	}
	public int getOutDegree(int v1){
		return 0;
	}

	public void printGraph(){
		System.out.println("-------------------------------------------");
		for(int i=1;i<=this.numOfVertexs;i++){
			ArrayList<Integer> edgeList=this.adjacencyList.get(i);
			System.out.print(edgeList.get(0)+"->");
			for(int j=1;j<edgeList.size();j++){
				System.out.print(" "+edgeList.get(j));
			}
			System.out.println("");
		}
		System.out.println("-------------------------------------------");

	}


	public void BFSSearch(int startNode)	{

		int pie[]= new int[this.adjacencyList.size()];
		int distance[]= new int[this.adjacencyList.size()];
		int color[]= new int[this.adjacencyList.size()];
		for(int i=1;i<this.adjacencyList.size();i++){


			pie[i]=-1;
			distance[i]=99999;
			color[i]=1;
		}

		ArrayList<Integer> edgeListStartingNode=adjacencyList.get(startNode);	
		color[startNode]=2;
		distance[startNode]=0;
		pie[startNode]=-1;

		Queue<Integer> vertexQueue=new Queue<Integer>();

		vertexQueue.enqueue(startNode);
		Integer currentVertex;
		while(!vertexQueue.isEmpty()){
			currentVertex=vertexQueue.dequeue();		
			System.out.println("------------------------------------------");
			System.out.print("\n Processing Vertex "+currentVertex+":");
			ArrayList<Integer> edgeListCurrentVertex=adjacencyList.get(currentVertex);
			int adjacentVertex;
			//		System.out.println(" New Vertex added:");
			for(int i=1;i<edgeListCurrentVertex.size();i++){
				adjacentVertex=edgeListCurrentVertex.get(i);
				if(color[adjacentVertex]==1){
					color[adjacentVertex]=2;
					distance[adjacentVertex]=distance[currentVertex]+1;
					pie[adjacentVertex]=currentVertex;
					vertexQueue.enqueue(adjacentVertex);
					System.out.print(" "+adjacentVertex);

				}

			}

			color[currentVertex]=3;	
			for(int j=1;j<distance.length;j++)
				System.out.print(" "+distance[j]);
			System.out.println();
			System.out.println("------------------------------------------");

		}	

	}

	public void DFSSearch(int startNode)	{

		int pie[]= new int[this.adjacencyList.size()];
		int distance[]= new int[this.adjacencyList.size()];
		int color[]= new int[this.adjacencyList.size()];
		int finalval[]=new int[this.adjacencyList.size()];
		Integer time=new Integer(0);
		for(int i=1;i<this.adjacencyList.size();i++){
			pie[i]=-1;
			distance[i]=99999;
			color[i]=1;
		}
		DFS_visit(startNode, pie, color, distance, finalval, time);
		
		for(int j=1;j<distance.length;j++)
			System.out.print(" ("+distance[j]+","+finalval[j]+")");
	}	



	void DFS_visit(int currentVertex,int pie[], int color[], int distance[], int finalVal[], Integer time){
		System.out.println("----------------------currentVertex:"+currentVertex+"--------------------");
		
		time=time+1;
		
		distance[currentVertex]=time;
		color[currentVertex]=2;

		ArrayList<Integer> edgeListCurrentVertex=adjacencyList.get(currentVertex);
		int adjacentVertex;

		for(int i=1;i<edgeListCurrentVertex.size();i++){
			adjacentVertex=edgeListCurrentVertex.get(i);
		//	System.out.println("adjacentVertex:"+adjacentVertex);
			if(color[adjacentVertex]==1){
				pie[adjacentVertex]=currentVertex;
		//		System.out.println("inside");
				DFS_visit(adjacentVertex, pie, color, distance, finalVal, time);
			}
		}
		color[currentVertex]=3;	
		time=time+1;
		finalVal[currentVertex]=time;
/*		for(int j=1;j<distance.length;j++)
			System.out.print(" ("+distance[j]+","+finalVal[j]+")");
		System.out.println();
*/		System.out.println("-----------------------------------------------------------------------------");


	}


	public void createAnyGraph(){		
		this.addEdge(1,2);this.addEdge(1,5);
		this.addEdge(2,1);this.addEdge(2,5);this.addEdge(2,3);this.addEdge(2,4);
		this.addEdge(3,2);this.addEdge(3,4);
		this.addEdge(4,2);this.addEdge(4,5);this.addEdge(4,3);
		this.addEdge(5,4);this.addEdge(5,1);this.addEdge(5,2);	
		this.printGraph();

	}
}

class Vertex{

	//private Enum color=new Enum{"White","Grey","Black"}();
	private int vertexNum;
	private int color=1;
	public Vertex(int vertexNum){
		this.vertexNum=vertexNum;

	}
	public String toString(){
		return Integer.toString(vertexNum);
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
}