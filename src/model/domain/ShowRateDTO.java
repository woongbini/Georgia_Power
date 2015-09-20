package model.domain;

public class ShowRateDTO {
	private String nickname;
	private int yes_or_no;
	private int rate;
	
	public ShowRateDTO() {
	}
	
	public ShowRateDTO(String nickname, int yes_or_no, int rate) {
		this.nickname = nickname;
		this.yes_or_no = yes_or_no;
		this.rate = rate;
	}

	

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getYes_or_no() {
		return yes_or_no;
	}

	public void setYes_or_no(int yes_or_no) {
		this.yes_or_no = yes_or_no;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "ShowRateDTO [nickname=" + nickname + ", yes_or_no=" + yes_or_no + ", rate=" + rate + "]";
	}
	
	
	
	
}
