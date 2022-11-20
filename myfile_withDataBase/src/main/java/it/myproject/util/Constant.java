package it.myproject.util;

public class Constant {
	private Constant() {
	}

	public static final String GLASS = "glass";
	public static final String PAPER = "paper";
	public static final String PLASTIC = "plastic";
	public static final String ZERO = "0";
	public static final String ONE = "1";
	public static final String TWO = "2";
	public static final String THREE = "3";
	public static final String FOUR = "4";
	public static final String FIVE = "5";
	public static final String INSERTYEAR = "^(19|20)\\d{2}$";
	public static final String INSERTMONTH = "(^[1-9]$)|(^0[1-9]|1[0-2]$)";
	public static final String INSERTDAY = "^(0?[1-9]|[12][0-9]|3[01])$";
	public static final String CHECKPRICE = "[0-9]{1,13}(\\.[0-9]*)?";
	public static final String CHECKSTRING = "^[a-zA-Z0-9]{1,30}$";
	public static final String CHECKCODE = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";
	public static final String CHECKBADGE = "^(?i)(true|false)$";
	public static final String URL = "jdbc:postgresql://127.0.0.1:5432/ListaSpesa";
	public static final String USERNAME = "postgres";
	public static final String PASSWORD = "=7N8H`9u9$E?JCWM";
}
