package hackerrank;

import java.math.BigInteger;

public class FactorialLarge {

	public FactorialLarge(){
		System.out.println(solveFact(25));
	}
	
	static void extraLongFactorials(int n) {
		solveFact(n);
    }

	public static BigInteger solveFact(int n){
		if (n==0)
			return new BigInteger("1");
		return new BigInteger(String.valueOf(n)).multiply(solveFact(n-1));
	}
	
	public static void main(String[] args){
		FactorialLarge fl = new FactorialLarge();
	}
}
