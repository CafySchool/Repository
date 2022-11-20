package it.myproject.util;

public class Constant {
	private Constant() {
	}

	public static final String GLASS = "glass";
	public static final String PAPER = "paper";
	public static final String PLASTIC = "plastic";
	public static final String INSERTYEAR = "^(19|20)\\d{2}$";
	public static final String INSERTMONTH = "(^[1-9]$)|(^0[1-9]|1[0-2]$)";
	public static final String INSERTDAY = "^(0?[1-9]|[12][0-9]|3[01])$";
	public static final String CHECKPRICE = "[0-9]{1,13}(\\.[0-9]*)?";
	public static final String CHECKBADGE = "^(?i)(true|false)$";
	public static final String URL = "jdbc:postgresql://127.0.0.1:5432/";
	public static final String USERNAME = "postgres";
	public static final String PASSWORD = "Hg+bUB6";
}
