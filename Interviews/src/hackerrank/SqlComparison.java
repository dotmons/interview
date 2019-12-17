package hackerrank;

import java.util.ArrayList;
import java.util.Collections;

public class SqlComparison {

	public SqlComparison() {
		DatabaseApi api = new DatabaseApi();

		String cmdb_organization = api.fileinputstream("C:\\Users\\OAdeoye\\cmdb_organization.tsv");
		String cmdb_organization_base = api.fileinputstream("C:\\Users\\OAdeoye\\cmdb_organization_base.tsv");

		//System.out.println(cmdb_organization_base);
		
		ArrayList<String> cmdb = new ArrayList<String>();
		ArrayList<String> cmdb_base = new ArrayList<String>();
		
				
		for (String ll : cmdb_organization.split("\n")) {
			cmdb.add(ll);
		}
		
		for (String ee : cmdb_organization_base.split("\n")) {
			cmdb_base.add(ee);
		}
		//Collections.sort(cmdb);
		//Collections.sort(cmdb_base);
		
		
		System.out.println("cmdb size : " + cmdb.size());
		System.out.println("cmdb_base size : " + cmdb_base.size());
		
		boolean kdk = false;
		
		for (int i=0; i<cmdb_base.size(); i++){
			kdk = false;
			
			for (int k=0; k<cmdb.size(); k++){
				if (cmdb_base.get(i).equals(cmdb.get(k))){
					kdk = true;
				}
			}
			
			if (!kdk){
				System.out.println(i + ">>"+cmdb_base.get(i));
			}
		}
	}

	public static void main(String[] args) {
		SqlComparison son = new SqlComparison();
	}
}
