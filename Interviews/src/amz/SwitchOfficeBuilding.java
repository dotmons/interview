package amz;

import java.util.ArrayList;
import java.util.List;

public class SwitchOfficeBuilding {

	Request req = new Request();
	List<Request> requests = new ArrayList<Request>();
	
	public SwitchOfficeBuilding(){
	
		addEmployeeRequest();
	}
	
	private void addEmployeeRequest() {

		req.setEmployeeName("Alex");
		req.setFrom_building(1);
		req.setTo_building(2);
		requests.add(req);
		req = new Request();
		
		req.setEmployeeName("Ben");
		req.setFrom_building(2);
		req.setTo_building(1);
		requests.add(req);
		req = new Request();
		
		req.setEmployeeName("Chris");
		req.setFrom_building(1);
		req.setTo_building(2);
		requests.add(req);
		req = new Request();
		
		req.setEmployeeName("David");
		req.setFrom_building(2);
		req.setTo_building(3);
		requests.add(req);
		req = new Request();
		
		req.setEmployeeName("Ellen");
		req.setFrom_building(3);
		req.setTo_building(1);
		requests.add(req);
		req = new Request();
		
		req.setEmployeeName("Frank");
		req.setFrom_building(4);
		req.setTo_building(5);
		requests.add(req);
		req = new Request();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	class Request{
		String employeeName;
		int from_building;
		int to_building;
		public String getEmployeeName() {
			return employeeName;
		}
		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
		public int getFrom_building() {
			return from_building;
		}
		public void setFrom_building(int from_building) {
			this.from_building = from_building;
		}
		public int getTo_building() {
			return to_building;
		}
		public void setTo_building(int to_building) {
			this.to_building = to_building;
		}
		@Override
		public String toString() {
			return "Request [employeeName=" + employeeName + ", from_building=" + from_building + ", to_building="
					+ to_building + "]";
		}
		
		
	}
	

}
