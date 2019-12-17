package hackerrank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Localtest {
	
	public Localtest(){
		//System.out.println(removeForwardSlashFromScript("begin  pkg_load_nrs_fiscal_data.load_cost_weight_file(p_fiscal_year => 2017, p_weight_file_name => 'NRS_RPG_COST_WEIGHT.csv'); pkg_load_nrs_fiscal_data.update_weight_file_codes; end; /"));
		
		LocalDateTime now = LocalDateTime.now();		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        System.out.println(now.format(formatter));
        //LocalDateTime formatDateTime = LocalDateTime.parse(now.toString(), formatter);
        //System.out.println("Before : " + now);
        //System.out.println("After : " + formatDateTime);
	}
	
	private String removeForwardSlashFromScript(String scriptvalue){
		
		String tempVal = scriptvalue.substring(scriptvalue.length()-3, scriptvalue.length());
		System.out.println("<<<<<<<<<<>>>>>>>>>>>");
		System.out.println(tempVal);
		System.out.println("<<<<<<<<<<>>>>>>>>>>>");
		if (tempVal.contains("/")){
			return scriptvalue.substring(0, scriptvalue.length()-3) + tempVal.replace("/", "");
		}
		return scriptvalue;
	}
	
	public static void main(String[] args){
		Localtest ll = new Localtest();
	}

}
