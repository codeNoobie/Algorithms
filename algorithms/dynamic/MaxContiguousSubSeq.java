package algorithms.dynamic;

public class MaxContiguousSubSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[]=new int[]{0,-2,11,-4,13,-5,2,-40,23};
		int n=A.length;

		int S[]=new int[n];
		int max=0;
		int k[]=new int[n];
		int l=0;

		for(int i=1;i<n;i++){

			if(A[i]+S[i-1]>=A[i]){
				S[i]=A[i]+S[i-1];
				if(i==1)
					k[i]=1;
				else 
					k[i]=k[i-1];
			}else{
				S[i]=A[i];
				k[i]=i;
			}

			if(max<S[i]){
				max=S[i];
				l=i;
			}

		}
		
		
		System.out.println("Max Value:"+max+" k:"+k[l]+" l:"+l);

	}

}
