package kr.co.kt.vo;

public class BoardVO {
	String title;
	String writer;
	
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardVO(String title, String writer) {
		super();
		this.title = title;
		this.writer = writer;
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

	@Override
	public String toString() {
		return "BoardVO [title=" + title + ", writer=" + writer + "]";
	}
	
}
