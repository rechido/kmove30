package chap13;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.servlet.ServletException;
import javax.sql.*;

public class BBSList {
	private ArrayList<Integer> seqNoList = new ArrayList<>();
	private ArrayList<String> titleList = new ArrayList<>();
	private ArrayList<String> writerList = new ArrayList<>();
	private ArrayList<Date> dateList = new ArrayList<>();
	private ArrayList<Time> timeList = new ArrayList<>();
	private boolean lastPage = false;
	private int totalPageCount = 0;
	private int maxSeqNo = 0;

	public BBSList() {
	}

	public void setSeqNo(int index, int seqNo) {
		this.seqNoList.add(index, seqNo);
	}

	public void setTitle(int index, String title) {
		this.titleList.add(index, title);
	}

	public void setWriter(int index, String writer) {
		this.writerList.add(index, writer);
	}

	public void setDate(int index, Date date) {
		this.dateList.add(index, date);
	}

	public void setTime(int index, Time time) {
		this.timeList.add(index, time);
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public void setMaxSeqNo(int maxSeqNo) {
		this.maxSeqNo = maxSeqNo;
	}

	public Integer[] getSeqNo() {
		return seqNoList.toArray(new Integer[seqNoList.size()]);
	}

	public String[] getTitle() {
		return titleList.toArray(new String[titleList.size()]);
	}

	public String[] getWriter() {
		return writerList.toArray(new String[writerList.size()]);
	}

	public Date[] getDate() {
		return dateList.toArray(new Date[dateList.size()]);
	}

	public Time[] getTime() {
		return timeList.toArray(new Time[timeList.size()]);
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public int getMaxSeqNo() {
		return maxSeqNo;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public int getListSize() {
		return seqNoList.size();
	}

}
