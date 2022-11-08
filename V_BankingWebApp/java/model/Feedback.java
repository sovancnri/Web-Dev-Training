package model;

public class Feedback {

	private int feedid;
	private String feedname;
	private String feedmessage;

	public Feedback() {
		super();
	}

	public Feedback(int feedid, String feedname, String feedmessage) {
		super();
		this.feedid = feedid;
		this.feedname = feedname;
		this.feedmessage = feedmessage;
	}

	public int getFeedid() {
		return feedid;
	}

	public void setFeedid(int feedid) {
		this.feedid = feedid;
	}

	public String getFeedname() {
		return feedname;
	}

	public void setFeedname(String feedname) {
		this.feedname = feedname;
	}

	public String getFeedmessage() {
		return feedmessage;
	}

	public void setFeedmessage(String feedmessage) {
		this.feedmessage = feedmessage;
	}

	@Override
	public String toString() {
		return "Feedback [feedid=" + feedid + ", feedname=" + feedname + ", feedmessage=" + feedmessage + "]";
	}

}
