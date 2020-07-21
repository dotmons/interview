package sample;

public class JavaByValue {

	private int n;

	public JavaByValue(){
		
		n = 200;
		updateInteger(n);
		
		System.out.println(n);
	}
	
	void updateInteger(int n){
		this.n = n * 500;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JavaByValue();
	}

}
