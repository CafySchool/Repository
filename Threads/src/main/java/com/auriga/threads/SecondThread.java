package com.auriga.threads;

public class SecondThread implements Runnable {

	PersonListBuilder personListBuilder;
	public SecondThread(PersonListBuilder plb) {
		personListBuilder = plb;
	}
	public void run() {
		synchronized (personListBuilder) {
			personListBuilder.showList(personListBuilder.setUpList2());
		}
		
		//PersonListBuilder personListBuilder = new PersonListBuilder();
		//personListBuilder.personbuilder();
		//personListBuilder.showList(personListBuilder.personList(5));
		//personListBuilder.showList(personListBuilder.setUpList());
		
	}

}
