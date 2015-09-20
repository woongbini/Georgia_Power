package model.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class RegiPeopleDTO {
	private int article_number;
	private String title;
	private String region;
	private Timestamp regi_date;
	private Timestamp sys_date;
	private int number_of_person;
	private String age;
	private String gender;
	private String sport;
	private String user_id;
	private String location_name;
	private float location_x;
	private float location_y;
	private String detail;
	
	public RegiPeopleDTO() {}
	
	public RegiPeopleDTO( String title, String region, Timestamp regi_date, Timestamp sys_date,
			int number_of_person, String age, String gender, String sport, String user_id, String location_name,
			float location_x, float location_y, String detail) {
		this.title = title;
		this.region = region;
		this.regi_date = regi_date;
		this.sys_date = sys_date;
		this.number_of_person = number_of_person;
		this.age = age;
		this.gender = gender;
		this.sport = sport;
		this.user_id = user_id;
		this.location_name = location_name;
		this.location_x = location_x;
		this.location_y = location_y;
		this.detail = detail;
	}
	
	public RegiPeopleDTO(int article_number, String title, String region, Timestamp regi_date, Timestamp sys_date,
			int number_of_person, String age, String gender, String sport, String user_id, String location_name,
			float location_x, float location_y, String detail) {
		this.article_number = article_number;
		this.title = title;
		this.region = region;
		this.regi_date = regi_date;
		this.sys_date = sys_date;
		this.number_of_person = number_of_person;
		this.age = age;
		this.gender = gender;
		this.sport = sport;
		this.user_id = user_id;
		this.location_name = location_name;
		this.location_x = location_x;
		this.location_y = location_y;
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

	public int getNumber_of_person() {
		return number_of_person;
	}

	public void setNumber_of_person(int number_of_person) {
		this.number_of_person = number_of_person;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public float getLocation_x() {
		return location_x;
	}

	public void setLocation_x(float location_x) {
		this.location_x = location_x;
	}

	public float getLocation_y() {
		return location_y;
	}

	public void setLocation_y(float location_y) {
		this.location_y = location_y;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "RegiPeopleDTO [article_number=" + article_number + ", title=" + title + ", region=" + region
				+ ", regi_date=" + regi_date + ", sys_date=" + sys_date + ", number_of_person=" + number_of_person
				+ ", age=" + age + ", gender=" + gender + ", sport=" + sport + ", user_id=" + user_id
				+ ", location_name=" + location_name + ", location_x=" + location_x + ", location_y=" + location_y
				+ ", detail=" + detail + "]";
	}
	
	
	
}
