package clientServer.server.backend.beam;

public class EventoAssicurazione {
	
	private static final String CSV_SEPARATOR = ";";
	
	private String policyID;
	private String stateCode;
	private String county;
	private String eq_site_limit;
	
	public EventoAssicurazione(String csvString) {
		String[] data = csvString.split(CSV_SEPARATOR);
		this.policyID = data[0];
		this.stateCode = data[1];
		this.county = data[2];
		this.eq_site_limit = data[3];
	}

	public String getPolicyID() {
		return policyID;
	}

	public void setPolicyID(String policyID) {
		this.policyID = policyID;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getEq_site_limit() {
		return eq_site_limit;
	}

	public void setEq_site_limit(String eq_site_limit) {
		this.eq_site_limit = eq_site_limit;
	}
	
	

}
