package model.domain;

import java.sql.Timestamp;

public class CommentDTO {
	private int article_number;
	private String nickname;
	private int comment_number;
	private Timestamp comm_regi_time;
	private String comm;
	private String kakao_key;
	
	public CommentDTO() {}
	
	public CommentDTO(int article_number, String nickname,  Timestamp comm_regi_time, String comm,
			String kakao_key) {
		this.article_number = article_number;
		this.nickname = nickname;
		this.comm_regi_time = comm_regi_time;
		this.comm = comm;
		this.kakao_key = kakao_key;
	}

	public CommentDTO(int article_number, String nickname, int comment_number, Timestamp comm_regi_time, String comm,
			String kakao_key) {
		this.article_number = article_number;
		this.nickname = nickname;
		this.comment_number = comment_number;
		this.comm_regi_time = comm_regi_time;
		this.comm = comm;
		this.kakao_key = kakao_key;
	}

	public int getArticle_number() {
		return article_number;
	}

	public void setArticle_number(int article_number) {
		this.article_number = article_number;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getComment_number() {
		return comment_number;
	}

	public void setComment_number(int comment_number) {
		this.comment_number = comment_number;
	}

	public Timestamp getComm_regi_time() {
		return comm_regi_time;
	}

	public void setComm_regi_time(Timestamp comm_regi_time) {
		this.comm_regi_time = comm_regi_time;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

	public String getKakao_key() {
		return kakao_key;
	}

	public void setKakao_key(String kakao_key) {
		this.kakao_key = kakao_key;
	}

	@Override
	public String toString() {
		return "CommentDTO [article_number=" + article_number + ", nickname=" + nickname + ", comment_number="
				+ comment_number + ", comm_regi_time=" + comm_regi_time + ", comm=" + comm + ", kakao_key=" + kakao_key
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
