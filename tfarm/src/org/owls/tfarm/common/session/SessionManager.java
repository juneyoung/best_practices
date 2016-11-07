package org.owls.tfarm.common.session;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class SessionManager {
	
	private Map<String, Map<String, Object>> contextSessionMap = new ConcurrentHashMap<String, Map<String, Object>>();
	
	public String generateSessionID(){
		return UUID.randomUUID().toString();
	}
	
	public void putSession(String session_id, Map<String, Object> session){
		contextSessionMap.put(session_id, session);
	}
	
	public Map<String, Object> getSession(String session_id) {
		return contextSessionMap.get(session_id);
	}
};