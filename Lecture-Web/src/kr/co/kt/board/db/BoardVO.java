package kr.co.kt.board.db;

/*
 * alt+shift+s 누른후
 * 1. c : 기본생성자
 * 2. o : 멤버변수 설정 생성자
 * 3. r : 게터(getter), 세터(setter) 메소드 생성
 * 4. s : toString 메소드
 */

// VO : Value Object
public class BoardVO {

	private int no;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int no, String title, String writer, String content,
			String regDate) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer
				+ ", content=" + content + ", regDate=" + regDate + "]";
	}
}
