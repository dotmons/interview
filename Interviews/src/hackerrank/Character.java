package hackerrank;

public class Character {

	public Character(){
		
		for (int i=0; i<800; i++){
			
			System.out.println(i+">>>>>" + (char)i);
		}
		
	}
	
	public static void main(String[] args){
		new  Character();
	}
}
