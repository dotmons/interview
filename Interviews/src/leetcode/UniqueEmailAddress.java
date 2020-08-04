package leetcode;

import java.util.HashSet;

public class UniqueEmailAddress {

	public UniqueEmailAddress() {
		// TODO Auto-generated constructor stub
		String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com" };

		System.out.println(numUniqueEmails(emails));
	}

	public int numUniqueEmails(String[] emails) {

		

		HashSet<String> emailSet = new HashSet<String>();

		for (String email : emails) {
			StringBuilder sb = new StringBuilder("");
			StringBuilder sbvalue = new StringBuilder("");

			sb.append(email.substring(0, email.indexOf("@")).replaceAll("\\.", ""));

			sbvalue.append(sb.toString().contains("+") ? sb.toString().substring(0, sb.toString().indexOf("+"))
					: sb.toString());
			sbvalue.append(email.substring(email.indexOf("@")));
			emailSet.add(sbvalue.toString());

		}

		return emailSet.size();
	}

	public static void main(String[] args) {
		UniqueEmailAddress uniqueEmailAddress = new UniqueEmailAddress();
		// TODO Auto-generated method stub

	}

}
