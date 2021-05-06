package online.javabook.jvm.exception.logger;

import java.io.IOException;
import java.util.logging.*;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class LogManagerMain {

	public static void main(String[] args) throws SecurityException, IOException {
		
		// logManager
		LogManager logManager = LogManager.getLogManager();
		
		// global
		Logger global = Logger.getGlobal();
		global.info("i am a global logger.");
		
		// parent and child
		Logger parentLogger = Logger.getLogger("com.javabook");
		Logger childLogger  = Logger.getLogger("com.javabook.child");
		logManager.addLogger(parentLogger);
		logManager.addLogger(childLogger);
		
		// Handler
		parentLogger.addHandler(new FileHandler("log-parent.xml", true));		
		parentLogger.addHandler(new FileHandler("log-child.xml", true));		
		//childLogger.setUseParentHandlers(true);
		
		// parentLogger - WARNING
		parentLogger.setFilter(new Filter() {			
			@Override
			public boolean isLoggable(LogRecord record) {
				if(record.getLevel().equals(Level.WARNING))
					return true;
				else
					return false;
			}
		});
		
		parentLogger.warning("i am a parent warning logger.");
		parentLogger.info("i am a parent info logger.");
		
		// childLogger - WARNING
		childLogger.setFilter(new Filter() {			
			@Override
			public boolean isLoggable(LogRecord record) {
				if(record.getLevel().equals(Level.INFO))
					return true;
				else
					return false;
			}
		});
		
		childLogger.warning( "i am a child  warning logger.");	
		childLogger.info( "i am a child  info logger.");
	}
}
