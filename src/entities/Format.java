package entities;

import java.util.Collection;

public class Format {

	private int IdFormat;
	private String format;
	
	public Format(int IdFormat ,String format) {
		this.IdFormat = IdFormat;
		this.format = format;
	}

	public static Collection<? extends Training> values() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getformat() {
		return format;
	}

	public void setformat(String format) {
		this.format = format;
	}

	public static Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setIdFormat(int IdFormat) {
		this.IdFormat = IdFormat;
	}
	
	public int getIdFormat() {
		// TODO Auto-generated method stub
		return IdFormat;
	}

}
