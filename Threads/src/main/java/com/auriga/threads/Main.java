package com.auriga.threads;

import org.apache.logging.log4j.core.Logger;

import com.auriga.log4j.Log4jSingleton;

public class Main {
	
	public static void main(String[] args) {
		Logger logger = Log4jSingleton.getInstance().init();
		PersonListBuilder personListBuilder = new PersonListBuilder();
		logger.warn("BEGIN");
		Runnable r = new FirstThread(personListBuilder);
		Thread task = new Thread(r);
		task.start();
		Runnable r2 = new SecondThread(personListBuilder);
		Thread task2 = new Thread(r2);
		task2.start();
		/*try {
			task.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		logger.warn("END");
		}

	}


