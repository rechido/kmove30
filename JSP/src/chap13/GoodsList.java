package chap13;

import java.util.ArrayList;

public class GoodsList {
	private ArrayList<String> codeList = new ArrayList<>();
	private ArrayList<String> titleList = new ArrayList<>();
	private ArrayList<String> writerList = new ArrayList<>();
	private ArrayList<Integer> priceList = new ArrayList<>();

	private boolean lastPage = false;
	private int totalPageCount = 0;
	private int minCode;
	private int maxCode;

	public GoodsList() {
	}

	public void setCode(int index, String code) {
		this.codeList.add(index, code);
	}

	public void setTitle(int index, String title) {
		this.titleList.add(index, title);
	}

	public void setWriter(int index, String writer) {
		this.writerList.add(index, writer);
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public void setPrice(int index, int price) {
		this.priceList.add(index, price);
	}

	public void setMinCode(int minCode) {
		this.minCode = minCode;
	}

	public void setMaxCode(int maxCode) {
		this.maxCode = maxCode;
	}
	
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public String[] getCode() {
		return codeList.toArray(new String[codeList.size()]);
	}

	public String[] getTitle() {
		return titleList.toArray(new String[titleList.size()]);
	}

	public String[] getWriter() {
		return writerList.toArray(new String[writerList.size()]);
	}

	public Integer[] getPrice() {
		return priceList.toArray(new Integer[priceList.size()]);
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public int getMinCode() {
		return minCode;
	}

	public int getMaxCode() {
		return maxCode;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public int getListSize() {
		return codeList.size();
	}
}
