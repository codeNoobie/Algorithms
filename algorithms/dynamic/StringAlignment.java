package algorithms.dynamic;

public class StringAlignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	String X="ACTCG";
	String Y="CAGTG";
	int m=X.length();
	int n=Y.length();
	int c[][]= new int[m+1][n+1];
	int b[][]=new int[m+1][n+1];
	
	
	for(int i=1;i<=m;i++){
		for(int j=1;j<=n;j++){
			if(X.charAt(i-1)==Y.charAt(j-1)){
				c[i][j]=c[i-1][j-1]+1;//For string alignment , "1" should be replaced by the score 
				b[i][j]=1;
			}else if(c[i-1][j]>=c[i][j-1]){
				c[i][j]=c[i-1][j];
				b[i][j]=2;
			}else{
				c[i][j]=c[i][j-1];
				b[i][j]=3;
			}
			System.out.print("\t"+c[i][j]);
		}
		System.out.println();
	}
	
	printLCS(b,X,m,n);

	
		
	}
static void printLCS(int b[][],String X, int i, int j){
		
		if(i==0&&j==0){
			return ;
		}
		
		if(b[i][j]==1){
			printLCS(b, X, i-1, j-1);
			System.out.print(X.charAt(i-1));
		}else if(b[i][j]==2){
			printLCS(b, X, i-1, j);
		}else if(b[i][j]==3){
			printLCS(b, X, i, j-1);
		}
	}

	
	
}
