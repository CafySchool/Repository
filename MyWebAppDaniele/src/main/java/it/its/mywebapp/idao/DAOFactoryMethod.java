package it.its.mywebapp.idao;

import it.its.mywebapp.dao.impl.EventformDAOImpl;
import it.its.mywebapp.dao.impl.WebformDAOImpl;

public class DAOFactoryMethod {
	private IWebformDAO iWebformDao;
	private IEventformDAO iEventformDao;
	static private class InstanceHolder {
		static public DAOFactoryMethod instance = new DAOFactoryMethod();
	}

	static public DAOFactoryMethod getInstance() {
		return InstanceHolder.instance;
	}
	private DAOFactoryMethod() {
		this.iWebformDao = new WebformDAOImpl();
		this.iEventformDao = new EventformDAOImpl();
	}
	public IWebformDAO getWebformDAO() {
		
		return iWebformDao;
	}
public IEventformDAO getEventformDAO() {
		
		return iEventformDao;
	}
}
