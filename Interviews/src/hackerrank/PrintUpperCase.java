package hackerrank;

public class PrintUpperCase {

	public PrintUpperCase() {
		
	
		
		String s = "steganograpHy is the practicE of conceaLing a file, message, image, or video within another fiLe, message, image, Or video.";

		for (char i : s.toCharArray()) {
			if (((char) i >= 65) && ((char) i <= 91)) {
				// if
				// (String.valueOf(i).toUpperCase().equals(String.valueOf(i).trim()))
				// {
				//System.out.print(i);
				// }
			}
		}

		System.out.println("Hwwwi");
		String x = "P";
		String y = "P";
		System.out.println(x == y);

	}

	public static void main(String[] args) {
		PrintUpperCase pu = new PrintUpperCase();
	}
}
