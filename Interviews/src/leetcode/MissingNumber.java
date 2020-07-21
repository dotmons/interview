package leetcode;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {

	public MissingNumber() {
		int n[] = { 3, 0, 1 };
		//System.out.println(missingNumber(n));
		System.out.println(missingNumberAdvance(n));
	}

	public int missingNumber(int[] nums) {

		Set<Integer> tset = new TreeSet<Integer>();

		for (int n : nums) {
			tset.add(n);
		}
		Iterator<Integer> value = tset.iterator();
		int n = 0;
		while (value.hasNext()) {
			int nv = value.next();
			if (n++ != nv) {
				return nv-1;
			}
		}

		return -1;
	}
	
    public int missingNumberAdvance(int[] nums) {    
		
        int sum = 0;
        int cal = 0;
        for (int n : nums){
            sum += n;
        }
        
        //cal = ((nums.length+1)/2)*((nums.length-1));
        cal = (nums.length*(nums.length-1)/2)-sum;
        
		return cal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingNumber missingNumber = new MissingNumber();
	}

}
