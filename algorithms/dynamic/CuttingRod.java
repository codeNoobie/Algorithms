package algorithms.dynamic;
public class CuttingRod {

	static int profit[]=new int[100];	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int length[]=new int[100];
		int price[]=new int[100];
		length[0]=0;
		price[0]=0;
		int n=30;
		for(int i=1;i<=n+1;i++){
			length[i]=1;
			price[i]=price[i-1]+ 5%(i+1);
			//		System.out.println("price[i]:"+price[i]);
			/*for dynamic programming*/
			profit[i]=-999;
		}
		System.out.println("Input Size:"+n+"\n\n");
		System.out.println("/*Recursive solution*/");		
		long startTime=System.nanoTime();
		System.out.println("Max profit:"+recursiveRodCut(price,n+1));
		System.out.println("Nano time duration:"+(System.nanoTime()-startTime)+"\n");
		
		/*Dynamic Programming*/
		System.out.println("/*Top down Dynamic Programming*/");
		startTime=System.nanoTime();
		System.out.println("Max profit:"+topDownDynamicRodCut(price,n+1));
		System.out.println("Nano time duration:"+(System.nanoTime()-startTime)+"\n");
	
		System.out.println("/*Bottom UP Dynamic Programming*/");
		startTime=System.nanoTime();
		System.out.println("Max profit:"+bottomUpDynamicRodCut(price,n+1));
		System.out.println("Nano time duration:"+(System.nanoTime()-startTime));
		


	}
	static int bottomUpDynamicRodCut(int price[],int n){
		
		for(int i=1;i<=n;i++){
			profit[i]=-999;
		}
		int q=0;
		for(int j=1;j<n;j++){
			q=-999;
			for(int i=1;i<=j;i++){
				q= Math.max(q, price[i]+profit[j-i]);
			}
			profit[j]=q;
		}
		return profit[n-1];
		
	}

	static int topDownDynamicRodCut(int price[],int n){
		if(profit[n]>=0){
			return profit[n];
		}
		int q=-999;
		if(n==1){
			q=0;
		}else{	

			for(int i=1;i<n;i++){
				q=Math.max(q,price[i]+topDownDynamicRodCut(price, n-i));
			}
		}
		profit[n]=q;
		return q;



	}





	static	int recursiveRodCut(int price[],int n){

		if(n==1){
			return 0;
		}

		int q=-999;
		for(int i=1;i<n;i++){
			q=Math.max(q,price[i]+recursiveRodCut(price, n-i));
		}
		return q;
	}



}
