package chap08;

public class BookInfo extends ProductInfo {
	private short page;
	private String writer;
	public BookInfo() {
		super();
	}
	public short getPage() {
		return page;
	}
	public void setPage(short page) {
		this.page = page;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
}
