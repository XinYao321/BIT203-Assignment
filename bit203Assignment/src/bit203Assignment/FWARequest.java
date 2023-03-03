package bit203Assignment;

// FWARequest class

/*@author:
 * Sebastian Chai B2000080
 */
public class FWARequest {
private String requestID;
	private String requestDate;
	private String workType;
	private String description;
	private String reason;
	private String status;
	private String comment;
	
	public FWARequest() 
	{
		setRequestID(requestID);
		setRequestDate(requestDate);
		setWorkType(workType);
		setDescription(description);
		setReason(reason);
		setStatus(status);
		setComment(comment);
	}
	
	// Constructor
	public FWARequest(
			String requestID, 
			String requestDate, 
			String workType, 
			String reason,  
			String status,  
			String comment
			)
	{
		setRequestID(requestID);
		setRequestDate(requestDate);
		setWorkType(workType);
		setDescription(description);
		setReason(reason);
		setStatus(status);
		setComment(comment);
	}

	public String getRequestID() {
		return requestID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	//TODO: toString()
	public String toString()
	{
		return ("Request ID: " + getRequestID() + 
				"\nRequest Date: " + getRequestDate() +
				"\nWork Type: " + getWorkType() +
				"\nDescription: " + getDescription() +
				"\nReason: " + getReason() +
				"\nStatus: " + getStatus() +
				"\nComment: " + getComment() 
				);
	}
}
