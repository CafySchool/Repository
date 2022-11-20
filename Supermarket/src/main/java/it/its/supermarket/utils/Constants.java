package it.its.supermarket.utils;

public class Constants {
	//MATERIAL
	public static final String GLASS = "glass";
	public static final String PAPER = "paper";
	public static final String PLASTIC = "plastic";
	//SWITCH CASE
	public static final String ZERO = "0";
	public static final String ONE = "1";
	public static final String TWO = "2";
	public static final String THREE = "3";
	public static final String FOUR = "4";
	public static final String FIVE = "5";
	//STRING
	public static final String INSERT = "Inserire ";
	public static final String NAME = "nome";
	public static final String PRICE = "prezzo";
	public static final String YEAR = "anno";
	public static final String MATERIAL = "materiale";
	public static final String BADGE = "badge";
	public static final String CLOSE = "Cassa Chiusa";
	public static final String INVALID = "Inserimento non valido";
	public static final String PRODUCT = "nuovo prodotto";
	public static final String PRODUCTLIST = "visualizza elenco prodotti";
	public static final String TOTAL = "totale";
	public static final String FOOD = "Se il prodotto è un cibo";
	public static final String RECYCLABLE = "Se il prodotto è riciclabile";
	public static final String SIMPLEPRODUCT = "Se il prodotto non è ne riciclabile ne un cibo";
	//VALIDAZIONI
	public static final String CHECKBADGE = "^(?i)(true|false)$";
	//DATABASE
	public static final String URL = "jdbc:postgresql://127.0.0.1:5432/Supermarket";
	public static final String USERNAME = "postgres";
	public static final String PASSWORD = "=7N8H`9u9$E?JCWM";
	public static final String INSERT_productdb = "INSERT INTO productdb";
	public static final String COLUMNS = "  (description, code, price) VALUES ";
	public static final String VALUES = " (?, ?, ?);";
	public static final String QUERY = "SELECT code, description, price FROM productdb;";
			
	
}
