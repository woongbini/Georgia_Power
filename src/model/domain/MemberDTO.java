package model.domain;

public class MemberDTO {
	private String kakao_key;
	private String nickname;
	private String inter_loc;
	private String gender;
	private String inter_sport;
	private int age;

	public MemberDTO(String kakao_key, String nickname, String inter_loc, String gender, String inter_sport, int age) {
		this.kakao_key = kakao_key;
		this.nickname = nickname;
		this.inter_loc = inter_loc;
		this.gender = gender;
		this.inter_sport = inter_sport;
		this.age = age;
	}

	public String getKakao_key() {
		return kakao_key;
	}

	public void setKakao_key(String kakao_key) {
		this.kakao_key = kakao_key;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getInter_loc() {
		return inter_loc;
	}

	public void setInter_loc(String inter_loc) {
		this.inter_loc = inter_loc;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getInter_sport() {
		return inter_sport;
	}

	public void setInter_sport(String inter_sport) {
		this.inter_sport = inter_sport;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "MemberDTO [kakao_key=" + kakao_key + ", nickname=" + nickname + ", inter_loc=" + inter_loc + ", gender="
				+ gender + ", inter_sport=" + inter_sport + ", age=" + age + "]";
	}

	

}
