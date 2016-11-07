package org.owls.tfarm.member.dao;

import java.util.List;
import java.util.Map;

import org.owls.tfarm.common.action.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MongoMemberDao implements CommonDao<String, Map<String, Object>, Exception> {
	
	@Autowired
	MongoTemplate template;
	
	final String COLLECTION_NAME = "user";

	//findOne
	//VO 를 필수적으로 만들어주는게 옳은건지 모르겠다. Map을 사용할 경우, Generic type 에 대해 unchecked 를 해야함
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> read(String key) throws Exception {
		Query findQuery = new Query();
		findQuery.addCriteria(Criteria.where("id").is(key));
		return template.findOne(findQuery, Map.class, COLLECTION_NAME);
	}

	//findAll
	@Override
	public List<Map<String, Object>> list(String key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Map<String, Object> value) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Map<String, Object> value) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(String key) throws Exception {
		// TODO Auto-generated method stub
	}
};