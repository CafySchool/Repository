package com.auriga.threads;

public class FirstThread implements Runnable {

	PersonListBuilder personListBuilder;
	public FirstThread(PersonListBuilder plb) {
		personListBuilder = plb;
	}
	public void run() {
		synchronized (personListBuilder) {
			personListBuilder.showList(personListBuilder.setUpList());
		}
		
		//PersonListBuilder personListBuilder = new PersonListBuilder();
		//personListBuilder.personbuilder();
		//personListBuilder.showList(personListBuilder.personList(5));
		//personListBuilder.showList(personListBuilder.setUpList());
		
	}

}
