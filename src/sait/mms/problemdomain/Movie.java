package sait.mms.problemdomain;

public class Movie {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	private int id;
	private int duration;
	private String title;
	private String year;

	public Movie(int id, int duration, String title, String year) {
		this.id = id;
		this.duration = duration;
		this.title = title;
		this.year = year;
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		String toString = String.format("%d,%d,%s,%s", id, duration, title, year);
		return toString;

	}
}
