package model.domain;


import java.sql.Timestamp;

public class RegiLocationDTO {
	private int article_number;
	private String title;
	private String region;
	private Timestamp regi_date;
	private Timestamp sys_date;
	private String sport;
	private String user_id;
	private String detail;
	
	public RegiLocationDTO() {}
	
	public RegiLocationDTO( String title, String region, Timestamp regi_date, Timestamp sys_date, String sport,
			String user_id, String detail) {
		this.title = title;
		this.region = region;
		this.regi_date = regi_date;
		this.sys_date = sys_date;
		this.sport = sport;
		this.user_id = user_id;
		this.detail = detail;
	}
	
	public RegiLocationDTO(int article_number, String title, String region, Timestamp regi_date, Timestamp sys_date, String sport,
			String user_id, String detail) {
		this.article_number = article_number;
		this.title = title;
		this.region = region;
		this.regi_date = regi_date;
		this.sys_date = sys_date;
		this.sport = sport;
		this.user_id = user_id;
		this.detail = detail;
	}

	public int getArticle_number() {
		return article_number;
	}

	public void setArticle_number(int article_number) {
		this.article_number = article_number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Timestamp getRegi_date() {
		return regi_date;
	}

	public void setRegi_date(Timestamp regi_date) {
		this.regi_date = regi_date;
	}

	public Timestamp getSys_date() {
		return sys_date;
	}

	public void setSys_date(Timestamp sys_date) {
		this.sys_date = sys_date;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "RegiLocationDTO [article_number=" + article_number + ", title=" + title + ", region=" + region
				+ ", regi_date=" + regi_date + ", sys_date=" + sys_date + ", sport=" + sport + ", user_id=" + user_id
				+ ", detail=" + detail + "]";
	}
    
}
