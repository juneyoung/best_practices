package org.owls.tfarm.member.service;

import java.util.Map;

import org.owls.tfarm.common.action.CommonService;
import org.owls.tfarm.member.dao.MongoMemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 여기서의 고민은 dao 단계에서 이미 throws한 에러에 대한 처리임 
// 1. try catch 로 싸서 controller 단에서 처리할 부분까지 처리함 (예를 들면 result : 500 같은거 )
// 2. 어차피 에러는 에러니까 throws 하고 controller 에서 핸들링함 
@Service
public class MongoMemberService implements CommonService<String, Map<String, Object>, Exception> {
	
	@Autowired
	MongoMemberDao dao;
	
	public Map<String, Object> read(String id) throws Exception {
		Map<String, Object> user = dao.read(id);
		logger.info("Read user by ID [ " + String.valueOf(id) + " ]");
		logger.info("Read user Result [ " + String.valueOf(user) + " ]");
		return user;
	}
}
