package algorithms.dynamic;

public class MatrixChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int dimensions[]=new int[]{1,2,4,6,4,2,1};
		
		int m[][]=new int[dimensions.length][dimensions.length];
		int s[][]=new int[dimensions.length][dimensions.length];
		int n=dimensions.length-1;
		
		int j=0;
		int q=0;
		for(int l=2;l<=n;l++){			
			for(int i=1;i<=n-l+1;i++){				
				j=i+l-1;
				m[i][j]=9999999;
				System.out.println("\n----------------------i:"+i+" j:"+j+" l="+l+"------------------------");
				for(int k=i;k<=j-1;k++){
					q=m[i][k]+m[k+1][j]+dimensions[i-1]*dimensions[k]*dimensions[j];
					if(q<m[i][j]){
						m[i][j]=q;
						s[i][j]=k;
					}
					System.out.println(" k:"+k+" m["+i+"]["+j+"] ="+" m["+i+"]["+k+"]+"+" m["+(k+1)+"]["+j+"] + "+dimensions[i-1]+" * "+dimensions[k]+" * "+dimensions[j]+" = "+m[i][k]+"+"+m[k+1][j]+"+"+dimensions[i-1]*dimensions[k]*dimensions[j]+" = "+q+"-----> m[i][j]:"+m[i][j]);
					
							
				}
				System.out.println("\n----------------------i:"+i+" j:"+j+" l="+l+"------------------------");
				
				
			}			
		}
		System.out.println("---------------------m array start-------------------------");
		for(int i=1;i<=n;i++){
			for(j=1;j<=n;j++){
				System.out.print(m[i][j]+"\t");
			}
				System.out.println();
			}
		System.out.println("---------------------m array end-------------------------");
			
		System.out.println("---------------------s array start-------------------------");
		for(int i=1;i<=n;i++){
			for(j=1;j<=n;j++){
				System.out.print(s[i][j]+"\t");
			}
				System.out.println();
			}
		System.out.println("---------------------s array end-------------------------");
			
		System.out.println("Optimal parenthesization");
		printOptimalParenthesis(s,1,n);
		
		
		
		
		
	}

	private static void printOptimalParenthesis(int[][] s, int i, int j) {
		// TODO Auto-generated method stub
		
		if(i==j)
			System.out.print("A"+i);
		else{
			System.out.print("(");
			printOptimalParenthesis(s, i, s[i][j]);

			printOptimalParenthesis(s, s[i][j]+1,j );
			System.out.print(")");
		}
			
	}

}
