package algorithms.dynamic;

public class KnapsackMidTermProb {


	public static void main(String args[]){

		int K=6;
		int n=5;
		int w[]=new int[]{0,5,4,3,2,4};
		int p[]=new int[]{0,4,2,4,1,5};


		int profit[][]=new int[n+1][K+1];
		int dir[][]=new int[n+1][K+1];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=n;j++)
				profit[i][j]=999999;
		}
int index=0;
System.out.println("Profit Array:");
		for(int i=1;i<=n;i++){
			for(int j=1;j<=K;j++){
			//	System.out.println(" i:"+" j:"+j+" w[i]:"+w[i]+" j-w[i] :"+(j-w[i]));
				index=j-w[i];
				if(index<0)
					index=0;
					profit[i][j]=	Math.min(	Math.min( profit[i-1][j] , p[i]+ profit[i-1][index])	,	p[i]+profit[i][index]);
			}
			for(int l=0;l<=K;l++){
				System.out.print("\t"+profit[i][l]);
			}
			System.out.println();
		}
		System.out.println("Profit:"+profit[n][K]);




	}

}
