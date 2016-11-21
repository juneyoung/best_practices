package org.owls.tfarm.member.service;

import java.util.List;
import java.util.Map;

import org.owls.tfarm.common.action.CommonService;
import org.owls.tfarm.member.dao.MongoMemberDao;
import org.owls.tfarm.mongo.documents.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 여기서의 고민은 dao 단계에서 이미 throws한 에러에 대한 처리임 
// 1. try catch 로 싸서 controller 단에서 처리할 부분까지 처리함 (예를 들면 result : 500 같은거 )
// 2. 어차피 에러는 에러니까 throws 하고 controller 에서 핸들링함 
@Service
public class MongoMemberService implements CommonService<String, User, Exception> {
	
	@Autowired
	MongoMemberDao dao;

	@Override
	public User read(String key) throws Exception {
		return dao.read(key);
	}

	@Override
	public List<User> list(String key) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(key);
	}

	@Override
	public void create(User value) throws Exception {
		dao.create(value);
	}
	
	public void create(Map<?, ?> value) throws Exception {
		String id = String.valueOf(value.get("id"));
		String name = String.valueOf(value.get("id"));
		String password = String.valueOf(value.get("id"));
		String professional = String.valueOf(value.get("id"));
		String email = String.valueOf(value.get("id"));
		User user = new User(id, name, password, professional, email);
		dao.create(user);
	}

	@Override
	public void update(User value) throws Exception {
		dao.update(value);
	}

	@Override
	public void delete(String key) throws Exception {
		dao.delete(key);
	}
}
