package it.its.esercitazione.idao;

import it.its.esercitazione.dao.impl.PersonDAOImpl;

public class DAOFactoryMethod {
	private IPersonDAO iPersonDao;
	//private IEventformDAO iEventformDao;
	static private class InstanceHolder {
		static public DAOFactoryMethod instance = new DAOFactoryMethod();
	}

	static public DAOFactoryMethod getInstance() {
		return InstanceHolder.instance;
	}
	private DAOFactoryMethod() {
		this.iPersonDao = new PersonDAOImpl();
	}
	public IPersonDAO getPersonDAO() {
		
		return iPersonDao;
	}

}
