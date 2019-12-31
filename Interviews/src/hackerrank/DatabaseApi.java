package hackerrank;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dotmons
 */
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.LogRecord;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseApi {

	Statement st;
	Random ran;
	int rand = 0;
	java.util.ArrayList<String> vec = new java.util.ArrayList<String>();
	String loginDriverDetailsOnUat = "jdbc:oracle:thin:@//dm04-scan.cihi.ca:1528/uatdb05_user.cihi.ca";
	String password = "";
	Class<?> classname = new Object() {
	}.getClass();

	private static Connection connection;

	public DatabaseApi() {
	}

	public Connection getConnection() {
		classname = new Object() {
		}.getClass();

		System.out.println("Generating connection : " + connection);
		

		return connection;
	}

	public void setConnection(Connection connection) {
		classname = new Object() {
		}.getClass();
		this.connection = connection;
	}

	public Connection getConnectionProcedure(String dbname, String username, String schema) {
		classname = new Object() {
		}.getClass();

		return null;
	}

	public Connection getConnectionToDbase() {
		return null;
	}

	public Connection getJNDIConnection(String dbname, String schema) {
		return null;
	}

	public String procedureExecutePackage(String packageProcedure, String database, String username, String schema)
			throws SQLException {
		classname = new Object() {
		}.getClass();

		Connection classConnection = null;
		Statement s = null;
		String output = "";

		boolean isExecute = false;

		try {
			classConnection = getConnectionProcedure(database, username, schema);
			s = classConnection.createStatement();
			s.execute("ALTER SESSION SET NLS_NUMERIC_CHARACTERS = '.,'");
			s.execute("ALTER SESSION SET NLS_LANGUAGE = 'AMERICAN'");
			s.execute("ALTER SESSION SET NLS_TERRITORY = 'AMERICA'");
			s.execute("ALTER SESSION SET CURRENT_SCHEMA = " + schema);
			// s.executeUpdate(packageProcedure.replaceAll(";", ""));

			// boolean isProcedureSql = false;
			// The query here determines if a sql provided is a procedure or
			// not.
			// If its a procedure, add to sqlProcedure, otherwise, add to
			// sqlQuery
			/*
			 * for (String sqlProc : packageProcedure.split("\n")) { if
			 * (sqlProc.trim().contains("begin") ||
			 * (sqlProc.trim().contains("declare"))) { isProcedureSql = true;
			 * sqlProcedure += sqlProc.trim() + " \n"; } else { if
			 * (isProcedureSql) { sqlProcedure += sqlProc.trim() + "\n"; } else
			 * { // checks if new line is empty or not if
			 * (!sqlProc.trim().equals("")) sqlQuery += sqlProc.trim() + "\n"; }
			 * } }
			 * 
			 * if (sqlQuery != "") { for (String sqlQ : sqlQuery.split("\n")) {
			 * s.executeUpdate(sqlQ.replace(";", ""));
			 * LogContentLoggerInfo(classname, "SqlQuery calling method> " +
			 * sqlQ); } }
			 * 
			 * if (sqlProcedure != "") { LogContentLoggerInfo(classname,
			 * "SqlProcedure Calling method > " + sqlProcedure);
			 * s.executeUpdate("begin dbms_output.enable(); end;");
			 * s.execute(sqlProcedure.replace(";", "")); }
			 * 
			 * 
			 */
			s.executeUpdate("begin dbms_output.enable(); end;");

			if (packageProcedure.trim().contains("begin") || (packageProcedure.trim().contains("declare"))) {
				s.execute(packageProcedure);
				CallableStatement call = classConnection.prepareCall(
						"declare " + "  num integer := 1000;" + "begin " + "  dbms_output.get_lines(?, num);" + "end;");
				call.registerOutParameter(1, Types.ARRAY, "DBMSOUTPUT_LINESARRAY");
				call.execute();

				Array array = null;
				try {
					array = call.getArray(1);

					for (Object cd : (Object[]) array.getArray()) {
						output += cd.toString() + "<br/>";
					}
				} finally {
					if (array != null)
						array.free();
				}
				s.executeUpdate("begin dbms_output.disable(); end;");
				output = output.equals("") ? "Success Running Script " : output;
				s.close();
			} else {
				System.out.println("Executing sql >> " + packageProcedure);
				isExecute = isExecuteSql(packageProcedure.replaceAll(";", ""), classConnection);
				output = isExecute ? "Success Running Script " : "Failed to Execute Script ";
				s.close();
				// selectSql(packageProcedure.replaceAll(";", ""), "count(*)",
				// classConnection).get(0);
			}
			if (!database.toUpperCase().contains("DEVDB")) {
				classConnection.close();
			}

		} catch (NullPointerException exception) {
			// This exception is always called, after execution, and should
			// return
			// true. Execution is successful...
			// LogContentLoggerInfo(classname, "Null pointer here should be
			// ignored > " + exception.toString());
			return output;
		} catch (Exception exception) {
			output = exception.toString() + "\n Username: " + username + "\n Database: " + database + "\n schema: "
					+ schema;
			LogContentLoggerSevere(classname, exception.toString() + " \n Sql :>> " + packageProcedure);
		}
		return output;
	}

	public boolean notNullAndNotEmpty(String value) {
		if (!(value.equals(null)) && (!value.trim().equals(""))) {
			return true;
		}
		return false;
	}

	public boolean notNullAndNotEmpty(int value) {
		return value != 0;
	}

	public String notNullAndNotEmptyRequest(String value) {
		if (!(value.equals(null)) && (!value.trim().equals(""))) {
			return value;
		}
		return "";
	}

	public String timenow() {
		Calendar cd = Calendar.getInstance();
		int sec = (cd.get(Calendar.SECOND));
		int min = (cd.get(Calendar.MINUTE));
		int hr = (cd.get(Calendar.HOUR_OF_DAY));

		return (zero(hr)) + ":" + (zero(min)) + ":" + (zero(sec));
	}

	public String datenow() {
		Calendar cd = Calendar.getInstance();
		int sec = (cd.get(Calendar.MONTH) + 1);
		int min = (cd.get(Calendar.DAY_OF_MONTH));
		int hr = (cd.get(Calendar.YEAR));
		return (zero(min)) + "-" + (month(Integer.parseInt(zero(sec)))) + "-" + (zero(hr));
	}

	public String datenoformat() {
		Calendar cd = Calendar.getInstance();
		int sec = (cd.get(Calendar.MONTH) + 1);
		int min = (cd.get(Calendar.DAY_OF_MONTH));
		int hr = (cd.get(Calendar.YEAR));
		return (zero(hr)) + "-" + (zero(sec)) + "-" + (zero(min));
	}

	public String zero(int num) {
		String number = (num < 10) ? ("0" + num) : ("" + num);
		return number;
	}

	public String month(int num) {
		switch (num) {
		case 1:
			return "JAN";
		case 2:
			return "FEB";
		case 3:
			return "MAR";
		case 4:
			return "APR";
		case 5:
			return "MAY";
		case 6:
			return "JUN";
		case 7:
			return "JUL";
		case 8:
			return "AUG";
		case 9:
			return "SEP";
		case 10:
			return "OCT";
		case 11:
			return "NOV";
		case 12:
			return "DEC";
		default:
			return "DEC";
		}
	}

	/*
	 * public boolean closeconnection(Connection connection) { try { // ////if
	 * (connection!=null) {//connection.close();} return true; } catch(Exception
	 * e) { return false; } }
	 * 
	 * 
	 */
	public void writeToFileByLine(String filename, String[] data) {

		BufferedWriter bufferedWriter = null;

		try {

			// Construct the BufferedWriter object
			bufferedWriter = new BufferedWriter(new FileWriter(filename));

			// Start writing to the output stream
			bufferedWriter.write("Writing line one to file");
			bufferedWriter.newLine();
			bufferedWriter.write("Writing line two to file");

			for (int i = 0; i < data.length; i++) {
				bufferedWriter.write(data[i]);
				bufferedWriter.newLine();
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			// Close the BufferedWriter
			try {
				if (bufferedWriter != null) {
					bufferedWriter.flush();
					bufferedWriter.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public String fileinputstream(String input)// where input represents the
												// path of the file to be used
	{

		FileInputStream filea;
		byte bytearray[];
		String dance = null;
		int size = 0;
		File tes;
		try {
			
			//
			
			filea = new FileInputStream(input);
			size = filea.available();
			bytearray = new byte[size];

			if (filea.read(bytearray) == size) {
				dance = (new String(bytearray, 0, size));
			}

		} catch (Exception e) {
		}
		return dance;


	}

	public void fileoutputstream(String input, String location)// In here, input
																// represents
																// the path for
																// output files.
	{
		try {
			byte value[] = input.getBytes();
			FileOutputStream fileout = new FileOutputStream(location);
			fileout.write(value);
		} catch (Exception e) {
			System.out.println("Specify path ur self " + e);

		}

	}

	public void fileSender(InputStream inStream, OutputStream outStream) {
		try {

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {

				outStream.write(buffer, 0, length);

			}

			inStream.close();
			outStream.close();

			System.out.println("File is copied successful!");

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public boolean isNumber(String tt) {
		String dat[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", };

		for (int i = 0; i <= 9; i++) {
			if (dat[i].equals(tt)) {
				return true;
			}
		}
		return false;
	}

	public Object getImage(String reg, String table) {

		Object rr = "";
		try {
			String stg = "select * from " + table + " where regid = " + reg;
			Connection connection = getConnection();
			ResultSet rs;
			st = connection.createStatement();
			rs = st.executeQuery(stg);
			while (rs.next()) {
				rr = rs.getObject("Image");
			}
			st.close();
			if (connection != null) {
				// connection.close();
			}
		} catch (Exception e1) {
		}
		return rr;
	}

	public boolean isExist(String regid, String table, String id) {
		String stg = "";
		try {
			stg = "SELECT " + regid + " from " + table + " where " + regid + " = '" + id + "'";
			Connection connection = getConnection();
			ResultSet rs;
			st = connection.createStatement();
			rs = st.executeQuery(stg);
			System.out.println(stg);
			while (rs.next()) {
				String rg = rs.getString(regid);
				return true;
			}
			st.close();
			if (connection != null) {
				// connection.close();
			}
		} catch (Exception exception) {
			java.util.logging.Logger.getLogger(DatabaseApi.class.getName()).log(java.util.logging.Level.SEVERE,
					"{0}Sql: {1}", new Object[] { exception.toString(), stg });
			return false;
		}
		return false;
	}

	public boolean isExist(String regid, String table, String id, String reg) {
		String stg = "";
		try {
			stg = "SELECT " + regid + " from " + table + " where " + reg + " = '" + id + "'";
			Connection connection = getConnection();
			ResultSet rs;
			st = connection.createStatement();
			rs = st.executeQuery(stg);
			System.out.println(stg);
			while (rs.next()) {
				String rg = rs.getString(regid);
				return true;
			}
			st.close();
			if (connection != null) {
				// connection.close();
			}
		} catch (Exception exception) {
			java.util.logging.Logger.getLogger(DatabaseApi.class.getName()).log(java.util.logging.Level.SEVERE,
					"{0}Sql: {1}", new Object[] { exception.toString(), stg });
			return false;
		}
		return false;
	}

	public boolean deleteItem(String table, String pritable, String id) {
		String stg = "";
		try {
			stg = "delete from " + table + " where " + pritable + " = '" + id + "'";
			Connection connection = getConnection();
			st = connection.createStatement();
			st.execute(stg);
			st.close();
			if (connection != null) {
				// connection.close();
			}
			// boolean closed =
			return true;
		} catch (Exception exception) {
			java.util.logging.Logger.getLogger(DatabaseApi.class.getName()).log(java.util.logging.Level.SEVERE,
					"{0}Sql: {1}", new Object[] { exception.toString(), stg });
			return false;
		}
	}

	public boolean deleteItem(String stg) {
		try {
			Connection connection = getConnection();
			st = connection.createStatement();
			st.execute(stg);
			st.close();
			if (connection != null) {
				// connection.close();
			}
			// boolean closed =
			System.out.println(stg);
			return true;
		} catch (Exception exception) {
			java.util.logging.Logger.getLogger(DatabaseApi.class.getName()).log(java.util.logging.Level.SEVERE,
					"{0}Sql: {1}", new Object[] { exception.toString(), stg });
			return false;
		}
	}

	public boolean deleteBatchItem(ArrayList<String> stg) {
		try {
			Connection connection = getConnection();
			st = connection.createStatement();

			for (String arrStr : stg) {
				st.addBatch(arrStr);
			}

			st.executeBatch();
			st.close();
			return true;
		} catch (Exception exception) {
			java.util.logging.Logger.getLogger(DatabaseApi.class.getName()).log(java.util.logging.Level.SEVERE,
					"{0}Sql: {1}", new Object[] { exception.toString(), stg });
			return false;
		}
	}

	public boolean truncateTable(String tableName) {
		String stg = "";
		try {
			stg = "truncate table " + tableName;
			Connection connection = getConnection();
			st = connection.createStatement();
			st.execute(stg);
			st.close();
			if (connection != null) {
				// connection.close();
			}
			// boolean closed =
			return true;
		} catch (Exception exception) {
			java.util.logging.Logger.getLogger(DatabaseApi.class.getName()).log(java.util.logging.Level.SEVERE,
					"{0}Sql: {1}", new Object[] { exception.toString(), stg });
			return false;
		}
	}

	public boolean update(String table, String field, String value, String id, String prifield) {
		String stg = "";
		try {
			stg = "UPDATE " + table + " set " + field + " = " + value + " where " + id + " = " + prifield;
			System.out.println("Updating record script >>>>>> " + stg);
			Connection connection = getConnection();
			System.out.println("Connection is >> " + connection);
			st = connection.createStatement();
			st.executeUpdate(stg);
			st.close();
			if (connection != null) {
				// connection.close();
			}
			return true;
		} catch (Exception exception) {
			java.util.logging.Logger.getLogger(DatabaseApi.class.getName()).log(java.util.logging.Level.SEVERE,
					"{0}Sql: {1}", new Object[] { exception.toString(), stg });
			return false;
		}
	}
	//
	// public void main(String[] args) {
	// Dotmonscodeapi a = new Dotmonscodeapi();
	// System.out.println(a.convertToPasswordHash("adeoye"));
	// }

	public java.util.ArrayList<String> selectSomeElements(java.util.ArrayList<String> arrList, String table) {

		String stg = "";
		String sst = "";

		java.util.ArrayList externalArrayList = new java.util.ArrayList();

		for (int i = 1; i < arrList.size(); i++) {
			stg += (arrList.get(i - 1) + ", ");
		}

		stg += arrList.get(arrList.size() - 1);
		try {
			sst += "SELECT " + stg + " FROM " + table;
			Connection connection = getConnection();
			ResultSet rs;
			st = connection.createStatement();
			rs = st.executeQuery(sst);
			while (rs.next()) { // System.out.println(rs.getString(++jj));
				java.util.ArrayList internalArrayList = new java.util.ArrayList();
				for (Object strlist : arrList) {
					internalArrayList.add(rs.getString(strlist.toString()));
				}
				externalArrayList.add(internalArrayList);
			}
			st.close();
			if (connection != null) {
				// connection.close();
			}
		} catch (Exception exception) {
			java.util.logging.Logger.getLogger(DatabaseApi.class.getName()).log(java.util.logging.Level.SEVERE,
					exception.toString());
		}
		return externalArrayList;
	}

	public int getSize(String sql, String field) {
		int jj = 0;
		java.util.ArrayList<String> arr = new java.util.ArrayList<String>();

		try {
			Connection connection = getConnection();
			ResultSet rs;
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) { // System.out.println(rs.getString(++jj));
				arr.add(rs.getString(field));
			}

			st.close();
			if (connection != null) {
				// connection.close();
			}
		} catch (Exception exception) {
			java.util.logging.Logger.getLogger(DatabaseApi.class.getName()).log(java.util.logging.Level.SEVERE,
					exception.toString());
		}
		return arr.size();
	}

	public java.util.ArrayList<String> selectSql(String sql, String field) {
		classname = new Object() {
		}.getClass();
		int jj = 0;
		java.util.ArrayList<String> arr = new ArrayList<String>();

		try {
			ResultSet rs;
			Connection connection = getConnection();
			System.out.println(connection);
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {// System.out.println(rs.getString(++jj))
				arr.add(rs.getString(field));
			}
			st.close();
			if (connection != null) {
				// connection.close();
			}
		} catch (SQLRecoverableException sqlException) {
			LogContentLoggerInfo(classname, sqlException.toString() + sql);
			// ConnectionManager.getInstance().reInitiateConnection();
		} catch (Exception exception) {
			System.out.println("Operation Unsuccessful select sql => " + sql);
			LogContentLoggerSevere(classname, "SQL:> " + sql + " Exception Code: " + exception);
		}
		return arr;
	}

	public java.util.ArrayList<String> selectSql(String sql, String field, Connection connection) {
		classname = new Object() {
		}.getClass();
		int jj = 0;
		java.util.ArrayList<String> arr = new ArrayList<String>();
		ResultSet rs;
		try {

			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {// System.out.println(rs.getString(++jj))
				arr.add(rs.getString(field));
			}
			st.close();
			if (connection != null) {
				// connection.close();
			}
		} catch (Exception e1) {
			LogContentLoggerInfo(classname, "Operation Unsuccessful select sql = " + sql + e1);
		}
		return arr;
	}

	public boolean isExecuteSql(String sql) {
		classname = new Object() {
		}.getClass();
		int jj = 0;

		try {
			ResultSet rs;
			Connection connection = getConnection();
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			st.close();
			if (connection != null) {
				// connection.close();
			}
			return true;
		} catch (Exception e1) {
			LogContentLoggerSevere(classname, "Operation Unsuccessful select sql = " + sql + e1);
			return false;
		}

	}

	public boolean isExecuteSql(String sql, Connection conn) {

		int jj = 0;

		try {
			ResultSet rs;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			st.close();
			if (connection != null) {
				// connection.close();
			}
			return true;
		} catch (Exception e1) {
			System.out.println("Operation Unsuccessful select sql = " + sql);
			System.out.println("Submit = " + e1);
			return false;
		}

	}

	public java.util.ArrayList selectElementAsc(String sta[], String table, String field1, String field2, int obj) {

		String stg = "";
		String sst = "";
		int jj = 0;
		java.util.ArrayList arr1 = new java.util.ArrayList();
		java.util.ArrayList arr2 = new java.util.ArrayList();

		for (int i = 1; i < sta.length; i++) {
			stg += (sta[i - 1] + ", ");
		}

		stg += sta[sta.length - 1];
		try {
			sst += "SELECT " + stg + " FROM " + table + " order by " + field1 + " asc";
			Connection connection = getConnection();
			ResultSet rs;
			st = connection.createStatement();
			rs = st.executeQuery(sst);
			while (rs.next()) { // System.out.println(rs.getString(++jj));

				arr1.add(rs.getString(field1));
				arr2.add(rs.getString(field2));
			}

			st.close();
			if (connection != null) {
				// connection.close();
			}
		} catch (Exception e1) {
			System.out.println(sst);
			System.out.println("Operation Unsuccessful");
			System.out.println("Submit = " + e1);
		}
		if (obj == 0) {
			return arr1;
		}
		return arr2;
	}

	public java.util.ArrayList selectSomeElementAsc(String sta[], String table, String field1) {

		String stg = "";
		String sst = "";
		int jj = 0;
		java.util.ArrayList arr1 = new java.util.ArrayList();

		for (int i = 1; i < sta.length; i++) {
			stg += (sta[i - 1] + ", ");
		}

		stg += sta[sta.length - 1];
		try {
			sst += "SELECT " + stg + " FROM " + table + " order by " + field1 + " asc";
			Connection connection = getConnection();
			ResultSet rs;
			st = connection.createStatement();
			rs = st.executeQuery(sst);
			while (rs.next()) { // System.out.println(rs.getString(++jj));
				arr1.add(rs.getString(field1));
			}

			st.close();
			if (connection != null) {
				// connection.close();
			}
		} catch (Exception e1) {
			System.out.println(sst);
			System.out.println("Operation Unsuccessful");
			System.out.println("Submit = " + e1);
		}
		return arr1;
	}

	public java.util.ArrayList selectElementById(String sta[], String table, String idfield, String id) {

		String stg = "";
		String sst = "";
		int j = 0;
		java.util.ArrayList arr = new java.util.ArrayList();

		while (j < sta.length - 1) {
			stg += (sta[j++] + ", ");
		}
		stg += sta[sta.length - 1];
		j = 0;
		try {
			sst += "SELECT " + stg + " FROM " + table + " where " + idfield + " = '" + id + "'";
			Connection connection = getConnection();
			ResultSet rs;
			st = connection.createStatement();
			rs = st.executeQuery(sst);
			while (rs.next()) {
				while (j < sta.length) {
					arr.add(rs.getString(++j));
				}
				/*
				 * for(int i=1; i<=sta.length; i++) {arr.add(rs.getString(i)); }
				 */
			}
			st.close();
			if (connection != null) {
				// connection.close();
			}
		} catch (Exception e1) {
			System.out.println("Operation Unsuccessful @ database.selectElementById");
			System.out.println("Submit = " + e1);
		}
		return arr;
	}

	public boolean updateAllElements(String sta[], String table, String val[], String id, String prifield) {
		classname = new Object() {
		}.getClass();
		String stg = "";
		String sst = "";
		int j = 0;
		Connection connection = null;
		while (j < sta.length - 1) {
			stg += (sta[j] + " = '" + val[j++] + "', ");
		}
		stg += sta[sta.length - 1] + " = '" + val[sta.length - 1] + "'";
		j = 0;

		try {
			sst += "update " + table + " set " + stg + " where " + id + " = '" + prifield + "'";
			connection = getConnection();
			st = connection.createStatement();
			st.executeUpdate(sst);
			st.close();
			if (connection != null) {
				// connection.close();
			}
			return true;
		} catch (Exception exception) {
			LogContentLoggerSevere(classname, exception.toString() + "\n SQL >> \n " + sst);
			return false;
		}
	}

	public boolean insertAllElement(java.util.ArrayList dblist, String table) {
		classname = new Object() {
		}.getClass();
		Connection connection = null;
		String stg = "";
		String sst = "";
		int j = 0;
		while (j < dblist.size() - 1) {
			stg += (dblist.get(j++) + ", ");
		}

		stg += dblist.get(dblist.size() - 1);
		sst += "insert into " + table + " values (" + stg + ")".toUpperCase();

		try {
			connection = getConnection();
			st = connection.createStatement();
			st.execute(sst);
			st.close();
			if (connection != null) {
				// connection.close();
			}
			return true;
		} catch (Exception exception) {
			LogContentLoggerSevere(classname, exception.toString() + "\n SQL >> \n " + sst);

		}
		return false;
	}

	public String addSingleQuoteToString(String value) {
		return "'" + value + "'";
	}

	public boolean insertAllSingleElement(String sta[], String table, int size) {
		String sst = "";
		classname = new Object() {
		}.getClass();
		Connection connection = null;
		try {
			connection = getConnection();
			st = connection.createStatement();
			for (int i = 0; i < size; i++) {
				sst = "insert into " + table + " values (0,'" + sta[i] + "')";
				sst = sst.toUpperCase();
				st.execute(sst);
				st.close();
				if (connection != null) {
					// connection.close();
				}
			}

			return true;
		} catch (Exception exception) {
			LogContentLoggerSevere(classname, exception.toString() + "\n SQL >> \n " + sst);
		}
		return false;
	}

	public boolean insertAllSingleElements(String sta[], String table, int size) {

		String sst = "";
		classname = new Object() {
		}.getClass();
		Connection connection = null;
		try {
			connection = getConnection();
			st = connection.createStatement();
			System.out.println("Length = " + sta.length);
			for (int i = 0; i < size; i++) {
				sst = "insert into " + table + " values (0, '" + sta[i] + "', 0)";
				sst = sst.toUpperCase();
				st.execute(sst);
				st.close();
				if (connection != null) {
					// connection.close();
				}
			}
			return true;
		} catch (Exception exception) {
			LogContentLoggerSevere(classname, exception.toString() + "\n SQL >> \n " + sst
					+ " <<<insertAllSingleElements: Error inserting record to database >>>{0} <<<Failed Query>>>{1}");
		}
		return false;
	}

	public String convertToPasswordHash(String password) {
		classname = new Object() {
		}.getClass();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte byteData[] = md.digest();
			// convert the byte to hex format method 1
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));

			}
			return sb.toString();
		} catch (Exception exception) {
			LogContentLoggerSevere(classname, exception.toString());
		}
		return "";
	}

	public String getRandomize() {

		rand = ran.nextInt(vec.size());
		return vec.get(rand); // ran.nextInt(9);
	}

	public String getRandomPassword() {
		ran = new Random();
		String rander = "";
		for (int i = 48; i <= 122; i++) {
			if ((i > 57) && (i < 65) || ((i > 90) && (i < 97))) {
				continue;
			}
			// System.out.println((char)i);
			vec.add(String.valueOf((char) i));
			// i++;
		}
		for (int i = 0; i <= 8; i++) {
			rander = rander + getRandomize();
		}
		return rander;
	}

	// Uncomment setSession, killSession, and getSessionUsername when running
	// web page container

	// public void setSession(String sessionName, String sessionValue) {
	//
	// try {
	// session.put(sessionName, sessionValue);
	// System.out.println("Setting session successful for " + sessionName);
	// } catch (Exception exception) {
	// java.util.logging.Logger.getLogger(Dotmonscodeapi.class.getName()).log(java.util.logging.Level.SEVERE,
	// exception.toString());
	// }
	// }
	//
	// public void killSession(String sessionName) {
	// try {
	// session.remove(sessionName);
	// } catch (Exception exception) {
	// java.util.logging.Logger.getLogger(Dotmonscodeapi.class.getName()).log(java.util.logging.Level.SEVERE,
	// exception.toString());
	// }
	// }
	//
	/*
	 * public String getSessionUsername() { classname = new Object() {
	 * }.getClass(); try { return session.getAttribute("username").toString(); }
	 * catch (Exception exception) { LogContentLoggerSevere(classname,
	 * "Error getting session > " + exception); return ""; } }
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public java.util.ArrayList selectSomeElementsWithQuery(@SuppressWarnings("rawtypes") java.util.ArrayList arrList,
			String sql) {
		classname = new Object() {
		}.getClass();
		Connection connection = null;
		java.util.ArrayList externalArrayList = new java.util.ArrayList();
		try {
			connection = getConnection();
			ResultSet rs;
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) { // System.out.println(rs.getString(++jj));
				java.util.ArrayList internalArrayList = new java.util.ArrayList();
				for (Object strlist : arrList) {
					internalArrayList.add(rs.getString(strlist.toString()));
				}
				externalArrayList.add(internalArrayList);
			}
			st.close();
			if (connection != null) {
				// connection.close();
			}
		}

		catch (Exception exception) {
			getLogger("DatabaseApi.selectSomeElementsWithQuery", exception.toString() + sql);
		}
		return externalArrayList;
	}

	public String getDateAloneFromDate(String dates) {
		// System.out.println(dates.replaceAll("-",
		// "/").substring(0,dates.indexOf(" ")).trim());
		return dates.replaceAll("-", "/").substring(0, dates.indexOf(" ")).trim();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public java.util.ArrayList selectSomeElementsWithQuery(String sql) {
		classname = new Object() {
		}.getClass();
		Connection connection = null;
		java.util.ArrayList externalArrayList = new java.util.ArrayList();
		try {
			connection = getConnection();
			ResultSet rs;
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
			while (rs.next()) {
				java.util.ArrayList internalArrayList = new java.util.ArrayList();
				for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
					internalArrayList.add(rs.getString(i));
				}
				externalArrayList.add(internalArrayList);
			}
			st.close();
			if (connection != null) {
				// connection.close();
			}
		} catch (java.sql.SQLRecoverableException sqlException) {
			getLogger("DatabaseApi.selectSomeElementsWithQuery", sqlException.toString() + sql);
			// ConnectionManager.getInstance().reInitiateConnection();
		} catch (Exception exception) {
			getLogger("DatabaseApi.selectSomeElementsWithQuery", exception.toString() + sql);
		}
		return externalArrayList;
	}

	public StringBuffer selectSomeElementsWithQueryToCsvToFile(String sql, String insertQuery) {
		classname = new Object() {
		}.getClass();
		Connection connection = null;
		StringBuffer generatedSql = new StringBuffer();

		try {
			connection = getConnection();
			ResultSet rs;
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = rs.getMetaData();

			boolean[] isResultSetVarchar = new boolean[resultSetMetaData.getColumnCount() + 1];

			for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
				int type = resultSetMetaData.getColumnType(i);
				if (type == Types.VARCHAR || type == Types.CHAR) {
					isResultSetVarchar[i - 1] = true;
				} else {
					isResultSetVarchar[i - 1] = false;
				}
			}

			while (rs.next()) {

				for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
					String dataSql = rs.getString(i);

					if (isResultSetVarchar[i - 1]) {
						if (i == 1) {
							generatedSql.append(insertQuery + "'" + dataSql.replace("'", "''") + "',");
						} else if (i == resultSetMetaData.getColumnCount()) {
							generatedSql.append("'" + dataSql.replace("'", "''") + "'" + ")");
						} else {
							generatedSql.append("'" + dataSql.replace("'", "''") + "',");
						}
					} else {
						if (i == 1) {
							generatedSql.append(insertQuery + dataSql + ",");
						} else if (i == resultSetMetaData.getColumnCount()) {
							generatedSql.append(dataSql + ")");
						} else {
							generatedSql.append(dataSql + ",");
						}
					}
				}
				generatedSql.append("\n");
			}
			st.close();
			if (connection != null) {
				// connection.close();
			}
		} catch (Exception exception) {
			LogContentLoggerSevere(classname, exception.toString() + sql);
		}
		return generatedSql;
	}

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public int getLastDate() {
		Calendar calendar = Calendar.getInstance();
		int lastDate = calendar.getActualMaximum(Calendar.DATE);
		calendar.set(Calendar.DATE, lastDate);
		return (calendar.get(Calendar.DAY_OF_MONTH));
	}

	public void getLogger(String exceptionMessage1, LogRecord logRecord) {
		java.util.logging.Logger.getLogger(DatabaseApi.class.getName()).log(java.util.logging.Level.SEVERE,
				DatabaseApi.class.getName() + ": {0}", new Object[] { exceptionMessage1 });
	}

	public void getLogger(String exceptionMessage1, String exceptionMessage2) {
		java.util.logging.Logger.getLogger(DatabaseApi.class.getName()).log(java.util.logging.Level.SEVERE,
				DatabaseApi.class.getName() + ": {0} {1}", new Object[] { exceptionMessage1, exceptionMessage2 });
	}

	public void LogContentLoggerInfo(Class<?> classname, String logMessage) {
		try {
			java.util.logging.Logger.getLogger(classname.getName())
					.log(java.util.logging.Level.INFO,
							"Classname> " + classname.getName() + " Methodname>"
									+ classname.getEnclosingMethod().getName() + " <<>>: {0}",
							new Object[] { logMessage });
		} catch (Exception exception) {
			java.util.logging.Logger.getLogger(classname.getName()).log(java.util.logging.Level.SEVERE,
					classname.getName() + ": {0} {1}",
					new Object[] { exception, "Missing classname not defined in a method" });
		}
	}

	public void LogContentLoggerSevere(Class<?> classname, String logMessage) {
		try {
			java.util.logging.Logger.getLogger(classname.getName())
					.log(java.util.logging.Level.SEVERE,
							"Classname> " + classname.getName() + " Methodname>"
									+ classname.getEnclosingMethod().getName() + " <<>>: {0}",
							new Object[] { logMessage });
		} catch (Exception exception) {
			java.util.logging.Logger.getLogger(classname.getName()).log(java.util.logging.Level.SEVERE,
					classname.getName() + ": {0} {1}",
					new Object[] { exception, "Missing classname not defined in a method" });

		}
	}

	public void LogContentLoggerSevere(Class<?> classname, Exception exceptions) {
		try {
			java.util.logging.Logger.getLogger(classname.getName()).log(
					java.util.logging.Level.SEVERE, "Classname> " + classname.getName() + " Methodname>"
							+ classname.getEnclosingMethod().getName() + " <<>>: {0}",
					new Object[] { exceptions.toString() });
		} catch (Exception exception) {
			java.util.logging.Logger.getLogger(classname.getName()).log(java.util.logging.Level.SEVERE,
					classname.getName() + ": {0} {1}",
					new Object[] { exception, "Missing classname not defined in a method" });

		}
	}
	/*
	 * public String procedureExecutePackages(String packageProcedure, String
	 * dbname, String schema) throws SQLException { classname = new Object() {
	 * }.getClass(); Connection classConnection = null; Statement s = null;
	 * String output = "";
	 * 
	 * String sqlQuery = ""; String sqlProcedure = "";
	 * 
	 * try {
	 * 
	 * classConnection = getConnection(); CallableStatement callableStatement =
	 * null; String getDBUSERByUserIdSql = "{call LOAD_CMDB.LOAD_CMDB2}";
	 * callableStatement = classConnection.prepareCall(getDBUSERByUserIdSql);
	 * 
	 * // execute getDBUSERByUserId store procedure
	 * callableStatement.executeUpdate();
	 * 
	 * // s.execute("ALTER SESSION SET CURRENT_SCHEMA = " + schema); } catch
	 * (Exception exception) { System.out.println("Exception procedure >>> " +
	 * exception); } return ""; }
	 */

	// This is only called on login, to confirm if the username and password are
	// correct
	public boolean isLoginValid(String username, String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection connection = DriverManager.getConnection(loginDriverDetailsOnUat, username, password);
			if (!connection.isClosed()) {
				if (connection != null) {
					// connection.close();
				}
			}
			return true;
		} catch (Exception exception) {
			java.util.logging.Logger.getLogger(DatabaseApi.class.getName()).log(java.util.logging.Level.SEVERE,
					"{0}getJNDIConnection, SQLException: ",
					new Object[] { exception.toString() + " Username: " + username });
			return false;
		}
	}

	public java.util.ArrayList<String> selectOwner(String dbname, String username) {

		int jj = 0;
		java.util.ArrayList<String> arr = new ArrayList<String>();

		try {
			ResultSet rs;
			Connection connection = getConnectionProcedure(dbname, username, "QNANRSDEV");
			// System.out.println(connection);
			st = connection.createStatement();
			rs = st.executeQuery("select unique owner from all_tables order by OWNER");
			while (rs.next()) {// System.out.println(rs.getString(++jj))
				arr.add(rs.getString("OWNER"));
			}
			st.close();
			if (connection != null) {
				// connection.close();
			}
		} catch (Exception e1) {

		}
		return arr;
	}

}
