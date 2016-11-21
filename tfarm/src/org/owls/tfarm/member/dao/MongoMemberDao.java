package org.owls.tfarm.member.dao;

import java.util.List;

import org.owls.tfarm.common.action.CommonDao;
import org.owls.tfarm.mongo.documents.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MongoMemberDao implements CommonDao<String, User, Exception> {
	
	@Autowired
	MongoTemplate template;
	
	final String COLLECTION_NAME = "user";

	//findOne
	//VO 를 필수적으로 만들어주는게 옳은건지 모르겠다. Map을 사용할 경우, Generic type 에 대해 unchecked 를 해야함
	@Override
	public User read(String key) throws Exception {
		Query findOneQuery = new Query();
		findOneQuery.addCriteria(Criteria.where("id").is(key));
		return template.findOne(findOneQuery, User.class, COLLECTION_NAME);
	}

	//findAll
	@Override
	public List<User> list(String key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(User value) throws Exception {
		// template.save(value, COLLECTION_NAME); - save 를 사용하면 안되는데 
		// 이유는 save는 키가 같은 칼럼이 있으면 업데이트 하기 때문 
		template.insert(value, COLLECTION_NAME);
	}

	@Override
	public void update(User value) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(String key) throws Exception {
		// TODO Auto-generated method stub
	}
};