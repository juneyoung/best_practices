package org.owls.tfarm.init.listener;

import java.util.UUID;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

@WebListener
public class FarmSessionListener implements HttpSessionListener {
	
	private long sessionCount;	//이걸 외부에서 어떻게 호출할 수 있지?
	private Logger logger = Logger.getLogger(FarmSessionListener.class);
	
	private String generateSessionID(){
		return UUID.randomUUID().toString();
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession currentSession = arg0.getSession();
		String session_id = generateSessionID();
		currentSession.setAttribute("session_id", session_id);
		logger.info("HttpSession [" + session_id + "] created");
		sessionCount++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		logger.info("HttpSession [" + String.valueOf(arg0.getSession().getAttribute("session_id")) + "] created");
		sessionCount--;
	}
	
	public long getSessionCount(){
		return this.sessionCount;
	}
};