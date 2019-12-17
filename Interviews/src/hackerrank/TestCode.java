package hackerrank;


public class TestCode {

	String s = "";

	public TestCode() {
		
		System.out.println(appendEncounter("82736452367485987659"));
		
		
		s = "test";
		p("Contains:  ", s.contains("es"));
		p("Count:     ", countString(s,"t"));		
		p("HasPrefix: ", s.startsWith("te"));
		p("HasSuffix: ", s.endsWith("st"));
		p("Index:     ", s.indexOf("e"));
		p("Split:     ", s.split("a-b-c-d-e"));

	}

	private String appendEncounter(String fac){
		return fac.length()<20?"0"+fac:fac;
	}
	
	public void p(String a, Object b) {
		System.out.println(a + "\t" + b);
	}
	
	public int countString(String val, String comp){
		int count=0;
		for (int i=0; i<val.length(); i++){
			if (String.valueOf(val.charAt(i)).compareTo(comp)==0){
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		new TestCode();
	}
}
