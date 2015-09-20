package model.domain;

public class SportDTO {
	private int sport_code;
	private String sport_name;
	
	public SportDTO() {
		super();
	}
	public SportDTO(int sport_code, String sport_name) {
		super();
		this.sport_code = sport_code;
		this.sport_name = sport_name;
	}
	public int getSport_code() {
		return sport_code;
	}
	public void setSport_code(int sport_code) {
		this.sport_code = sport_code;
	}
	public String getSport_name() {
		return sport_name;
	}
	public void setSport_name(String sport_name) {
		this.sport_name = sport_name;
	}
	@Override
	public String toString() {
		return "SportDTO [sport_code=" + sport_code + ", sport_name=" + sport_name + "]";
	}
	

}
