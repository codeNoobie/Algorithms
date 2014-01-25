package algorithms.dynamic;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> fibo=new ArrayList<Integer>();
		
		fibo.add(0);
		fibo.add(1);
		int i=2;
		System.out.print(" "+fibo.get(0));
		System.out.print(" "+fibo.get(1));
		
		while(i<30){
			fibo.add(fibo.get(i-1)+fibo.get(i-2));
			System.out.print(" "+fibo.get(i));
			i++;
			
			
		}
		
		
		
		
	}

}
