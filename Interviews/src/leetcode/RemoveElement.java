package leetcode;

public class RemoveElement {

	public RemoveElement(){
		int nums[] = {3,2,2,3};
		System.out.println(removeElement(nums, 2));
	}
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int n: nums){
            if (n!=val){
                count++;
            }
        }
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveElement removeElement = new RemoveElement();
	}

}
