package algorithms.recursion;

public class FindSubset {

	
	public static void main(String args[]){
		
	}
	
	
	String[] find_All_Subsets(String[] setArray,int subset_length){
		
		String[] subset_Array=new String[100];
		if(subset_length==1){
			for(int i=0;i<setArray.length;i++){
				subset_Array[i]=setArray[i];
			}
			return subset_Array;
		}else{
			subset_Array=find_All_Subsets(setArray, subset_length-1);
			
			
			
			
			
		}
		
		
		
		
		
		
		return null;
		
	}
	
}
