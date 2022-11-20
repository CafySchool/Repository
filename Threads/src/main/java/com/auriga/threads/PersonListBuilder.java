package com.auriga.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.core.Logger;

import com.auriga.log4j.Log4jSingleton;

public class PersonListBuilder {
	Logger logger = Log4jSingleton.getInstance().init();
	Scanner scanner = new Scanner(System.in);
	public List<Person> setUpList() {
		List<Person> people = new ArrayList<Person>();
		Person person1 = new Person(1, "piero", "bello");
		Person person2 = new Person(2, "paolo", "matto");
		Person person3 = new Person(3, "giorgia", "pina");
		Person person4 = new Person(4, "piera", "balla");
		Person person5 = new Person(5, "marco", "lello");
		Person person6 = new Person(6, "carlo", "monello");
		people.add(person1);
		people.add(person2);
		people.add(person3);
		people.add(person4);
		people.add(person5);
		people.add(person6);
		return people;
		
	}
	public List<Person> setUpList2() {
		List<Person> people = new ArrayList<Person>();
		Person person1 = new Person(99, "", "bello");
		Person person2 = new Person(99, "", "matto");
		Person person3 = new Person(99, "", "pina");
		Person person4 = new Person(99, "", "balla");
		Person person5 = new Person(99, "", "lello");
		Person person6 = new Person(99, "", "monello");
		people.add(person1);
		people.add(person2);
		people.add(person3);
		people.add(person4);
		people.add(person5);
		people.add(person6);
		return people;
		
	}

	public Person personbuilder() {
		Person person = new Person();
		logger.info("inserire id");
		person.setId(scanner.nextInt()); 
		scanner.nextLine();
		logger.info("inserire nome");
		person.setName(scanner.nextLine()); 
		logger.info("inserire cognome");
		person.setSurname(scanner.nextLine());
		return person;
	}
	public List<Person>  personList(int num){
		List<Person> people = new ArrayList<Person>();
		for(int i = 0; i < num; i++) {
			people.add(personbuilder());
		}
		return people;
	}
	public void  showList(List<Person> persons){
for(Person person : persons) {
	logger.info(person.getId());
	logger.info(person.getName());
	logger.info(person.getSurname());
	try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
		
	}
}
