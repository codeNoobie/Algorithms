package algorithms.dynamic;

import java.util.ArrayList;
import java.util.List;

public class CurrencyExchange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//4 currency, 
		double r[][]=new double[][]{
				{0,	0,	0,	0,	0},
				{0,	0,	1.2,	2,	3},
				{0,	1.0/1.2,	0,	5,	6},
				{0,	1.0/2.0,	1.0/5.0,	0,	9},
				{0,	1.0/3.0,	1.0/6.0,	1.0/9.0,	0}
		};

		int rows=r.length;
		int cols=r[0].length;
		double optimalConversion[][]=new double [rows][cols];
		int direction[][]=new int[rows][cols];
		List<Integer> currencyList=new ArrayList<Integer>();
currencyList.add(1);currencyList.add(2);currencyList.add(3);currencyList.add(4);
		double maxVal=-999;
		int k=0;
		for(int i=1;i<rows;i++){
			for(int j=1;j<cols;j++){
				if(i==j){
					optimalConversion[i][j]=0;
					continue;
				}
					
				maxVal=r[i][j];
				k=1;
				currencyList.remove(new Integer(i));
				currencyList.remove(new Integer(j));
				while(k<cols){
					if(k!=i&&k!=j){
						if(Math.max(maxVal,optimalConversion[i][k]*optimalConversion[k][j])>=maxVal){
							direction[i][j]=k;
							maxVal=Math.max(maxVal,optimalConversion[i][k]*optimalConversion[k][j]);
						}

					}

					k++;
				}

				optimalConversion[i][j]=maxVal;
			}

		}

//		System.out.println("Currency 3 to 2.... R32:"+r[3][2]+" optimalConversion:"+optimalConversion[3][2]);
System.out.println("R array");
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				System.out.print(" "+r[i][j]);
			}
			System.out.println(); 

		}
		System.out.println("OptimalConv");
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				System.out.print(" "+optimalConversion[i][j]);
			}
			System.out.println(); 

		}
		
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				System.out.print(" "+direction[i][j]);
			}
			System.out.println(); 

		}
	}
}
