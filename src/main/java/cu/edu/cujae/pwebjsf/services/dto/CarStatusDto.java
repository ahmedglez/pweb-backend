package cu.edu.cujae.pwebjsf.services.dto;

public class CarStatusDto {
	
	private int codeStatus;
	private String status;
	
	
	public CarStatusDto(int codeStatus, String status) {
		super();
		this.codeStatus = codeStatus;
		this.status = status;
	}
	public int getCodeStatus() {
		return codeStatus;
	}
	public void setCodeStatus(int codeStatus) {
		this.codeStatus = codeStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
