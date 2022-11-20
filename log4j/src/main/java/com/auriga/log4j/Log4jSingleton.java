package com.auriga.log4j;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;


import com.auriga.utils.Constants;

public class Log4jSingleton {
    private Log4jSingleton() {
    }
    private static class SingletonHelper {
        private static final Log4jSingleton INSTANCE = new Log4jSingleton();
    }
    public static Log4jSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
    public Logger init () {	
    	 Logger logger = (Logger) LogManager.getLogger(Log4jSingleton.class);
         LoggerContext context = (LoggerContext) LogManager.getContext(false);
         File file = new File(Constants.CONFIGUREPATH);
         context.setConfigLocation(file.toURI());
		return logger;
    }

	public static void main(String[] args) {
		Logger logger = Log4jSingleton.getInstance().init();
		logger.info("pino");
	}

}
