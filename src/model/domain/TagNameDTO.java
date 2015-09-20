package model.domain;

public class TagNameDTO {
		int idx;
	   int room_num;
	   String nickname;
	   int leader;
	   
	public TagNameDTO() {
	}
	public TagNameDTO( int room_num, String nickname, int leader) {
		this.room_num = room_num;
		this.nickname = nickname;
		this.leader = leader;
	}

	public TagNameDTO(int idx, int room_num, String nickname, int leader) {
		this.idx = idx;
		this.room_num = room_num;
		this.nickname = nickname;
		this.leader = leader;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getRoom_num() {
		return room_num;
	}

	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getLeader() {
		return leader;
	}

	public void setLeader(int leader) {
		this.leader = leader;
	}

	@Override
	public String toString() {
		return "TagNameDTO [idx=" + idx + ", room_num=" + room_num + ", nickname=" + nickname + ", leader=" + leader
				+ "]";
	}
	   
	   

}
