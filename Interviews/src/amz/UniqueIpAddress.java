package amz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UniqueIpAddress {

	String[] ipadd = { "205.251.241.103", "104.36.196.223", "151.101.40.116", "205.251.241.103", "104.196.174.50",
			"52.205.157.89", "205.251.241.103", "151.101.40.116" };

	List<String> ips = new ArrayList<String>();


	public UniqueIpAddress() {
		
		for (String d : ipadd) {
			ips.add(d);
		}
		System.out.println(removeDuplicateIP(ips));

	}

	public List<String> removeDuplicateIP(List<String> ips) {
		HashSet<String> setter = new HashSet<String>();
		for (String la : ips) {
			setter.add(la);
		}
		
		return new ArrayList<String>(setter);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UniqueIpAddress();

	}

}
