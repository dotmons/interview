package hackerrank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class ScriptGenerator {

	DatabaseApi api = new DatabaseApi();

	public String getData(String file) throws IOException {
		// read file into stream, try-with-resources
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String currentLine = reader.readLine();

			StringBuilder builder = new StringBuilder();
			while (currentLine != null) {
				builder.append(currentLine);
				builder.append("\n");
				currentLine = reader.readLine();
			}
			reader.close();
			return builder.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public ScriptGenerator() throws Exception {

		// generateDadScript();
		// generateDadUpdateScript();
		// updateHmhdbScript();
		generateScript();

	}

	/*	
			 update mh_reg_estimates
				set health_region = ‘Eastern Health’,
				health_region_f = ‘Eastern Health’
				where health_region_code = 1011
				and fiscal_year = 2003
	*/

	public void generateScript() throws IOException {
		String path = "C:\\Users\\OAdeoye\\export.dsv";
		String addition = "	01	SACTYPE	1740fd33	CSIZEMIZ	QAIPPE	QNIPPE	CSDuid	CMA	PATIENT_REGION";
		StringBuilder ff = new StringBuilder();
		String output = getData(path);
		for (String df : output.split("\n")) {
			ff.append(df + addition + "\n");
		}
		
		api.fileoutputstream(ff.toString(), "C:\\Users\\OAdeoye\\output.txt");
		
	}

	public void updateHmhdbScript() throws IOException {

		String path = "\\\\torfs01\\user\\Groups\\EDW Services\\620 Systems Development & Maintenance\\Quick Stats\\IMT4 QnA Project\\QS Upgrade and backup\\HMHDB\\";

		String regionCode = getData(path + "REGION_CHECKER.txt");
		String regionCheckerCode = getData(path + "REGION_CODE.txt");
		String regionDescFr = getData(path + "REGION_DESC_FR.txt");

		ArrayList<String> regionCodeList = new ArrayList<>();
		ArrayList<String> regionCheckerCodeList = new ArrayList<>();
		ArrayList<String> regionDescFrlList = new ArrayList<>();

		for (String liner : regionCode.split("\n")) {
			regionCodeList.add(liner.replaceAll("\n", "").replaceAll("\r", ""));
		}

		for (String liner : regionCheckerCode.split("\n")) {
			regionCheckerCodeList.add(liner.replaceAll("\n", "").replaceAll("\r", ""));
		}

		for (String liner : regionDescFr.split("\n")) {
			regionDescFrlList.add(liner.replaceAll("\n", "").replaceAll("\r", ""));
		}

		String total = "";
		String checker = "";
		String tableName = "MH_REG_WS1";

		for (String regionValue : regionCheckerCode.split("\n")) {
			int i = 0;
			for (String regionValueCode : regionCodeList) {
				if (regionValue.equals(regionValueCode)) {

					total += "update qsprod.MH_REG_WS4 set health_region_f = (select unique(health_region_f) from qsprod.MH_REG_WS4 where health_region_code = '"
							+ regionCodeList.get(i) + "' and fiscal_year = '2016') where health_region_code = '"
							+ regionCodeList.get(i) + "' and fiscal_year = '2017';\n\n";

					checker += "select count(unique(health_region_f)) from qsprod.MH_REG_WS4 where health_region_code = '"
							+ regionCodeList.get(i) + "' and fiscal_year in (2016,2017);\n\n";
				}
				i++;
			}
		}

		total += "\nCOMMIT;";

		api.fileoutputstream(total, path + "health_region_f_update" + tableName + ".sql");
		api.fileoutputstream(checker, path + "checker_health_region_f_update" + tableName + ".sql");
		byte[] charset = total.getBytes("UTF-32");
		String result = new String(charset, "UTF-32");
		System.out.println(total);

	}

	public void generateCmdbScript() throws IOException {
		String path = "\\\\torfs01\\user\\Groups\\EDW Services\\620 Systems Development & Maintenance\\Quick Stats\\IMT4 QnA Project\\QS Upgrade and backup\\HMHDB\\";

		String fiscalYear = getData(path + "FISCALYEAR.txt");
		String regionCode = getData(path + "REGION_CODE.txt");
		String regionDesc = getData(path + "REGION_DESC.txt");
		String regionDescFr = getData(path + "REGION_DESC_FR.txt");

		// System.out.println(regionDesc);

		/*
		 *
		 * */
		ArrayList<String> fiscalYearList = new ArrayList<>();
		ArrayList<String> regionCodeList = new ArrayList<>();
		ArrayList<String> regionDescList = new ArrayList<>();
		ArrayList<String> regionDescFrlList = new ArrayList<>();

		for (String liner : fiscalYear.split("\n")) {
			fiscalYearList.add(liner.replaceAll("\n", "").replaceAll("\r", ""));
		}

		for (String liner : regionCode.split("\n")) {
			regionCodeList.add(liner.replaceAll("\n", "").replaceAll("\r", ""));
		}

		for (String liner : regionDesc.split("\n")) {
			regionDescList.add(liner);
			// System.out.println(liner);
		}

		for (String liner : regionDescFr.split("\n")) {
			regionDescFrlList.add(liner.replaceAll("\n", "").replaceAll("\r", "").replaceAll("'", "''"));
		}

		String total = "";
		String tableName = "MH_REG_WS4";
		for (int i = 0; i < 90; i++) {
			// System.out.println(regionDescList.get(i));
			total += ("update " + tableName + " set health_region = '" + regionDescList.get(i)
					+ "',  health_region_f = '" + regionDescFrlList.get(i) + "' " + " where health_region_code = '"
					+ regionCodeList.get(i) + "' and fiscal_year >= '" + fiscalYearList.get(i) + "'" + ";\n\n");
		}
		total += "\nCOMMIT;";
		api.fileoutputstream(total, path + "update_" + tableName + ".sql");
		byte[] charset = total.getBytes("UTF-32");
		String result = new String(charset, "UTF-32");
		System.out.println(total);
	}

	private void generateDatScriptUpdates() throws Exception {

		String path = "\\\\torfs01\\user\\Groups\\EDW Services\\620 Systems Development & Maintenance\\Quick Stats\\IMT4 QnA Project\\QS Upgrade and backup\\DADQS\\";

		String fiscalYear = "2001-2002";
		String rate = getData(path + fiscalYear + ".txt");
		String healthRegionYear = getData(path + "Health_Region_Year.txt");

		ArrayList<String> rateList = new ArrayList<>();
		ArrayList<String> healthRegionYearlList = new ArrayList<>();

		for (String liner : rate.split("\n")) {
			rateList.add(liner.replaceAll("\n", "").replaceAll("\r", "").replaceAll("'", "''"));
		}

		for (String liner : healthRegionYear.split("\n")) {
			healthRegionYearlList.add(liner.replaceAll("\n", "").replaceAll("\r", "").replaceAll("'", "''"));
		}

		String total = "";
		String tableName = "CHILDBIRTH_REGIONAL" + fiscalYear;
		for (int i = 0; i < 117; i++) {
			String healthReg = healthRegionYearlList.get(i);
			// total += ("update CHILDBIRTH_REGIONAL set rate = '" +
			// rateList.get(i)
			// + "', rate_f_desc = '" + rateList.get(i).replace(".", ",") + "' "
			// + " where health_region_code = '" +
			// healthReg.substring(healthReg.indexOf("(")+1,
			// healthReg.lastIndexOf(")") + "' and fiscal_year = '"
			// + commentList.get(i) + "-" +
			// (Integer.parseInt(commentList.get(i))+1) +"'" + ";\n\n");

		}
		total += "\nCOMMIT;";
		api.fileoutputstream(total, path + "update_" + tableName + ".sql");
		System.out.println(total);

	}

	public void generateDadScript() throws Exception {

		String path = "\\\\torfs01\\user\\Groups\\EDW Services\\620 Systems Development & Maintenance\\Quick Stats\\IMT4 QnA Project\\QS Upgrade and backup\\DADQS\\";

		String healthRegion = getData(path + "HEALTH_REGION.txt");
		String healthRegionF = getData(path + "HEALTH_REGION_F_DESC.txt");
		String comment = getData(path + "COMMENT.txt");
		String regionCode = getData(path + "REGION_CODE.txt");

		ArrayList<String> regionDescList = new ArrayList<>();
		ArrayList<String> regionDescFrlList = new ArrayList<>();
		ArrayList<String> commentList = new ArrayList<>();
		ArrayList<String> regionCodeList = new ArrayList<>();

		for (String liner : healthRegion.split("\n")) {
			regionDescList.add(liner.replaceAll("\n", "").replaceAll("\r", "").replaceAll("'", "''"));
		}

		for (String liner : healthRegionF.split("\n")) {
			regionDescFrlList.add(liner.replaceAll("\n", "").replaceAll("\r", "").replaceAll("'", "''"));
		}

		for (String liner : comment.split("\n")) {
			commentList.add(liner);
		}

		for (String liner : regionCode.split("\n")) {
			regionCodeList.add(liner);
		}

		String total = "";
		String tableName = "CHILDBIRTH_REGIONAL__";
		for (int i = 0; i < 117; i++) {
			// System.out.println(regionDescList.get(i));
			if (!commentList.get(i).equals("NoChange")) {
				total += ("update " + tableName + " set health_region = '" + regionDescList.get(i)
						+ "',  health_region_f_desc = '" + regionDescFrlList.get(i) + "' "
						+ " where health_region_code = '" + regionCodeList.get(i) + "' and fiscal_year >= '"
						+ commentList.get(i) + "-" + (Integer.parseInt(commentList.get(i)) + 1) + "'" + ";\n\n");
			}
		}
		total += "\nCOMMIT;";
		api.fileoutputstream(total, path + "update_" + tableName + ".sql");
		System.out.println(total);

	}

	public void generateDadUpdateScript() throws Exception {

		String path = "\\\\torfs01\\user\\Groups\\EDW Services\\620 Systems Development & Maintenance\\Quick Stats\\IMT4 QnA Project\\QS Upgrade and backup\\DADQS\\";

		String aHealthRegion = getData(path + "A_HEALTH_REGION_F_DESC.csv");
		String aRegionCode = getData(path + "A_REGION_CODE.csv");

		ArrayList<String> aRegionCodeList = new ArrayList<>();
		ArrayList<String> aHealthRegionlList = new ArrayList<>();

		for (String liner : aRegionCode.split("\n")) {
			aRegionCodeList.add(liner.replaceAll("\n", "").replaceAll("\r", "").replaceAll("'", "''"));
		}

		for (String liner : aHealthRegion.split("\n")) {
			aHealthRegionlList.add(liner.replaceAll("\n", "").replaceAll("\r", "").replaceAll("'", "''"));
		}

		String total = "";
		String tableName = "CHILDBIRTH_REGIONAL";
		for (int i = 0; i < 90; i++) {
			// System.out.println(regionDescList.get(i));
			total += ("update " + tableName + " set health_region_f_desc = '" + aHealthRegionlList.get(i)
					+ "' where health_region_code = '" + aRegionCodeList.get(i)
					+ "' and fiscal_year = '2017-2018';\n\n");

		}
		total += "\nCOMMIT;";
		api.fileoutputstream(total, path + "YearUpdate" + tableName + ".sql");
		System.out.println(total);

	}

	public static void main(String[] args) throws Exception {
		new ScriptGenerator();
	}
}
