package bit203Assignment;

/*@author:
 * Lee Xin Yao B2100617
 */
public class DailySchedule {
	private String date, workLocation, workHours, workReport, supervisorComments;
	
	// Constructor
	public DailySchedule(String date, String workLocation, String workHours, 
						 String workReport, String supervisorComments) {
		setDate(date);
		setWorkLocation(workLocation);
		setWorkHours(workHours);
		setWorkReport(workReport);
		setSupervisorComments(supervisorComments);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public String getWorkHours() {
		return workHours;
	}

	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}

	public String getWorkReport() {
		return workReport;
	}

	public void setWorkReport(String workReport) {
		this.workReport = workReport;
	}

	public String getSupervisorComments() {
		return supervisorComments;
	}

	public void setSupervisorComments(String supervisorComments) {
		this.supervisorComments = supervisorComments;
	}
	
	// TODO: toString()
}
