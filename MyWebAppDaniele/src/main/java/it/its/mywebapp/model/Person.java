package it.its.mywebapp.model;

// CLASSE POJO (Plain Old Java Object)
// NIENTE LOGICA O ELABORAZIONE
// SOLO PROPRIETA' E METODI GET E SET
// SERVE SOLO PER CONSERVARE DATI
public class Person {
	private int id;
	private String name;
	private String surname;
	private int age;
	private String sex;
	private String province;
	private String email;

	public Person(int id, String name, String surname, int age, String sex, String province, String email) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.sex = sex;
		this.province = province;
		this.email = email;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", age=" + age + ", sex=" + sex + ", province="
				+ province + ", email=" + email + "]";
	}

}
