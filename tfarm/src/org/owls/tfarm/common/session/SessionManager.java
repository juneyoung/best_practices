package org.owls.tfarm.common.session;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.owls.tfarm.mongo.documents.User;

public class SessionManager {
	
	private static Map<String, User> sessionMap = 
			new ConcurrentHashMap<String, User>();
	
	private static final int SESSION_AGE = 360;
	
	public static String generateSessionID(){
		return UUID.randomUUID().toString();
	}

	// ======================================= PUT
	// 필요할까?
	public static void putSessionUser(String session_id, User user){
		putSessionUser(null, session_id, user);
	}
	
	/**
	 * request 의 HttpSession 에 session_id 어트리뷰트를 담고, 내부에 사용자 정보를 저장한다.
	 * @param request
	 * @param session_id
	 * @param user
	 */
	public static void putSessionUser(HttpServletRequest request, String session_id, User user){
		if(request != null){ 
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(SESSION_AGE);
			session.setAttribute("session_id", session_id);
		};
		sessionMap.put(session_id, user);
	}
	
	// ======================================= GET
	public static User getSessionUser(String session_id) {
		return sessionMap.get(session_id);
	}

	// ======================================= REMOVE
	public static void removeSessionUser(String session_id){
		if(sessionMap.containsKey(session_id)) sessionMap.remove(session_id);
	}
};